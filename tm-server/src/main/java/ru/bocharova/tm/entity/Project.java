package ru.bocharova.tm.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.bocharova.tm.DTO.ProjectDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@NamedEntityGraph(
        name = "project-graph",
        attributeNodes = {
                @NamedAttributeNode("task"),
                @NamedAttributeNode("user")})
@Table(name = "app_project")
public class Project extends AbstractEntityBase implements Serializable {

    @Id
    private String id;
    @Nullable
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Task> tasks;

    public ProjectDTO getDTO() {
        @NotNull final ProjectDTO dto = new ProjectDTO();
        dto.setId(id);
        dto.setName(name);
        dto.setDescription(description);
        dto.setDateBegin(dateBegin);
        dto.setDateEnd(dateEnd);
        dto.setStatus(status);
        dto.setUserId(user.getId());
        return dto;
    }

    @ManyToOne(optional = false)
    private User users;

}
