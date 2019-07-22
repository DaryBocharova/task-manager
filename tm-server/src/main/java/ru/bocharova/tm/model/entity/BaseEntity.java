package ru.bocharova.tm.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;
import ru.bocharova.tm.enumerate.Status;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
@NoArgsConstructor
public class BaseEntity extends AbstractEntity implements Serializable {

    @Column
    @Nullable
    protected Date dateBegin = null;

    @Column
    @Nullable
    protected Date dateEnd = null;

    @Column
    @Nullable
    @Enumerated(EnumType.STRING)
    protected Status status = Status.PLANNED;

    @Nullable
    @ManyToOne
    @JoinColumn(name = "user_id")
    protected User user;
}
