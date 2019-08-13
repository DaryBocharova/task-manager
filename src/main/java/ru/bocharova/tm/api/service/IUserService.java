package ru.bocharova.tm.api.service;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import ru.bocharova.tm.exception.AuthenticationSecurityException;
import ru.bocharova.tm.exception.DataValidateException;
import ru.bocharova.tm.model.entity.User;

@Service
public interface IUserService extends IAbstractEntityService<User> {

    User create(@NotNull final String projectId,
                @NotNull final String userId,
                @NotNull final String name,
                @NotNull final String description
    ) throws DataValidateException;

    User findOne(@NotNull final String id,
                 @NotNull final String userId
    ) throws DataValidateException;

    User remove(@NotNull final String id
    ) throws DataValidateException;

    User authenticationUser(String login, String password) throws AuthenticationSecurityException, DataValidateException;
}