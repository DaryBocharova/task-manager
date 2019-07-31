package ru.bocharova.tm.service;

import org.apache.deltaspike.testcontrol.api.junit.CdiTestRunner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import ru.bocharova.tm.api.service.ISessionService;
import ru.bocharova.tm.api.service.IUserService;
import ru.bocharova.tm.exception.AuthenticationSecurityException;
import ru.bocharova.tm.exception.DataValidateException;
import ru.bocharova.tm.model.dto.SessionDTO;
import ru.bocharova.tm.model.dto.UserDTO;
import ru.bocharova.tm.util.DataGenerator;

import javax.inject.Inject;

import static org.junit.Assert.*;

@RunWith(CdiTestRunner.class)
public class SessionServiceTest {

    @Inject
    ISessionService sessionService;

    @Inject
    IUserService userService;

    @Inject
    DataGenerator dataGenerator;

    @Before
    public void setUp() {
        dataGenerator.generate();
    }

    @After
    public void tearDown() throws DataValidateException {
        dataGenerator.cleanUp();
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void sessionCRUD(
    ) throws DataValidateException {
        @Nullable final UserDTO user = userService.findByLogin("admin");
        assertNotNull(user);
        @NotNull final SessionDTO session = sessionService.create(user);
        @NotNull final String sessionId = session.getId();
        assertEquals(sessionId, sessionService.findOne(sessionId).getId());
        sessionService.remove(sessionId);
        thrown.expect(DataValidateException.class);
        sessionService.findOne(sessionId);
    }

    @Test
    public void validate() throws DataValidateException, AuthenticationSecurityException {
        @Nullable UserDTO user = userService.findByLogin("admin");
        assertNotNull(user);
        @NotNull SessionDTO session = sessionService.create(user);
        sessionService.validate(session);
        sessionService.validateAdmin(session);

        user = userService.findByLogin("user");
        assertNotNull(user);
        session = sessionService.create(user);
        sessionService.validate(session);
        thrown.expect(AuthenticationSecurityException.class);
        sessionService.validateAdmin(session);
    }
}