package ru.bocharova.tm.api.service;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import ru.bocharova.tm.exception.DataValidateException;
import ru.bocharova.tm.model.entity.Task;

import java.util.Collection;

@Service
public interface ITaskService extends IAbstractEntityService<Task> {

    Task create(@NotNull final String projectId,
                @NotNull final String userId,
                @NotNull final String name,
                @NotNull final String description
    ) throws DataValidateException;

    Task findOne(@NotNull final String id,
                 @NotNull final String userId
    ) throws DataValidateException;

    Task remove(@NotNull final String id
    ) throws DataValidateException;

    Collection<Task> findAllByProjectId(@NotNull final String id,
                                        @NotNull final String userId
    ) throws DataValidateException;

    Collection<Task> findAllByUserId(@NotNull final String id) throws DataValidateException;

    void removeAllByProjectId(@NotNull final String id,
                              @NotNull final String userId
    ) throws DataValidateException;

    void removeAllByUserId(@NotNull final String id) throws DataValidateException;

    Collection<Task> sortAllByUserId(@NotNull final String id,
                                     @NotNull final String comparator
    ) throws DataValidateException;

    Collection<Task> findAllByPartOfNameOrDescription(@NotNull final String userId,
                                                      @NotNull final String name,
                                                      @NotNull final String description
    ) throws DataValidateException;
}