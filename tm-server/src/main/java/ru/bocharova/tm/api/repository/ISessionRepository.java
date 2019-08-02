package ru.bocharova.tm.api.repository;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;
import org.jetbrains.annotations.NotNull;
import ru.bocharova.tm.model.entity.Session;
import ru.bocharova.tm.model.entity.User;

import java.util.Collection;

@Repository
public interface ISessionRepository extends EntityRepository<Session, String> {

    Collection<Session> findByUser(
            @NotNull final User user);
}
