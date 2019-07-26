package ru.bocharova.tm.endpoint;

import org.jetbrains.annotations.NotNull;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import ru.bocharova.tm.api.IntegrationTest;
import ru.bocharova.tm.api.service.IEndpointProducerService;
import ru.bocharova.tm.service.EndpointProducerService;
import ru.bocharova.tm.util.HashUtil;

import java.util.UUID;

import static org.junit.Assert.*;

@Category(IntegrationTest.class)
public class TaskEndpointTest {

    @NotNull
    private ProjectEndpoint projectEndpoint;

    @NotNull
    private TaskEndpoint taskEndpoint;

    @NotNull
    private SessionEndpoint sessionEndpoint;

    @NotNull
    private SessionDTO currentSession;


    @Before
    public void setUp(
    ) throws Exception {
        @NotNull final IEndpointProducerService endpointService = new EndpointProducerService();
        taskEndpoint = endpointService.getTaskEndpoint();
        projectEndpoint = endpointService.getProjectEndpoint();
        sessionEndpoint = endpointService.getSessionEndpoint();
        currentSession = sessionEndpoint.openSession("testAdmin", HashUtil.md5("testAdmin"));
    }

    @After
    public void tearDown(
    ) throws Exception {
        sessionEndpoint.closeSession(currentSession);
        taskEndpoint = null;
        sessionEndpoint = null;
        currentSession = null;
    }

    @Test
    public void taskCRUID(
    ) throws DataValidateException_Exception, AuthenticationSecurityException_Exception {
        assertNotNull(currentSession);
        taskEndpoint.removeAllTaskByUserId(currentSession);
        assertEquals(0, taskEndpoint.findAllTaskByUserId(currentSession).size());

        @NotNull final ProjectDTO project = new ProjectDTO();
        project.setId(UUID.randomUUID().toString());
        project.setName("New_Project");
        project.setDescription("New_Description");
        project.setUserId(currentSession.userId);
        projectEndpoint.createProject(currentSession, project);

        @NotNull final TaskDTO task = new TaskDTO();
        task.setId(UUID.randomUUID().toString());
        task.setName("New_Task");
        task.setDescription("New_Description");
        task.setUserId(currentSession.userId);
        task.setProjectId(project.getId());

        taskEndpoint.createTask(task, currentSession);//CREATE
        assertEquals(task.getId(), taskEndpoint.findOneTask(currentSession, task.getId()).getId());//READ
        task.setName("Update_name");
        task.setDescription("Update_description");
        taskEndpoint.editTask(task, currentSession);//UPDATE
        assertEquals(task.getName(), taskEndpoint.findOneTask(currentSession, task.getId()).getName());
        assertEquals(task.getDescription(), taskEndpoint.findOneTask(currentSession, task.getId()).getDescription());
        taskEndpoint.removeTask(currentSession, task.getId());//DELETE
        assertEquals(0, taskEndpoint.findAllTaskByUserId(currentSession).size());

        for (int i = 0; i < 10; i++) {
            @NotNull final TaskDTO testTask = new TaskDTO();
            testTask.setId(UUID.randomUUID().toString());
            testTask.setName("New_Task_" + i);
            testTask.setDescription("New_Description_" + i);
            testTask.setUserId(currentSession.userId);
            testTask.setProjectId(project.getId());
            taskEndpoint.createTask(testTask, currentSession);
        }
        assertEquals(10, taskEndpoint.findAllTaskByProjectId(currentSession, project.getId()).size());
        taskEndpoint.removeAllTaskByProjectId(currentSession, project.getId());
        assertEquals(0, taskEndpoint.findAllTaskByProjectId(currentSession, project.getId()).size());
        projectEndpoint.removeAllProjectByUserId(currentSession);
    }

}