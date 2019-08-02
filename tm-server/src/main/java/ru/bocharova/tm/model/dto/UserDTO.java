package ru.bocharova.tm.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.jetbrains.annotations.Nullable;
import ru.bocharova.tm.enumerate.Role;

import javax.persistence.Cacheable;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class UserDTO extends AbstractEntityDTO implements Serializable {

    @Nullable
    private String login = "";

    @Nullable
    private String password = "";

    @Nullable
    private Role role = Role.USER;

    @Nullable
    public String getLogin() {
        return login;
    }

    public void setLogin(@Nullable String login) {
        this.login = login;
    }

    @Nullable
    public String getPassword() {
        return password;
    }

    public void setPassword(@Nullable String password) {
        this.password = password;
    }

    @Nullable
    public Role getRole() {
        return role;
    }

    public void setRole(@Nullable Role role) {
        this.role = role;
    }
}
