package ru.bocharova.tm.api.repository;

import org.jetbrains.annotations.NotNull;
import ru.bocharova.tm.entity.Session;

import java.util.Collection;

public interface ISessionRepository extends IAbstractRepository<Session> {
    Collection<Session> findAllByUserId(@NotNull final String id);
}
