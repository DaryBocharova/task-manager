package ru.bocharova.tm.api.service;

import org.jetbrains.annotations.NotNull;
import ru.bocharova.tm.model.dto.*;
import ru.bocharova.tm.exception.AuthenticationSecurityException;
import ru.bocharova.tm.exception.DataValidateException;

import java.util.Collection;

public interface IUserService {

    void create(@NotNull final UserDTO userDTO) throws DataValidateException;

    void edit(@NotNull final UserDTO userDTO) throws DataValidateException;

    UserDTO findByLogin(@NotNull final String login) throws DataValidateException;

    void clear() throws DataValidateException;

    @NotNull UserDTO findOne(@NotNull final String id) throws DataValidateException;

    void remove(@NotNull final String id) throws DataValidateException;

    Collection<UserDTO> findAll() throws DataValidateException;

    UserDTO authenticationUser(@NotNull final String login, @NotNull final String password) throws AuthenticationSecurityException, DataValidateException;
}