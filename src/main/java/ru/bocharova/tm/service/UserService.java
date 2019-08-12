package ru.bocharova.tm.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bocharova.tm.api.repository.IProjectRepository;
import ru.bocharova.tm.api.repository.IUserRepository;
import ru.bocharova.tm.api.service.IUserService;
import ru.bocharova.tm.enumerate.Role;
import ru.bocharova.tm.exception.AuthenticationSecurityException;
import ru.bocharova.tm.exception.DataValidateException;
import ru.bocharova.tm.model.entity.User;
import ru.bocharova.tm.util.DataValidator;
import ru.bocharova.tm.util.HashUtil;

@Service
public final class UserService extends AbstractEntityService<User, IUserRepository> implements IUserService {

    @NotNull
    private IProjectRepository projectRepository;

    @NotNull
    private IUserRepository userRepository;

    @Autowired
    public UserService(@NotNull final IUserRepository userRepository,
                       @NotNull final IProjectRepository projectRepository
                       ) {
        super(userRepository);
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
    }

    public User create(@NotNull final String id, @NotNull final String login, @NotNull final String password,
                       @NotNull final String role) throws DataValidateException {
        if (!DataValidator.validateString(id, login, password, role)) return null;
        if (Role.valueOf(role) == null) return null;
        User user = new User(login, HashUtil.md5(password), Role.valueOf(role));
        user.setId(id);
        return repository.persist(user);
    }

    @Override
    public User findOne(@NotNull String id,
                        @NotNull String userId
         ) throws DataValidateException {
            if (!DataValidator.validateString(id, userId)) return null;
            return repository.findOne(id);
    }

    @Override
    public User remove(@NotNull String id,
                       @NotNull String userId
    ) throws DataValidateException {
        if (!DataValidator.validateString(id, userId)) return null;
        return repository.remove(id);
    }

    @Override
    public User edit(@NotNull final String id, login, password, role) throws DataValidateException {
        if (!DataValidator.validateString(id, login, password, role)) return null;
        if (Role.valueOf(role) == null) return null;
        @NotNull
        User user = findOne(id);
        user.setLogin(login);
        user.setPassword(HashUtil.md5(password));
        user.setRole(Role.valueOf(role));
        return repository.merge(user);
    }

    public User authenticationUser(
            @Nullable final String login,
            @Nullable final String password
    ) throws AuthenticationSecurityException, DataValidateException {
        DataValidator.validateString(login, password);
        @Nullable final User user = userRepository
                .findByLogin(login);
        if (user == null) throw new AuthenticationSecurityException("Wrong user name!");
        if (!user.getPassword().equals(password)) throw new AuthenticationSecurityException("Wrong password!");
        return user;
    }
}