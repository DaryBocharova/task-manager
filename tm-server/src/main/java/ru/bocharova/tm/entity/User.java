package ru.bocharova.tm.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.bocharova.tm.enumerate.Role;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

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
public class User extends AbstractEntity implements Serializable {

    @Nullable
    @Column(unique = true)
    private String login = "";

    @Nullable
    @Column(name = "password")
    private String password = "";

    @Nullable
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role = Role.USER;

    @Override
    public String toString() {
        return "User{" +
                "Id='" + id + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
