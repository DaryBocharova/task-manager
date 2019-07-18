package ru.bocharova.tm.api.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.bocharova.tm.DTO.SessionDTO;
import ru.bocharova.tm.exception.AuthenticationSecurityException;
import ru.bocharova.tm.exception.DataValidateException;

import java.io.IOException;
import java.util.Collection;

public interface ISessionService {

    void clear() throws DataValidateException;

    SessionDTO findOne(@NotNull final String id);

    SessionDTO remove(@NotNull final String id);

    Collection<SessionDTO> findAll();

    SessionDTO create(@NotNull final String userId) throws IOException;

    void validate(@Nullable final SessionDTO session) throws AuthenticationSecurityException;

    boolean validateAdmin(@Nullable final SessionDTO session) throws AuthenticationSecurityException;
}