package ru.bocharova.tm.entity;

import org.jetbrains.annotations.Nullable;
import ru.bocharova.tm.enumerate.Status;

import javax.persistence.*;

@MappedSuperclass
public abstract class AbstractEntityBase {

    @Column
    @Nullable
    @Enumerated(EnumType.STRING)
    protected Status status = Status.PLANNED;

    @Nullable
    @ManyToOne
    @JoinColumn(name = "user_id")
    protected User user;
}
