package ru.bocharova.tm.DTO;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

public class ProjectDTO extends  AbstractEntityDTO  implements Serializable {

    public ProjectDTO(@NotNull final String userId, @NotNull final String name, @NotNull final String description) {
        this.userId = userId;
        this.name = name;
        this.description = description;
    }
}
