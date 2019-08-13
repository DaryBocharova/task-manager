package ru.bocharova.tm.service;

import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import ru.bocharova.tm.api.repository.IAbstractRepository;
import ru.bocharova.tm.api.service.IAbstractEntityService;
import ru.bocharova.tm.exception.DataValidateException;
import ru.bocharova.tm.model.entity.AbstractEntity;
import ru.bocharova.tm.util.DataValidator;

import java.util.Collection;

@AllArgsConstructor
public abstract class AbstractEntityService<E extends AbstractEntity, R extends IAbstractRepository<E>>
        implements IAbstractEntityService<E> {

    @NotNull
    protected R repository;

    @Override
    public void clear() {
        repository.removeAll();
    }

    @Override
    public E findOne(@NotNull final String id) throws DataValidateException {
        if (!DataValidator.validateString(id)) return null;
        return repository.findOne(id);
    }

    @Override
    public E remove(@NotNull final String id) throws DataValidateException {
        if (!DataValidator.validateString(id)) return null;
        return repository.remove(id);
    }

    @Override
    public Collection<E> findAll() {
        return repository.findAll();
    }
}