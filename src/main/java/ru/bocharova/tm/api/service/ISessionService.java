package ru.bocharova.tm.api.service;

import org.jetbrains.annotations.Nullable;
import ru.bocharova.tm.exception.AuthenticationSecurityException;
import ru.bocharova.tm.exception.DataValidateException;

import javax.servlet.http.HttpSession;

public interface ISessionService {

    void validate(@Nullable final HttpSession  session) throws AuthenticationSecurityException;
    void validateAdmin(@Nullable final HttpSession  session) throws AuthenticationSecurityException, DataValidateException;
}