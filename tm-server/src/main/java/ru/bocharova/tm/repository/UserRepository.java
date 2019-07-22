package ru.bocharova.tm.repository;

import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.bocharova.tm.api.repository.IUserRepository;
import ru.bocharova.tm.model.entity.User;

import javax.persistence.EntityManager;
import java.util.Collection;

@AllArgsConstructor
public final class UserRepository implements IUserRepository {

    @NotNull
    private final EntityManager entityManager;

    @Override
    public User findOne(@NotNull String id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public Collection<User> findAll() {
        return entityManager.createQuery("SELECT e FROM Project e", User.class).getResultList();
    }

    @Override
    public void removeAll() {
        Collection<User> users = findAll();
        if (users == null) return;
        users.forEach(entityManager::remove);
    }

    @Override
    public void remove(@NotNull User user) {
        entityManager.remove(user);
    }

    @Override
    public void persist(@NotNull User user) {
        entityManager.persist(user);
    }

    @Override
    public User merge(@NotNull User user) {
        return entityManager.merge(user);
    }

    @Override
    public User findByLogin(@NotNull final String login) {
        @Nullable final User user = entityManager
                .createQuery("SELECT e FROM User e WHERE e.login = :login", User.class)
                .setParameter("login", login)
                .getResultList()
                .stream()
                .findFirst()
                .orElse(null);
        return user;
    }
}
