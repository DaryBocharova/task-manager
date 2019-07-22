package ru.bocharova.tm.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.bocharova.tm.DTO.SessionDTO;

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
public class Session extends AbstractEntityBase {

    @Id
    private String id;

    @Nullable
    private String signature;

    @Nullable
    private Date timestamp;

    @Nullable
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public SessionDTO getDTO() {
        @NotNull final SessionDTO dto = new SessionDTO();
        dto.setId(id);
        dto.setName(name);
        dto.setDescription(description);
        dto.setSignature(signature);
        dto.setTimestamp(timestamp);
        dto.setUserId(user.getId());
        return dto;
    }
}
