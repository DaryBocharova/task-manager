package ru.bocharova.tm.api.service;

import org.jetbrains.annotations.NotNull;
import ru.bocharova.tm.entity.Project;

import java.sql.PreparedStatement;
import java.util.Collection;

public interface IProjectService {

    Project create(@NotNull final String userId, @NotNull final String name, @NotNull final String description);

    Project edit(@NotNull final String id, @NotNull final String name, @NotNull final String description, @NotNull final String status, @NotNull String userId);

    Project findOne(@NotNull final String id, @NotNull final String userId);

    Project remove(@NotNull final String id, @NotNull final String userId);

    void clear();

    Project findOne(@NotNull final String id);

    Project remove(@NotNull final String id);

    Collection<Project> findAll();

    Collection<Project> findAllByUserId(@NotNull final String id);

    void removeAllByUserId(@NotNull final String id);

    Collection<Project> sortAllByUserId(@NotNull final String id, @NotNull final String comparator);

    Collection<Project> findAllByPartOfNameOrDescription(@NotNull final String userId, @NotNull final String name, @NotNull final String description);
}