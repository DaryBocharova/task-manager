package ru.bocharova.tm.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.bocharova.tm.enumerate.Status;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class TaskDTO extends AbstractEntityDTO implements Serializable {

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
