package ru.bocharova.tm.repository;

import org.jetbrains.annotations.NotNull;
import ru.bocharova.tm.api.repository.IUserRepository;
import ru.bocharova.tm.entity.User;

public final class UserRepository extends AbstractRepository<User> implements IUserRepository {

    @Override
    public User findByLogin(@NotNull final String login) {
        for (User user : findAll()) if (login.equals(user.getLogin())) return user;
        return null;
    }
}
