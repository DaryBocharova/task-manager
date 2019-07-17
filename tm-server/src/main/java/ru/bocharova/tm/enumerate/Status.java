package ru.bocharova.tm.enumerate;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

public enum Status implements Serializable {

    @NotNull
    PLANNED("planned"), INPROCESS("in process"), DONE("done");

    @NotNull
    private final String displayName;

    Status(@NotNull String status) {
        this.displayName = status;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
