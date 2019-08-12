package ru.bocharova.tm.service;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bocharova.tm.api.repository.ITaskRepository;
import ru.bocharova.tm.api.service.ITaskService;
import ru.bocharova.tm.enumerate.Status;
import ru.bocharova.tm.exception.DataValidateException;
import ru.bocharova.tm.model.entity.Task;
import ru.bocharova.tm.util.ComparatorUtil;
import ru.bocharova.tm.util.DataValidator;

import java.util.Collection;
import java.util.Date;

@Service
public final class TaskService extends AbstractEntityService<Task, ITaskRepository> implements ITaskService {

    @Autowired
    public TaskService(@NotNull final ITaskRepository taskRepository) {
        super(taskRepository);
    }

    @Override
    public Task create(@NotNull final String projectId,
                       @NotNull final String userId,
                       @NotNull final String name,
                       @NotNull final String description
    ) throws DataValidateException {
        if (!DataValidator.validateString(projectId, userId, name, description)) return null;
        return repository.persist(new Task(projectId, userId, name, description));
    }

    @Override
    public Task edit(@NotNull String id
    ) throws DataValidateException {
        if (!DataValidator.validateString(id, name, description, status)) return null;
        if (Status.values() == null) return null;
        @NotNull
        Task task = findOne(id);
        task.setName(name);
        task.setDescription(description);
        task.setStatus(Status.valueOf(status));
        if (Status.DONE == Status.valueOf(status)) {
            task.setDateEnd(new Date());
        } else {
            task.setDateEnd(null);
        }
        return repository.merge(task);
    }

    @Override
    public Task findOne(@NotNull final String id,
                        @NotNull final String userId
    ) throws DataValidateException {
        if (!DataValidator.validateString(id, userId)) return null;
        return repository.findOne(id, userId);
    }

    @Override
    public Task remove(@NotNull String id,
                       @NotNull String userId
    ) throws DataValidateException {
        if (!DataValidator.validateString(id, userId)) return null;
        return repository.remove(id, userId);
    }

    @Override
    public void removeAllByProjectId(@NotNull final String id,
                                     @NotNull final String userId
    ) throws DataValidateException {
        if (!DataValidator.validateString(id, userId)) return;
        repository.removeAllByProjectId(id, userId);
    }

    @Override
    public void removeAllByUserId(@NotNull final String id) throws DataValidateException {
        if (!DataValidator.validateString(id)) return;
        repository.removeAllByUserId(id);
    }

    @Override
    public Collection<Task> sortAllByUserId(@NotNull String id,
                                            @NotNull String comparator
    ) throws DataValidateException {
        if (!DataValidator.validateString(id, comparator)) return null;
        if ("order".equals(comparator)) return findAllByUserId(id);
        if (ComparatorUtil.getTaskComparator(comparator) == null) return null;
        return repository.sortAllByUserId(id, ComparatorUtil.getTaskComparator(comparator));
    }

    @Override
    public Collection<Task> findAllByPartOfNameOrDescription(@NotNull String userId,
                                                             @NotNull String name,
                                                             @NotNull String description
                                                             ) throws DataValidateException {
        if (!DataValidator.validateString(userId, name, description)) return null;
        return repository.findAllByPartOfNameOrDescription(userId, name, description);
    }

    @Override
    public Collection<Task> findAllByProjectId(@NotNull final String id,
                                               @NotNull final String userId
    ) throws DataValidateException {
        if (!DataValidator.validateString(id, userId)) return null;
        return repository.findAllByProjectId(id, userId);
    }

    @Override
    public Collection<Task> findAllByUserId(@NotNull final String id) throws DataValidateException {
        if (!DataValidator.validateString(id)) return null;
        return repository.findAllByUserId(id);
    }
}