package ru.bocharova.tm.api.repository;

import org.jetbrains.annotations.NotNull;
import ru.bocharova.tm.entity.User;

import java.util.Collection;

public interface IUserRepository {

    User findOne(@NotNull final String id);

    Collection<User> findAll();

    Integer removeAll();

    Integer remove(@NotNull final User user);

    Integer persist(@NotNull final User user);

    Integer merge(@NotNull final User user);

    User findByLogin(@NotNull final String login);
}


