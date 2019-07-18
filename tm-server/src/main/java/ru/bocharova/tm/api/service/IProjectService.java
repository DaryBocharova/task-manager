package ru.bocharova.tm.api.service;

import org.jetbrains.annotations.NotNull;
import ru.bocharova.tm.DTO.ProjectDTO;
import ru.bocharova.tm.entity.Project;
import ru.bocharova.tm.exception.DataValidateException;

import java.sql.PreparedStatement;
import java.util.Collection;

public interface IProjectService {

    ProjectDTO create(@NotNull final ProjectDTO projectDTO) throws DataValidateException;

    ProjectDTO edit(@NotNull final ProjectDTO projectDTO) throws DataValidateException;

    ProjectDTO findOne(@NotNull final String id, @NotNull final String userId);

    ProjectDTO remove(@NotNull final String id, @NotNull final String userId);

    void clear();

    ProjectDTO findOne(@NotNull final String id);

    ProjectDTO remove(@NotNull final String id);

    Collection<ProjectDTO> findAll();

    Collection<ProjectDTO> findAllByUserId(@NotNull final String id);

    void removeAllByUserId(@NotNull final String id);

    Collection<ProjectDTO> sortAllByUserId(@NotNull final String id, @NotNull final String comparator);

    Collection<ProjectDTO> findAllByPartOfNameOrDescription(@NotNull final String userId, @NotNull final String name, @NotNull final String description);
}