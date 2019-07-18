package ru.bocharova.tm.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public abstract class AbstractEntity implements Serializable {

    @NotNull
    @Id
    @Column(name = "id")
    protected String id = UUID.randomUUID().toString();

    @Nullable
    @Column(name = "name")
    protected String name = null;

    @Nullable
    @Column(name = "description")
    protected String description = null;
}
