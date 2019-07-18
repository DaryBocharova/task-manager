package ru.bocharova.tm.api.repository;

import org.jetbrains.annotations.NotNull;
import ru.bocharova.tm.entity.Project;
import ru.bocharova.tm.entity.Task;
import ru.bocharova.tm.entity.User;

import java.util.Collection;

public interface ITaskRepository {

    Task findOne(@NotNull final String id);

    void removeAll();

    void remove(@NotNull final Task task);

    void persist(@NotNull final Task task);

    Integer merge(@NotNull final Task task);

    Collection<Task> findAllByUserId(@NotNull final User user);

    Collection<Task> findAllByProjectAndUserId(@NotNull final User user, @NotNull final Project project);

    Task findOneByUserId(@NotNull final String id, @NotNull final User user);

    Integer removeOneByUserId(@NotNull final String id, @NotNull final User user);

    Integer removeAllByUserId(@NotNull final User user);

    Integer removeAllByProjectAndUserId(@NotNull final User user, @NotNull final Project project);

    Collection<Task> sortAllByUserId(@NotNull final User user, @NotNull final String parameter);

    Collection<Task> findAllByPartOfNameOrDescription(@NotNull final String name, @NotNull final String description,
                                                      @NotNull final User user);
}