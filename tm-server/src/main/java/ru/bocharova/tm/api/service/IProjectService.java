package ru.bocharova.tm.api.service;

import org.jetbrains.annotations.NotNull;
import ru.bocharova.tm.entity.Project;

import java.util.Collection;

public interface IProjectService extends IAbstractEntityService<Project> {

    Project create(@NotNull final String name, @NotNull final String description, @NotNull final String userID);
    Project edit(@NotNull final String id, @NotNull final String name, @NotNull final String description, @NotNull final String status);
    Project findOne(@NotNull final String id, @NotNull final String userId);
    Project remove(@NotNull final String id, @NotNull final String userId);
    Collection<Project> findAllByUserId(@NotNull final String id);
    void removeAllByUserId(@NotNull final String id);
    Collection<Project> sortAllByUserId(@NotNull final String id, @NotNull final String comparator);
    Collection<Project> findAllByPartOfNameOrDescription(@NotNull final String name, @NotNull final String description, @NotNull final String userId);
}
