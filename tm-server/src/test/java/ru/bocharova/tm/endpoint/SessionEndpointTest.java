package ru.bocharova.tm.endpoint;

import org.apache.deltaspike.testcontrol.api.junit.CdiTestRunner;
import org.jetbrains.annotations.Nullable;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import ru.bocharova.tm.api.endpoint.ISessionEndpoint;
import ru.bocharova.tm.exception.AuthenticationSecurityException;
import ru.bocharova.tm.exception.DataValidateException;
import ru.bocharova.tm.model.dto.SessionDTO;
import ru.bocharova.tm.util.DataGenerator;
import ru.bocharova.tm.util.HashUtil;

import javax.inject.Inject;

import static org.junit.Assert.*;

@RunWith(CdiTestRunner.class)
public class SessionEndpointTest {

    @Inject
    private ISessionEndpoint sessionEndpoint;

    @Inject
    private DataGenerator dataGenerator;

    @Before
    public void setUp(){
        dataGenerator.generate();
    }

    @After
    public void tearDown(
    ) throws DataValidateException {
        dataGenerator.cleanUp();
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void sessionCRUID(
    ) throws DataValidateException, AuthenticationSecurityException {
        @Nullable SessionDTO currentSession = sessionEndpoint.openSession("admin", HashUtil.md5("admin"));//CREATE
        assertNotNull(currentSession);
        assertEquals(currentSession.getId(), sessionEndpoint.findOneSession(currentSession, currentSession.getId()).getId());//READ
        sessionEndpoint.closeSession(currentSession);//DELETE
        thrown.expect(Exception.class);
        sessionEndpoint.findOneSession(currentSession, currentSession.getId());
    }

    @Test
    public void validate(
    ) throws DataValidateException, AuthenticationSecurityException {
        @Nullable SessionDTO currentSession = sessionEndpoint.openSession("user", HashUtil.md5("user"));//CREATE
        assertNotNull(currentSession);
        thrown.expect(DataValidateException.class);
        sessionEndpoint.validateSession(null);
        sessionEndpoint.validateSession(currentSession);
        thrown.expect(AuthenticationSecurityException.class);
        sessionEndpoint.validateAdminSession(currentSession);
        currentSession = sessionEndpoint.openSession("admin", HashUtil.md5("admin"));//CREATE
        assertNotNull(currentSession);
        sessionEndpoint.validateAdminSession(currentSession);
    }

}