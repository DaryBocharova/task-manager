package ru.bocharova.tm.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.bocharova.tm.enumerate.Status;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class Task extends BaseEntity implements Serializable {

    @Nullable
    private String projectId;

    public Task(String reqParameter, String parameter, @NotNull final String projectId,
                @Nullable final String name,
                Status status, @Nullable final String description,
                @Nullable final String userId) {
        this.name = name;
        this.description = description;
        this.dateBegin = dateBeing;
        this.dateEnd = dateEnd;
        this.status = this.status;
        this.userId = userId;
        this.projectId = projectId;
    }
}

