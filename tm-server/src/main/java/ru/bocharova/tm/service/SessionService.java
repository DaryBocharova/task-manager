package ru.bocharova.tm.service;

import lombok.AllArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.bocharova.tm.DTO.SessionDTO;
import ru.bocharova.tm.DTO.UserDTO;
import ru.bocharova.tm.api.repository.ISessionRepository;
import ru.bocharova.tm.api.service.IPropertyService;
import ru.bocharova.tm.api.service.ISessionService;
import ru.bocharova.tm.enumerate.Role;
import ru.bocharova.tm.exception.AuthenticationSecurityException;
import ru.bocharova.tm.api.repository.IUserRepository;
import ru.bocharova.tm.entity.Session;
import ru.bocharova.tm.entity.User;
import ru.bocharova.tm.exception.DataValidateException;
import ru.bocharova.tm.repository.SessionRepository;
import ru.bocharova.tm.repository.UserRepository;
import ru.bocharova.tm.util.SignatureUtil;
import ru.bocharova.tm.util.StringValidator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@AllArgsConstructor
public class SessionService implements ISessionService {

    @NotNull
    final EntityManagerFactory entityManagerFactory;
    @NotNull
    final IPropertyService propertyService;

    @Override
    public void clear()
            throws DataValidateException {
        @NotNull final EntityManager entityManager = entityManagerFactory.createEntityManager();
        @NotNull final ISessionRepository sessionRepository = new SessionRepository(entityManager);
        try {
            entityManager.getTransaction().begin();
            sessionRepository
                    .removeAll();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new DataValidateException(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    @Override
    public SessionDTO findOne(@NotNull String id) throws DataValidateException {
        @NotNull final EntityManager entityManager = entityManagerFactory.createEntityManager();
        @NotNull final ISessionRepository sessionRepository = new SessionRepository(entityManager);
        try {
            entityManager.getTransaction().begin();
            @Nullable final Session session = sessionRepository
                    .findOne(id);
            if (session == null) throw new DataValidateException("Session not found!");
            entityManager.getTransaction().commit();
            return session.getDTO();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new DataValidateException(e.getMessage());
        } finally {
            entityManager.close();
        }
    }


    @Override
    public SessionDTO remove(@NotNull final String id) throws DataValidateException {
        @NotNull final EntityManager entityManager = entityManagerFactory.createEntityManager();
        @NotNull final ISessionRepository sessionRepository = new SessionRepository(entityManager);
        try {
            entityManager.getTransaction().begin();
            @Nullable final Session session = sessionRepository
                    .findOne(id);
            if (session == null) throw new DataValidateException("Session not found!");
            entityManager.getTransaction().begin();
            sessionRepository.remove(session);
            entityManager.getTransaction().commit();
            return session.getDTO();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new DataValidateException(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Collection<SessionDTO> findAll() throws DataValidateException {
        @NotNull final EntityManager entityManager = entityManagerFactory.createEntityManager();
        @NotNull final ISessionRepository sessionRepository = new SessionRepository(entityManager);
        try {
            entityManager.getTransaction().begin();
            @Nullable final Collection<Session> sessions = sessionRepository
                    .findAll();
            if (sessions == null) throw new DataValidateException("Sessions not found!");
            entityManager.getTransaction().commit();
            return sessions
                    .stream()
                    .map(Session::getDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new DataValidateException(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    @Override
    public SessionDTO create(
            @Nullable final UserDTO userDTO)
            throws DataValidateException {
        @NotNull final String cycle = propertyService.getCycle();
        @NotNull final String salt = propertyService.getSalt();
        @NotNull final EntityManager entityManager = entityManagerFactory.createEntityManager();
        @NotNull final ISessionRepository sessionRepository = new SessionRepository(entityManager);
        try {
            entityManager.getTransaction().begin();
            @NotNull final Session session = new Session();
            session.setTimestamp(new Date());
            session.setUser(getUser(userDTO.getId(), entityManager));
            session.setSignature(SignatureUtil.sign(userDTO, salt, Integer.parseInt(cycle)));
            sessionRepository
                    .persist(session);
            entityManager.getTransaction().commit();
            return session.getDTO();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new DataValidateException(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void validate(
            @Nullable final SessionDTO sessionDTO)
            throws AuthenticationSecurityException, DataValidateException {
        if (!sessionDTO.getSignature().equals(findOne(sessionDTO.getId()).getSignature()))
            throw new AuthenticationSecurityException("SessionDTO is invalid: \nSessionDTO signature is wrong! Please re-login!");
    }

    @Override
    public void validateAdmin(
            @Nullable final SessionDTO sessionDTO)
            throws AuthenticationSecurityException, DataValidateException {
        validate(sessionDTO);
        @NotNull final EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            @NotNull User user = getUser(sessionDTO.getUserId(), entityManager);
            if (!user.getRole().equals(Role.ADMINISTRATOR))
                throw new AuthenticationSecurityException("Forbidden action for your role!");
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new DataValidateException(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    private User getUser(@NotNull final String userId, @NotNull final EntityManager em) throws DataValidateException {
        @NotNull final IUserRepository userRepository = new UserRepository(em);
        @Nullable final User user = userRepository.findOne(userId);
        if (user == null) throw new DataValidateException("User not found!");
        return user;
    }
}