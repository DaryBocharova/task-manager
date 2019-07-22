package ru.bocharova.tm.api.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.bocharova.tm.DTO.SessionDTO;
import ru.bocharova.tm.DTO.UserDTO;
import ru.bocharova.tm.exception.AuthenticationSecurityException;
import ru.bocharova.tm.exception.DataValidateException;

import java.io.IOException;
import java.util.Collection;

public interface ISessionService {

    void clear() throws DataValidateException;

    SessionDTO findOne(@NotNull final String id) throws DataValidateException;

    SessionDTO remove(@NotNull final String id) throws DataValidateException;

    Collection<SessionDTO> findAll() throws DataValidateException;

    SessionDTO create(@NotNull final UserDTO userDTO) throws IOException, DataValidateException;

    void validate(@Nullable final SessionDTO sessionDTO) throws AuthenticationSecurityException, DataValidateException;

    void validateAdmin(@Nullable final SessionDTO sessionDTO) throws AuthenticationSecurityException, DataValidateException;
}