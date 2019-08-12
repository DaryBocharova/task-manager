package ru.bocharova.tm.api.repository;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import ru.bocharova.tm.model.entity.User;

@Repository
public interface IUserRepository extends IAbstractRepository<User> {

    User findByLogin(@NotNull final String login);
}
