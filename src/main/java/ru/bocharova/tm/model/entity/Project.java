package ru.bocharova.tm.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;
import ru.bocharova.tm.enumerate.Status;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class Project extends BaseEntity implements Serializable {

    public Project(
            String requestParameter, String parameter, @Nullable final String userId,
            @Nullable final String name,
            Status status, @Nullable final String description
    ) {
        this.name = name;
        this.description = description;
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
        this.status = this.status;
        this.userId = userId;
    }
}
