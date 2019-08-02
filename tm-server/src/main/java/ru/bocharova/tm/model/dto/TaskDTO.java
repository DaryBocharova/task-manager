package ru.bocharova.tm.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.jetbrains.annotations.Nullable;

import javax.persistence.Cacheable;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class TaskDTO extends BaseEntityDTO implements Serializable {

    @Nullable
    private String projectId;

    public TaskDTO(
            @Nullable final String name,
            @Nullable final String description,
            @Nullable final String projectId,
            @Nullable final String userId) {
        this.name = name;
        this.description = description;
        this.projectId = projectId;
        this.userId = userId;
    }
}
