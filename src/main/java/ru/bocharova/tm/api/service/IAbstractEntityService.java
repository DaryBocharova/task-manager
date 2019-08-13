package ru.bocharova.tm.api.service;

import org.jetbrains.annotations.NotNull;
import ru.bocharova.tm.exception.DataValidateException;

import java.util.Collection;

public interface IAbstractEntityService<E> {

    void clear();

    E findOne(
            @NotNull final String id) throws DataValidateException;

    E remove(
            @NotNull final String id) throws DataValidateException;

    Collection<E> findAll();

    E edit(@NotNull final String id
    ) throws DataValidateException;
}