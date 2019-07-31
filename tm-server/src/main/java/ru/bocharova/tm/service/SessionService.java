package ru.bocharova.tm.service;

import org.apache.deltaspike.jpa.api.transaction.Transactional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.bocharova.tm.api.repository.ISessionRepository;
import ru.bocharova.tm.api.repository.IUserRepository;
import ru.bocharova.tm.api.service.IPropertyService;
import ru.bocharova.tm.api.service.ISessionService;
import ru.bocharova.tm.model.dto.SessionDTO;
import ru.bocharova.tm.model.dto.UserDTO;
import ru.bocharova.tm.model.entity.Session;
import ru.bocharova.tm.model.entity.User;
import ru.bocharova.tm.util.DataValidator;
import ru.bocharova.tm.util.SignatureUtil;
import ru.bocharova.tm.enumerate.Role;
import ru.bocharova.tm.exception.AuthenticationSecurityException;
import ru.bocharova.tm.exception.DataValidateException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@ApplicationScoped
public class SessionService implements ISessionService {

    @NotNull
    private final IPropertyService propertyService;

    @NotNull
    final IUserRepository userRepository;

    @NotNull
    final ISessionRepository sessionRepository;

    @Inject
    public SessionService(
            @NotNull final IPropertyService propertyService,
            @NotNull final ISessionRepository sessionRepository,
            @NotNull final IUserRepository userRepository) {
        this.propertyService = propertyService;
        this.userRepository = userRepository;
        this.sessionRepository = sessionRepository;
    }

    @Override
    @Transactional
    public void clear(
    ) throws DataValidateException {
        @Nullable final Collection<Session> sessions = sessionRepository
                .findAll();
        if (sessions == null) throw new DataValidateException("Sessions not found!");
        sessions.forEach(sessionRepository::remove);
    }

    @Override
    @Transactional
    public SessionDTO findOne(
            @Nullable final String id
    ) throws DataValidateException {
        DataValidator.validateString(id);
        @Nullable final Session session = sessionRepository
                .findBy(id);
        if (session == null) throw new DataValidateException("Session not found!");
        return session.getDTO();
    }

    @Override
    @Transactional
    public void remove(
            @Nullable final String id
    ) throws DataValidateException {
        DataValidator.validateString(id);
        @Nullable final Session session = sessionRepository
                .findBy(id);
        if (session == null) throw new DataValidateException("Session not found!");
        sessionRepository
                .remove(session);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<SessionDTO> findAll(
    ) throws DataValidateException {
        @Nullable final Collection<Session> sessions = sessionRepository
                .findAll();
        if (sessions == null) throw new DataValidateException("Sessions not found!");
        return sessions
                .stream()
                .map(Session::getDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public SessionDTO create(
            @Nullable final UserDTO userDTO
    ) throws DataValidateException {
        DataValidator.validateUserDTO(userDTO, false);
        @NotNull final String cycle = propertyService.getCycle();
        @NotNull final String salt = propertyService.getSalt();
        @NotNull final Session session = new Session();
        session.setTimestamp(new Date());
        session.setUser(getUser(userDTO.getId()));
        session.setSignature(SignatureUtil.sign(userDTO, salt, Integer.parseInt(cycle)));
        sessionRepository
                .save(session);
        return session.getDTO();
    }

    @Override
    @Transactional(readOnly = true)
    public void validate(
            @Nullable final SessionDTO sessionDTO
    ) throws AuthenticationSecurityException, DataValidateException {
        DataValidator.validateSessionDTO(sessionDTO);
        if (!sessionDTO.getSignature().equals(findOne(sessionDTO.getId()).getSignature()))
            throw new AuthenticationSecurityException("SessionDTO is invalid: \nSessionDTO signature is wrong! Please re-login!");
    }

    @Override
    @Transactional(readOnly = true)
    public void validateAdmin(
            @Nullable final SessionDTO sessionDTO
    ) throws AuthenticationSecurityException, DataValidateException {
        validate(sessionDTO);
        @NotNull User user = getUser(sessionDTO.getUserId());
        if (!user.getRole().equals(Role.ADMIN))
            throw new AuthenticationSecurityException("Forbidden action for your role!");
    }

    @Transactional(readOnly = true)
    private User getUser(
            @NotNull final String userId
    ) throws DataValidateException {
        @Nullable final User user = userRepository.findBy(userId);
        if (user == null) throw new DataValidateException("User not found!");
        return user;
    }
}
