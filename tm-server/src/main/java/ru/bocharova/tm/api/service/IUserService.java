package ru.bocharova.tm.api.service;

import org.jetbrains.annotations.NotNull;
import ru.bocharova.tm.entity.User;
import ru.bocharova.tm.exception.AuthenticationSecurityException;
import ru.bocharova.tm.util.Domain;

import java.util.Collection;

public interface IUserService {

    User create(@NotNull final String login, @NotNull final String password, @NotNull final String role);

    User create(@NotNull final String id, @NotNull final String login, @NotNull final String password, @NotNull final String role);

    User edit(@NotNull final String id, @NotNull final String login, @NotNull final String password, @NotNull final String role);

    User edit(@NotNull final String id, @NotNull final String login, @NotNull final String password);

    User findByLogin(@NotNull final String login);

    void clear();

    @NotNull User findOne(@NotNull final String id);

    User remove(@NotNull final String id);

    Collection<User> findAll();

    User authenticationUser(@NotNull final String login, @NotNull final String password) throws AuthenticationSecurityException;

    void loadData();

    void saveData();

    void loadDataJaxbXml();

    void saveDataJaxbXml();

    void loadDataFasterXml();

    void saveDataFasterXml();

    void loadDataJaxbJSON();

    void saveDataJaxbJSON();

    void loadDataFasterJSON();

    void saveDataFasterJSON();

    void loadAllDataFromDomain(@NotNull final Domain domain);

    Domain saveAllDataToDomain();
}