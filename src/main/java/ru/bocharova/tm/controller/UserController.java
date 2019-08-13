package ru.bocharova.tm.controller;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.bocharova.tm.api.service.ISessionService;
import ru.bocharova.tm.api.service.IUserService;
import ru.bocharova.tm.enumerate.Role;
import ru.bocharova.tm.exception.AuthenticationSecurityException;
import ru.bocharova.tm.exception.DataValidateException;
import ru.bocharova.tm.model.entity.Project;
import ru.bocharova.tm.model.entity.User;
import ru.bocharova.tm.util.FieldConst;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class UserController {


    @NotNull
    @Autowired
    private IUserService userService;

    @NotNull
    @Autowired
    private ISessionService sessionService;

    @RequestMapping(value = {"user/login"}, method = {RequestMethod.POST})
    public ModelAndView userLogin(
            @NotNull final HttpSession session,
            @NotNull final HttpServletRequest request,
            @NotNull final HttpServletResponse response
    ) throws IOException {
        @NotNull final ModelAndView model = new ModelAndView("index");
        @NotNull final String login = request.getParameter(FieldConst.LOGIN);
        @NotNull final String password = request.getParameter(FieldConst.PASSWORD);
        try {
            @NotNull final User loggerUser = userService.authenticationUser(login, password);
            session.setAttribute(FieldConst.USER, loggerUser);
        } catch (AuthenticationSecurityException e) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
        } catch (DataValidateException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, e.getMessage());
        }
        return model;
    }

    @RequestMapping(value = {"user/edit"}, method = {RequestMethod.GET})
    public ModelAndView userEdit(
            @NotNull final HttpSession session,
            @NotNull final HttpServletRequest request,
            @NotNull final HttpServletResponse response
    ) throws IOException {
        @NotNull final ModelAndView model = new ModelAndView("user/userEdit");
        try {
            sessionService.validate(session);
            @NotNull final User loggedUser = (User) session.getAttribute(FieldConst.USER);
            @Nullable final String userId = request.getParameter(FieldConst.USER_ID);
            if (!loggedUser.getId().equals(userId)) sessionService.validateAdmin(session);
            @NotNull final User user = userService.findOne(userId);
            model.addObject(FieldConst.USER, user);
        } catch (AuthenticationSecurityException e) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
        } catch (DataValidateException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, e.getMessage());
        }
        return model;
    }

    @RequestMapping(value = {"user/edit"}, method = {RequestMethod.POST})
    public String userUpdate(
            @NotNull final HttpSession session,
            @NotNull final HttpServletRequest request,
            @NotNull final HttpServletResponse response
    ) throws IOException {
        try {
            sessionService.validate(session);
            @NotNull final User loggedUser = (User) session.getAttribute(FieldConst.USER);
            @Nullable final String userId = request.getParameter(FieldConst.USER_ID);
            if (!loggedUser.getId().equals(userId)) sessionService.validateAdmin(session);
            @NotNull final User user = new User(
                    request.getParameter(FieldConst.LOGIN),
                    request.getParameter(FieldConst.PASSWORD),
                    request.getParameter(FieldConst.NAME),
                    request.getParameter(FieldConst.DESCRIPTION),
                    Role.valueOf(request.getParameter(FieldConst.ROLE)));
            user.setId(userId);
            userService.edit(user.getId());
            if (!loggedUser.getId().equals(userId)) {
                return "redirect:/user/list";
            }
        } catch (AuthenticationSecurityException e) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
        } catch (DataValidateException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, e.getMessage());
        }
        return "redirect:/";
    }

    @RequestMapping(value = {"user/logout"}, method = {RequestMethod.POST})
    public String userLogout(
            @NotNull final HttpSession session
    ) {
        session.invalidate();
        return "redirect:/";
    }

    @RequestMapping(value = {"user/list"}, method = RequestMethod.GET)
    public ModelAndView userList(
            @NotNull final HttpSession session,
            @NotNull final HttpServletResponse resp
    ) throws IOException {
        @NotNull final ModelAndView model = new ModelAndView("user/userList");
        try {
            sessionService.validateAdmin(session);
            model.addObject(FieldConst.USERS, userService.findAll());
        } catch (AuthenticationSecurityException e) {
            resp.sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
        } catch (DataValidateException e) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, e.getMessage());
        }
        return model;
    }

    @RequestMapping(value = {"user/create"}, method = RequestMethod.POST)
    public String userCreate(
            @NotNull final HttpSession session,
            @NotNull final HttpServletRequest request,
            @NotNull final HttpServletResponse response
    ) throws IOException {
        try {
            sessionService.validateAdmin(session);
            @NotNull final User user = new User(
                    "New User:",
                    "password",
                    "New user name",
                    "Description for new user",
                    Role.USER);
            @NotNull final Project project = new Project();
            user.setLogin("New User:" + user.getId());
            userService.create(project.getId(), user.getId(), "VAsya", "Petya");
        } catch (AuthenticationSecurityException e) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
        } catch (DataValidateException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, e.getMessage());
        }
        return "redirect:/user/list";
    }

    @RequestMapping(value = {"user/delete"}, method = RequestMethod.POST)
    public String userDelete(
            @NotNull final HttpSession session,
            @NotNull final HttpServletRequest request,
            @NotNull final HttpServletResponse response
    ) throws IOException {
        try {
            sessionService.validateAdmin(session);
            userService.remove(request.getParameter(FieldConst.USER_ID));
        } catch (AuthenticationSecurityException e) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
        } catch (DataValidateException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, e.getMessage());
        }
        return "redirect:/user/list";
    }

    @RequestMapping(value = {"user/register"}, method = RequestMethod.GET)
    public ModelAndView userRegister(
    ) {
        @NotNull final ModelAndView model = new ModelAndView("user/userRegister");
        return model;
    }

    @RequestMapping(value = {"user/register"}, method = RequestMethod.POST)
    public ModelAndView userRegister(
            @NotNull final HttpSession session,
            @NotNull final HttpServletRequest request,
            @NotNull final HttpServletResponse response
    ) throws IOException {
        @NotNull final ModelAndView model = new ModelAndView("user/userSuccessRegister");
        try {
            @NotNull final User user = new User(
                    request.getParameter(FieldConst.LOGIN),
                    request.getParameter(FieldConst.PASSWORD),
                    request.getParameter(FieldConst.NAME),
                    request.getParameter(FieldConst.DESCRIPTION),
                    Role.USER);
            @NotNull final Project project = new Project();
            userService.create(project.getId(), user.getId(), "VAsya", "Petya");
            model.addObject(FieldConst.USER, user);
        } catch (DataValidateException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, e.getMessage());
        }
        return model;
    }

}