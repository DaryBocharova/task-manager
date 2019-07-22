package ru.bocharova.tm.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.bocharova.tm.DTO.UserDTO;
import ru.bocharova.tm.enumerate.Role;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "app_user")
@NamedEntityGraph(
        name = "user-graph",
        attributeNodes = {
                @NamedAttributeNode("task"),
                @NamedAttributeNode("project")})
public class User extends AbstractEntityBase implements Serializable {

    @Id
    private String id;

    @Column
    @Nullable
    private String login = "";

    @Nullable
    @Column(unique = true)
    private String password = "";

    @Column
    @Nullable
    @Enumerated(value = EnumType.STRING)
    private Role role = Role.USER;

    @Nullable
    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Project> projects;

    @Nullable
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Task> tasks;

    @Nullable
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Session> session;

    public User() {
    }

    public UserDTO getDTO() {
        @NotNull final UserDTO dto = new UserDTO();
        dto.setId(id);
        dto.setLogin(login);
        dto.setPassword(null);
        dto.setRole(role);
        dto.setName(name);
        dto.setDescription(description);
        return dto;
    }
}

