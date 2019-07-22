package ru.bocharova.tm.DTO;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
public class AbstractEntityDTO extends AbstractEntityBaseDTO  implements Serializable {

    @NotNull
    protected String id = UUID.randomUUID().toString();

    @Nullable
    protected String name = null;

    @Nullable
    protected String description = null;

    @Nullable
    protected String userId = "";
}
