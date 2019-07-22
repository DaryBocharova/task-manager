package ru.bocharova.tm.repository;

import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.bocharova.tm.api.repository.ISessionRepository;
import ru.bocharova.tm.entity.Session;
import ru.bocharova.tm.entity.User;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Collection;

@AllArgsConstructor
public class SessionRepository implements ISessionRepository {

    @NotNull
    private final EntityManager entityManager;

    @Override
    public Session findOne(@NotNull String id) {
        return entityManager.find(Session.class, id);
    }

    @Override
    public Collection<Session> findAll() {
        return entityManager.createQuery("SELECT e FROM Project e", Session.class).getResultList();
    }

    @Override
    public void removeAll() {
        Collection<Session> users = findAll();
        if (users == null) return;
        users.forEach(entityManager::remove);
    }

    @Override
    public void remove(@NotNull Session session) {
        entityManager.remove(session);
    }

    @Override
    public void persist(@NotNull Session session) {
        entityManager.persist(session);
    }

    @Override
    public Session merge(@NotNull Session session) {
        return entityManager.merge(session);
    }

    @Override
    public Collection<Session> findAllByUserId(
            @NotNull User user) {
        @Nullable final Collection<Session> sessions = entityManager
                .createQuery("SELECT e FROM Session e WHERE e.user = :user", Session.class)
                .setParameter("user", user)
                .getResultList();
        return sessions;
    }
}
