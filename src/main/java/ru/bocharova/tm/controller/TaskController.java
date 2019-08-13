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
import ru.bocharova.tm.api.service.ITaskService;
import ru.bocharova.tm.enumerate.Status;
import ru.bocharova.tm.exception.AuthenticationSecurityException;
import ru.bocharova.tm.exception.DataValidateException;
import ru.bocharova.tm.model.entity.Task;
import ru.bocharova.tm.model.entity.User;
import ru.bocharova.tm.util.DateFormatter;
import ru.bocharova.tm.util.FieldConst;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class TaskController {


    @NotNull
    @Autowired
    private IProjectService projectService;

    @NotNull
    @Autowired
    private ITaskService taskService;

    @NotNull
    @Autowired
    private ISessionService sessionService;

    @RequestMapping(value = {"task/read"}, method = RequestMethod.GET)
    public ModelAndView taskRead(
            @NotNull final HttpSession session,
            @NotNull final HttpServletRequest request,
            @NotNull final HttpServletResponse response
    ) throws IOException {
        @NotNull final ModelAndView model = new ModelAndView("task/taskEdit");
        try {
            sessionService.validate(session);
            @NotNull final User loggerUser = (User) session.getAttribute(FieldConst.USER);
            @NotNull final String taskId = request.getParameter(FieldConst.TASK_ID);
            @NotNull final Task task = taskService.findOne(taskId, loggerUser.getId());
            model.addObject(FieldConst.TASK, task);
            model.addObject(FieldConst.PROJECTS, projectService.findAllByUserId(loggerUser.getId()));
        } catch (AuthenticationSecurityException e) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
        } catch (DataValidateException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, e.getMessage());
        }
        return model;
    }

    @RequestMapping(value = {"task/edit"}, method = RequestMethod.POST)
    public String taskUpdate(
            @NotNull final HttpSession session,
            @NotNull final HttpServletRequest request,
            @NotNull final HttpServletResponse response
    ) throws IOException {
        @NotNull String projectId = null;
        try {
            sessionService.validate(session);
            @NotNull final User loggerUser = (User) session.getAttribute(FieldConst.USER);
            projectId = request.getParameter(FieldConst.PROJECT_ID);
            @NotNull final Task task = new Task(
                    request.getParameter(FieldConst.NAME),
                    request.getParameter(FieldConst.DESCRIPTION),
                    DateFormatter.format(request.getParameter(FieldConst.DATE_BEGIN)),
                    DateFormatter.format(request.getParameter(FieldConst.DATE_END)),
                    Status.valueOf(request.getParameter(FieldConst.STATUS)),
                    projectId,
                    loggerUser.getId());
            task.setId(request.getParameter(FieldConst.TASK_ID));
            if (projectId == null || projectId.isEmpty() || "null".equals(projectId)) {
                task.setProjectId(null);
                taskService.edit(request.getParameter(FieldConst.TASK_ID));
                return "redirect:/task/list";
            }
            taskService.edit(request.getParameter(FieldConst.TASK_ID));
        } catch (AuthenticationSecurityException e) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
        } catch (DataValidateException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, e.getMessage());
        }
        return "redirect:/task/list?" + FieldConst.PROJECT_ID + "=" + projectId;
    }

    @RequestMapping(value = {"task/create"}, method = RequestMethod.POST)
    public String taskCreate(
            @NotNull final HttpSession session,
            @NotNull final HttpServletRequest request,
            @NotNull final HttpServletResponse response
    ) throws IOException {
        @Nullable String projectId = null;
        try {
            sessionService.validate(session);
            @NotNull final User loggerUser = (User) session.getAttribute(FieldConst.USER);
            projectId = request.getParameter(FieldConst.PROJECT_ID);
            @NotNull final Task task = new Task();
            if (projectId == null || projectId.isEmpty() || "null".equals(projectId)) {
                task.setProjectId(null);
                taskService.create(loggerUser.getId(), loggerUser.getId(), "New Task1", "New descrp1");
                return "redirect:/task/list";
            }
            taskService.create(loggerUser.getId(), loggerUser.getId(), "New Task1", "New descrp1");
        } catch (AuthenticationSecurityException e) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
        } catch (DataValidateException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, e.getMessage());
        }
        return "redirect:/task/list?" + FieldConst.PROJECT_ID + "=" + projectId;
    }

    @RequestMapping(value = {"task/delete"}, method = RequestMethod.POST)
    public String taskDelete(
            @NotNull final HttpSession session,
            @NotNull final HttpServletRequest request,
            @NotNull final HttpServletResponse response
    ) throws IOException {
        @Nullable String projectId = null;
        try {
            sessionService.validate(session);
            @NotNull final User loggerUser = (User) session.getAttribute(FieldConst.USER);
            projectId = request.getParameter(FieldConst.PROJECT_ID);
            @Nullable final String taskId = request.getParameter(FieldConst.TASK_ID);
            taskService.remove(taskId);
            if (projectId == null || projectId.isEmpty() || "null".equals(projectId)) {
                return "redirect:/task/list";
            }
        } catch (AuthenticationSecurityException e) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
        } catch (DataValidateException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, e.getMessage());
        }
        return "redirect:/task/list?" + FieldConst.PROJECT_ID + "=" + projectId;
    }
}