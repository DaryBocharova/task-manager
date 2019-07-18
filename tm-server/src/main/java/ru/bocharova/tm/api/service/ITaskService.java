package ru.bocharova.tm.api.service;

import org.jetbrains.annotations.NotNull;
import ru.bocharova.tm.entity.Task;

import java.util.Collection;

public interface ITaskService {

    Task create(@NotNull final String userId, @NotNull final String projectId,@NotNull final String name, @NotNull final String description);

    Task edit(@NotNull final String id, @NotNull final String name, @NotNull final String description, @NotNull final String status);

    Task findOne(@NotNull final String id, @NotNull final String userId);

    void clear();

    Task findOne(@NotNull final String id);

    Task remove(@NotNull final String id, @NotNull final String userId);

    Task remove(@NotNull final String id);

    Collection<Task> findAll();

    Collection<Task> findAllByProjectId(@NotNull final String id, @NotNull final String userId);

    Collection<Task> findAllByUserId(@NotNull final String id);

    void removeAllByProjectId(@NotNull final String id, @NotNull final String userId);

    void removeAllByUserId(@NotNull final String id);

    Collection<Task> sortAllByUserId(@NotNull final String id, @NotNull final String comparator);

    Collection<Task> findAllByPartOfNameOrDescription(@NotNull final String userId, @NotNull final String name, @NotNull final String description);
}