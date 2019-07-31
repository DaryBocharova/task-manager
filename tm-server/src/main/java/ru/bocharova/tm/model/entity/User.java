package ru.bocharova.tm.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.bocharova.tm.model.dto.UserDTO;
import ru.bocharova.tm.enumerate.Role;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "app_user")
public class User extends AbstractEntity implements Serializable {

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
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Project> projects;

    @Nullable
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Task> tasks;

    @Nullable
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Session> session;

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
