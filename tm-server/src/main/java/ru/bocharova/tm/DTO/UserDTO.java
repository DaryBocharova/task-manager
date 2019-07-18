package ru.bocharova.tm.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;
import ru.bocharova.tm.enumerate.Role;

import java.io.Serializable;

@NoArgsConstructor
public class UserDTO extends AbstractEntityDTO implements Serializable {

    @Getter
    @Setter
    @Nullable
    private String login = "";

    @Getter
    @Setter
    @Nullable
    private String password = "";

    @Getter
    @Setter
    @Nullable
    private Role role = Role.USER;
}
