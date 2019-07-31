package ru.bocharova.tm.api.repository;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;
import org.jetbrains.annotations.NotNull;
import ru.bocharova.tm.model.entity.User;

@Repository
public interface IUserRepository extends EntityRepository<User, String> {

    User findAnyByLogin(
            @NotNull final String login);
}
