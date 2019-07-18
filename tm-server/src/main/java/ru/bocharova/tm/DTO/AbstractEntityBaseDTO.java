package ru.bocharova.tm.DTO;

import org.jetbrains.annotations.Nullable;
import ru.bocharova.tm.entity.User;
import ru.bocharova.tm.enumerate.Status;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public class AbstractEntityBaseDTO  implements Serializable {

    @Nullable
    protected Status status = Status.PLANNED;

    @Nullable
    protected User user;

    @Nullable
    protected Date dateBegin = new Date();

    @Nullable
    protected Date dateEnd = new Date();

}
