package ru.bocharova.tm.service;

import org.jetbrains.annotations.NotNull;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import ru.bocharova.tm.api.UnitTest;
import ru.bocharova.tm.api.service.ISessionService;
import ru.bocharova.tm.endpoint.SessionDTO;

import static org.junit.Assert.assertEquals;

@Category(UnitTest.class)
public class SessionServiceTest {

    @NotNull
    private ISessionService sessionService;

    @Before
    public void setUp() {
        sessionService = new SessionService();
    }

    @After
    public void tearDown() {
        sessionService = null;
    }

    @Test
    public void getCurrentSession() {
        @NotNull final SessionDTO session = new SessionDTO();
        @NotNull final String uuid = session.getId();
        sessionService.setCurrentSession(session);
        assertEquals(uuid, sessionService.getCurrentSession().getId());
    }

    @Test
    public void setCurrentSession() {
        @NotNull final SessionDTO session = new SessionDTO();
        @NotNull final String uuid = session.getId();
        sessionService.setCurrentSession(session);
        assertEquals(uuid, sessionService.getCurrentSession().getId());
    }
}