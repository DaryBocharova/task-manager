package ru.bocharova.tm.service;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bocharova.tm.api.repository.IProjectRepository;
import ru.bocharova.tm.api.service.IProjectService;
import ru.bocharova.tm.enumerate.Status;
import ru.bocharova.tm.exception.DataValidateException;
import ru.bocharova.tm.model.entity.Project;
import ru.bocharova.tm.util.ComparatorUtil;
import ru.bocharova.tm.util.DataValidator;

import java.util.Collection;
import java.util.Date;

@Service
public final class ProjectService extends AbstractEntityService<Project, IProjectRepository> implements IProjectService {

    @Autowired
    public ProjectService(@NotNull final IProjectRepository projectRepository) {
        super(projectRepository);
    }

    @Override
    public Project create(@NotNull final String userId,
                          @NotNull final String name,
                          @NotNull final String description
    ) throws DataValidateException {
        if (!DataValidator.validateString(userId, name, description)) return null;
        return repository.persist(new Project(userId, name, description));
    }

    @Override
    public Project edit(@NotNull String id
    ) throws DataValidateException {
        if (!DataValidator.validateString(id, name, description, status)) return null;
        if (Status.values() == null) return null;
        @NotNull
        Project project = findOne(id);
        project.setName(name);
        project.setDescription(description);
        project.setStatus(Status.valueOf(status));
        if (Status.DONE == Status.valueOf(status)) {
            project.setDateEnd(new Date());
        } else {
            project.setDateEnd(null);
        }
        return repository.merge(project);
    }

    @Override
    public Collection<Project> findAllByUserId(@NotNull final String id) throws DataValidateException {
        if (!DataValidator.validateString(id)) return null;
        return repository.findAllByUserId(id);
    }

    @Override
    public void removeAllByUserId(@NotNull final String id) throws DataValidateException {
        if (!DataValidator.validateString(id)) return;
        repository.removeAllByUserId(id);
    }

    @Override
    public Collection<Project> sortAllByUserId(@NotNull String id,
                                               @NotNull String comparator
    ) throws DataValidateException {
        if (!DataValidator.validateString(id, comparator)) return null;
        if ("order".equals(comparator)) return findAllByUserId(id);
        if (ComparatorUtil.getProjectComparator(comparator) == null) return null;
        return repository.sortAllByUserId(id, ComparatorUtil.getProjectComparator(comparator));
    }

    @Override
    public Collection<Project> findAllByPartOfNameOrDescription(@NotNull String userId,
                                                                @NotNull String name,
                                                                @NotNull String description
    ) throws DataValidateException {
        if (!DataValidator.validateString(name, description, userId)) return null;
        return repository.findAllByPartOfNameOrDescription(name, description, userId);
    }
}