package ru.bocharova.tm.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.bocharova.tm.enumerate.Status;
import ru.bocharova.tm.util.DateFormatterUtil;
import ru.bocharova.tm.util.EnumUtil;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "app_project")
@NamedEntityGraph(
        name = "project-graph",
        attributeNodes = {
                @NamedAttributeNode("task"),
                @NamedAttributeNode("user")})
public class Project extends AbstractEntity implements Serializable {

    @Nullable
    @Column(name = "dateBegin")
    private Date dateBegin = null;

    @Nullable
    @Column(name = "dateEnd")
    private Date dateEnd = new Date();

    @NotNull
    @Column
    private String userId = "";

    @NotNull
    @Getter
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status = Status.PLANNED;

    public Project(@NotNull final String userId, @NotNull final String name, @NotNull final String description) {
        this.name = name;
        this.description = description;
        this.dateBegin = new Date();
        this.userId = userId;
    }

    public void setStatus(@NotNull final String status) {
        this.status = EnumUtil.stringToStatus(status);
    }

    public String getStatus() {
        return status.toString();
    }

    @Override
    public String toString() {
        return "Project{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", dateBegin=" + DateFormatterUtil.format(dateBegin) +
                ", dateEnd=" + DateFormatterUtil.format(dateEnd) +
                ", status=" + status +
                ", userId='" + userId + '\'' +
                '}';
    }
}
