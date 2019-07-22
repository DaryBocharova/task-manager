package ru.bocharova.tm.api.service;

import org.jetbrains.annotations.NotNull;
import ru.bocharova.tm.exception.DataValidateException;
import ru.bocharova.tm.model.dto.ProjectDTO;

import java.util.Collection;

public interface IProjectService {

    void create(@NotNull final ProjectDTO projectDTO) throws DataValidateException;

    void edit(@NotNull final ProjectDTO projectDTO) throws DataValidateException;

    ProjectDTO findOne(@NotNull final String id, @NotNull final String userId) throws DataValidateException;

    void remove(@NotNull final String id, @NotNull final String userId) throws DataValidateException;

    void clear() throws DataValidateException;

    ProjectDTO findOne(@NotNull final String id) throws DataValidateException;

    ProjectDTO remove(@NotNull final String id) throws DataValidateException;

    Collection<ProjectDTO> findAll() throws DataValidateException;

    Collection<ProjectDTO> findAllByUserId(@NotNull final String id) throws DataValidateException;

    void removeAllByUserId(@NotNull final String id) throws DataValidateException;

    Collection<ProjectDTO> sortAllByUserId(@NotNull final String id, @NotNull final String comparator)
            throws DataValidateException;

    Collection<ProjectDTO> findAllByPartOfNameOrDescription(@NotNull final String userId, @NotNull final String name,
                                                            @NotNull final String description) throws DataValidateException;
}