package ru.bocharova.tm.api.repository;

import org.jetbrains.annotations.NotNull;
import ru.bocharova.tm.entity.Session;

import java.util.Collection;

public interface ISessionRepository {

    Session findOne(@NotNull final String id);

    Collection<Session> findAll();

    Integer removeAll();

    Integer remove(@NotNull final String id);

    Integer persist(@NotNull final Session session);

    Integer merge(@NotNull final Session session);

    Collection<Session> findAllByUserId(@NotNull final String id);
}