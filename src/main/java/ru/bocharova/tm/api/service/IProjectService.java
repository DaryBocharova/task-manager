package ru.bocharova.tm.api.service;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import ru.bocharova.tm.exception.DataValidateException;
import ru.bocharova.tm.model.entity.Project;

import java.util.Collection;

@Service
public interface IProjectService extends IAbstractEntityService<Project> {

    Project create(
            @NotNull final String userId,
            @NotNull final String name,
            @NotNull final String description
    ) throws DataValidateException;

    Collection<Project> findAllByUserId(
            @NotNull final String id) throws DataValidateException;

    void removeAllByUserId(
            @NotNull final String id) throws DataValidateException;

    Collection<Project> sortAllByUserId(
            @NotNull final String id,
            @NotNull final String comparator
    ) throws DataValidateException;

    Collection<Project> findAllByPartOfNameOrDescription(
            @NotNull final String userId,
            @NotNull final String name,
            @NotNull final String description
    ) throws DataValidateException;

    void create(Project project);
}