package ru.bocharova.tm.api.service;

import org.jetbrains.annotations.NotNull;
import ru.bocharova.tm.DTO.TaskDTO;
import ru.bocharova.tm.entity.Task;
import ru.bocharova.tm.exception.DataValidateException;

import java.util.Collection;

public interface ITaskService {

    void create(@NotNull final TaskDTO taskDTO) throws DataValidateException;

    void edit(@NotNull final TaskDTO taskDTO) throws DataValidateException;

    TaskDTO findOne(@NotNull final String id, @NotNull final String userId) throws DataValidateException;

    void clear() throws DataValidateException;

    TaskDTO findOne(@NotNull final String id) throws DataValidateException;

    void remove(@NotNull final String id, @NotNull final String userId) throws DataValidateException;

    void remove(@NotNull final String id) throws DataValidateException;

    Collection<TaskDTO> findAll() throws DataValidateException;

    Collection<TaskDTO> findAllByProjectId(@NotNull final String id, @NotNull final String userId) throws DataValidateException;

    Collection<TaskDTO> findAllByUserId(@NotNull final String id) throws DataValidateException;

    void removeAllByProjectId(@NotNull final String id, @NotNull final String userId) throws DataValidateException;

    void removeAllByUserId(@NotNull final String id) throws DataValidateException;

    Collection<TaskDTO> sortAllByUserId(@NotNull final String id, @NotNull final String comparator) throws DataValidateException;

    Collection<TaskDTO> findAllByPartOfNameOrDescription(@NotNull final String userId, @NotNull final String name,
                                                      @NotNull final String description) throws DataValidateException;
}