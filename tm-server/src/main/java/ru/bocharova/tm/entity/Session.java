package ru.bocharova.tm.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "app_session")
@NamedEntityGraph(
        name = "session-graph",
        attributeNodes = {
                @NamedAttributeNode("user")})
public class Session extends AbstractEntity {
    @Column(name = "user_id")
    @Nullable
    private String userId;

    @Column(name = "signature")
    @Nullable
    private String signature;

    @Column
    @Nullable
    private Date timeStamp;

    @Override
    public String toString() {
        return "Session{" +
                "userId='" + userId + '\'' +
                ", signature='" + signature + '\'' +
                ", timeStamp=" + timeStamp +
                ", id='" + id + '\'' +
                '}';
    }
}
