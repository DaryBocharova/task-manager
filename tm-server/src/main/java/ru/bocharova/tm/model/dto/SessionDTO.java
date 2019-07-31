package ru.bocharova.tm.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class SessionDTO extends AbstractEntityDTO {

    @Nullable
    private Date timestamp = null;

    @Nullable
    private String signature = null;

    @Nullable
    private String userId = null;

    @Nullable
    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(@Nullable Date timestamp) {
        this.timestamp = timestamp;
    }

    @Nullable
    public String getSignature() {
        return signature;
    }

    public void setSignature(@Nullable String signature) {
        this.signature = signature;
    }

    @Nullable
    public String getUserId() {
        return userId;
    }

    public void setUserId(@Nullable String userId) {
        this.userId = userId;
    }
}
