package ru.bocharova.tm.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Service;
import ru.bocharova.tm.api.service.ISessionService;
import ru.bocharova.tm.enumerate.Role;
import ru.bocharova.tm.exception.AuthenticationSecurityException;
import ru.bocharova.tm.exception.DataValidateException;
import ru.bocharova.tm.model.entity.User;
import ru.bocharova.tm.util.FieldConst;

import javax.servlet.http.HttpSession;

@Service
public class SessionService implements ISessionService {

    @Override
    public void validate(@Nullable HttpSession session)
            throws AuthenticationSecurityException {
        if (session.getAttribute(FieldConst.USER) == null)
            throw new AuthenticationSecurityException("Session is invalid!");
    }


    @Override
    public void validateAdmin(@Nullable HttpSession session) throws AuthenticationSecurityException, DataValidateException {
        validate(session);
        @NotNull final User loggedUser = (User) session.getAttribute(FieldConst.USER);
        if (!loggedUser.getRole().equals(Role.ADMIN))
            throw new AuthenticationSecurityException("Forbidden action for your role!");
    }
}
