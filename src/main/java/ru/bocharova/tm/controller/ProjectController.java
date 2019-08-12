package ru.bocharova.tm.controller;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.bocharova.tm.api.service.IProjectService;
import ru.bocharova.tm.api.service.ISessionService;
import ru.bocharova.tm.enumerate.Status;
import ru.bocharova.tm.exception.AuthenticationSecurityException;
import ru.bocharova.tm.exception.DataValidateException;
import ru.bocharova.tm.model.entity.Project;
import ru.bocharova.tm.model.entity.User;
import ru.bocharova.tm.util.DateFormatter;
import ru.bocharova.tm.util.FieldConst;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class ProjectController {
    @NotNull
    @Autowired
    private IProjectService projectService;

    @NotNull
    @Autowired
    private ISessionService sessionService;

    @RequestMapping(value = "project/create", method = {RequestMethod.POST})
    public String createProject(@NotNull final HttpSession session,
                                @NotNull final HttpServletRequest request,
                                @NotNull final HttpServletResponse response) throws IOException {
        try {
            sessionService.validate(session);
            @NotNull final User loggerUser = (User) session.getAttribute(FieldConst.USER);
            @NotNull final Project project = new Project();
            projectService.create(loggerUser.getId(), "New Project1", "New descrp");
        } catch (AuthenticationSecurityException e) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
        } catch (DataValidateException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, e.getMessage());
        }
        return "redirect:/project/list";
    }


    @RequestMapping(value = "project/read", method = {RequestMethod.GET})
    public ModelAndView readProject(@NotNull final HttpSession session,
                                    @NotNull final HttpServletResponse response
    ) throws IOException {
        @NotNull final ModelAndView modelAndView = new ModelAndView("project/projectRead");
        try {
            sessionService.validate(session);
            @NotNull final User loggerUser = (User) session.getAttribute(FieldConst.USER);
            modelAndView.addObject(FieldConst.PROJECTS, projectService.findAllByUserId(loggerUser.getId()));
        } catch (AuthenticationSecurityException e) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
        } catch (DataValidateException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, e.getMessage());
        }
        return modelAndView;
    }

    @RequestMapping(value = "project/update", method = {RequestMethod.POST})
    public String updateProject(@NotNull final HttpSession session,
                                @NotNull final HttpServletRequest request,
                                @NotNull final HttpServletResponse response) throws IOException {
        try {
            sessionService.validate(session);
            @NotNull final User loggerUser = (User) session.getAttribute(FieldConst.USER);
            @NotNull Project project = new Project(
                    request.getParameter(FieldConst.NAME),
                    request.getParameter(FieldConst.DESCRIPTION),
                    DateFormatter.format(request.getParameter(FieldConst.DATE_BEGIN)),
                    DateFormatter.format(request.getParameter(FieldConst.DATE_END)),
                    Status.valueOf(request.getParameter(FieldConst.STATUS)),
                    loggerUser.getId());
            project.setId(loggerUser.getId());
            projectService.edit(request.getParameter(FieldConst.PROJECT_ID));


        } catch (AuthenticationSecurityException e) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
        } catch (DataValidateException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, e.getMessage());
        }
        return "redirect:/project/list";
    }

    @RequestMapping(value = "project/delete", method = {RequestMethod.POST})
    public String deleteProject(
            @NotNull final HttpSession session,
            @NotNull final HttpServletRequest request,
            @NotNull final HttpServletResponse response
    ) throws IOException {
        try {
            sessionService.validate(session);
            @Nullable final String id = request.getParameter(FieldConst.PROJECT_ID);
            @NotNull final User loggedUser = (User) session.getAttribute(FieldConst.USER);
            projectService.remove(id, loggedUser.getId());
        } catch (AuthenticationSecurityException e) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
        } catch (DataValidateException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, e.getMessage());
        }
        return "redirect:/project/list";
    }
}
