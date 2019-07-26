package ru.bocharova.tm.endpoint;

import org.jetbrains.annotations.NotNull;
import org.junit.*;
import org.junit.experimental.categories.Category;
import ru.bocharova.tm.api.IntegrationTest;
import ru.bocharova.tm.api.service.IEndpointProducerService;
import ru.bocharova.tm.service.EndpointProducerService;
import ru.bocharova.tm.util.HashUtil;

import java.util.*;

import static org.junit.Assert.*;

@Category(IntegrationTest.class)
public class ProjectEndpointTest {

    @NotNull
    private ProjectEndpoint projectEndpoint;

    @NotNull
    private SessionEndpoint sessionEndpoint;

    @NotNull
    private SessionDTO currentSession;

    @Before
    public void setUp(
    ) throws Exception {
        @NotNull final IEndpointProducerService endpointService = new EndpointProducerService();
        projectEndpoint = endpointService.getProjectEndpoint();
        sessionEndpoint = endpointService.getSessionEndpoint();
        currentSession = sessionEndpoint.openSession("testAdmin", HashUtil.md5("testAdmin"));
    }

    @After
    public void tearDown(
    ) throws Exception {
        sessionEndpoint.closeSession(currentSession);
        projectEndpoint = null;
        sessionEndpoint = null;
        currentSession = null;
    }

    @Test
    public void projectCRUID(
    ) throws DataValidateException_Exception, AuthenticationSecurityException_Exception {
        assertNotNull(currentSession);
        projectEndpoint.removeAllProjectByUserId(currentSession);
        assertEquals(0, projectEndpoint.findAllProjectByUserId(currentSession).size());
        @NotNull final ProjectDTO project = new ProjectDTO();
        project.setId(UUID.randomUUID().toString());
        project.setName("New_Project");
        project.setDescription("New_Description");
        project.setUserId(currentSession.userId);
        projectEndpoint.createProject(currentSession, project);//CREATE
        assertEquals(project.getId(), projectEndpoint.findOneProject(currentSession, project.getId()).getId());//READ
        project.setName("Update_name");
        project.setDescription("Update_description");
        projectEndpoint.editProject(currentSession, project);//UPDATE
        assertEquals(project.getName(), projectEndpoint.findOneProject(currentSession, project.getId()).getName());
        assertEquals(project.getDescription(), projectEndpoint.findOneProject(currentSession, project.getId()).getDescription());
        projectEndpoint.removeProject(currentSession, project.getId());//DELETE
        assertEquals(0, projectEndpoint.findAllProjectByUserId(currentSession).size());

    }
}