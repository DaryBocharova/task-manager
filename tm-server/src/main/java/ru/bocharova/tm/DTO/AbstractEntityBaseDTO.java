package ru.bocharova.tm.DTO;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.bocharova.tm.entity.User;
import ru.bocharova.tm.enumerate.Status;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
public class AbstractEntityBaseDTO implements Serializable {

    @Nullable
    protected Status status = Status.PLANNED;

    @NotNull
    protected String user;

    @NotNull
    protected Date dateBegin = new Date();

    @NotNull
    protected Date dateEnd = new Date();

}
