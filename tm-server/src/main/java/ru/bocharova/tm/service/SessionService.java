package ru.bocharova.tm.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.bocharova.tm.api.repository.ISessionRepository;
import ru.bocharova.tm.api.service.ISessionService;
import ru.bocharova.tm.enumerate.Role;
import ru.bocharova.tm.exception.AuthenticationSecurityException;
import ru.bocharova.tm.api.repository.IUserRepository;
import ru.bocharova.tm.entity.Session;
import ru.bocharova.tm.entity.User;
import ru.bocharova.tm.util.SignatureUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

public class SessionService extends AbstractEntityService<Session, ISessionRepository> implements ISessionService {

    @NotNull
    private final IUserRepository userRepository;

    public SessionService(@NotNull final ISessionRepository repository, @NotNull final IUserRepository userRepository) {
        super(repository);
        this.userRepository = userRepository;
    }

    @Override
    public Session create(@NotNull String userId) throws IOException {
        @NotNull final Properties property = new Properties();
        try (InputStream resourceStream = this.getClass().getClassLoader().getResourceAsStream("application.properties")) {
            property.load(resourceStream);
        } catch (IOException e) {
            throw new IOException(e);
        }
        @NotNull final String cycle = property.getProperty("cycle");
        @NotNull final String salt = property.getProperty("salt");
        @NotNull final Session session = new Session();
        session.setTimeStamp(new Date());
        session.setUserId(userId);
        session.setSignature(SignatureUtil.sign(session, salt, Integer.parseInt(cycle)));
        return repository.persist(session);
    }

    @Override
    public boolean validate(@Nullable Session session) throws AuthenticationSecurityException {
        if (session == null)
            throw new AuthenticationSecurityException("Сессия некорректная!");
        if (session.getSignature() == null)
            throw new AuthenticationSecurityException("Сессия некорректная!");
        if (session.getUserId() == null)
            throw new AuthenticationSecurityException("Сессия некорректная!");
        if (session.getTimeStamp() == null)
            throw new AuthenticationSecurityException("Сессия некорректная!");
        if (findOne(session.getId()) == null)
            throw new AuthenticationSecurityException("Сессия некорректная!");

        return session.getSignature().equals(findOne(session.getId()).getSignature());
    }

    @Override
    public boolean validateAdmin(@Nullable Session session) throws AuthenticationSecurityException {
        if (validate(session)) {
            User user = userRepository.findOne(session.getUserId());
            return user.getRole().equals(Role.ADMINISTRATOR);
        }
        return false;
    }
}
