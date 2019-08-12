package ru.bocharova.tm.api.repository;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import ru.bocharova.tm.model.entity.Project;

import java.util.Collection;
import java.util.Comparator;

@Repository
public interface IProjectRepository extends IAbstractRepository<Project> {

    Collection<Project> findAllByUserId(@NotNull final String id);

    Project findOne(@NotNull final String id,
                    @NotNull final String userId
    );

    Project remove(@NotNull final String id,
                   @NotNull final String userId
    );

    void removeAllByUserId(@NotNull final String id);

    Collection<Project> sortAllByUserId(@NotNull String id, Comparator<Project> comparator);

    Collection<Project> findAllByPartOfNameOrDescription(@NotNull final String userId,
                                                         @NotNull final String name,
                                                         @NotNull final String description
    );
}