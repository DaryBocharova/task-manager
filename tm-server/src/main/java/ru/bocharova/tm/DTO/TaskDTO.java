package ru.bocharova.tm.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class TaskDTO extends AbstractEntityDTO implements Serializable {

    @Getter
    @Setter
    @NotNull
    private String projectId = "";

    public TaskDTO(@NotNull final String projectId, @NotNull final String userId, @NotNull final String name,
                   @NotNull final String description) {
        this.name = name;
        this.description = description;
        this.projectId = projectId;
        this.userId = userId;
    }
}
