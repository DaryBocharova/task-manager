package ru.bocharova.tm.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.bocharova.tm.DTO.TaskDTO;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "app_task")
@NamedEntityGraph(
        name = "task-graph",
        attributeNodes = {
                @NamedAttributeNode("project"),
                @NamedAttributeNode("user")})
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Task extends AbstractEntityBase implements Serializable {

    @Id
    private String id;

    @Nullable
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @Nullable
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public TaskDTO getDTO() {
        @NotNull final TaskDTO dto = new TaskDTO();
        dto.setId(id);
        dto.setName(name);
        dto.setDescription(description);
        dto.setDateBegin(dateBegin);
        dto.setDateEnd(dateEnd);
        dto.setStatus(status);
        dto.setUserId(user.getId());
        dto.setProjectId(project.getId());
        return dto;
    }


}