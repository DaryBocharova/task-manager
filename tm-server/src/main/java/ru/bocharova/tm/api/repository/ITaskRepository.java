package ru.bocharova.tm.api.repository;

import org.jetbrains.annotations.NotNull;
import ru.bocharova.tm.model.entity.*;

import java.util.Collection;

public interface ITaskRepository {

    Task findOne(@NotNull final String id);

    void removeAll();

    Collection<Task> findAll();

    void remove(@NotNull final Task task);

    void persist(@NotNull final Task task);

    Task merge(@NotNull final Task task);

    Collection<Task> findAllByUserId(@NotNull final User user);

    Collection<Task> findAllByProjectAndUserId(@NotNull final Project project, @NotNull final User user);

    Task findOneByUserId(@NotNull final String id, @NotNull final User user);

    void removeAllByUserId(@NotNull final User user);

    void removeAllByProjectAndUserId( @NotNull final Project project, @NotNull final User user);

    Collection<Task> sortAllByUserId(@NotNull final User user, @NotNull final String parameter);

    Collection<Task> findAllByPartOfNameOrDescription(@NotNull final String name, @NotNull final String description,
                                                      @NotNull final User user);
}