package ru.bocharova.tm.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
public class SessionDTO extends AbstractEntityDTO implements Serializable {

    @Getter
    @Setter
    @Nullable
    private String signature;

    @Getter
    @Setter
    @Nullable
    private Date timeStamp;
}