package ru.bocharova.tm.api.repository;

import org.jetbrains.annotations.NotNull;
import ru.bocharova.tm.model.entity.*;

import java.util.Collection;

public interface ISessionRepository {

    Session findOne(@NotNull final String id);

    Collection<Session> findAll();

    void removeAll();

    void remove(@NotNull final Session session);

    void persist(@NotNull final Session session);

    Session merge(@NotNull final Session session);

    Collection<Session> findAllByUserId(@NotNull final User user);
}