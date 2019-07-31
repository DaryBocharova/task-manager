package ru.bocharova.tm.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;
import ru.bocharova.tm.enumerate.Status;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class BaseEntityDTO extends AbstractEntityDTO implements Serializable {

    @Nullable
    protected Date dateBegin = new Date();

    @Nullable
    protected Date dateEnd = null;

    @Nullable
    protected String userId = "";

    @Getter
    protected Status status = Status.PLANNED;

    @Nullable
    public Date getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(@Nullable Date dateBegin) {
        this.dateBegin = dateBegin;
    }

    @Nullable
    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(@Nullable Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    @Nullable
    public String getUserId() {
        return userId;
    }

    public void setUserId(@Nullable String userId) {
        this.userId = userId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
