package ru.bocharova.tm.service;

import org.apache.deltaspike.testcontrol.api.junit.CdiTestRunner;
import org.jetbrains.annotations.NotNull;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import ru.bocharova.tm.api.service.IUserService;
import ru.bocharova.tm.exception.DataValidateException;
import ru.bocharova.tm.model.dto.UserDTO;
import ru.bocharova.tm.util.DataGenerator;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;

@RunWith(CdiTestRunner.class)
public class UserServiceTest {

    @Inject
    IUserService userService;

    @Inject
    DataGenerator dataGenerator;

    @Before
    public void setUp() {
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
    public void userCRUD(
    ) throws DataValidateException {
        @NotNull final UserDTO user = new UserDTO();
        user.setLogin("test");
        user.setPassword("test");
        @NotNull final String userId = user.getId();
        userService.create(user);
        assertEquals(userId, userService.findByLogin("test").getId());
        user.setLogin("change login");
        userService.edit(user);
        assertEquals(user.getLogin(), userService.findOne(userId).getLogin());
        userService.remove(userId);
        thrown.expect(DataValidateException.class);
        userService.findOne(userId);
    }
}