package ru.bocharova.tm.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.bocharova.tm.enumerate.Status;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class BaseEntity extends AbstractEntity implements Serializable {

    @Nullable
    protected Date dateBegin = null;
    @Nullable
    protected Date dateEnd = null;
    @NotNull
    protected String userId = "";
    @NotNull
    protected Status status = Status.PLANNED;
}
