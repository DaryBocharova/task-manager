package ru.bocharova.tm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.bocharova.tm.enumerate.Status;
import ru.bocharova.tm.util.DateAdapter;
import ru.bocharova.tm.util.DateFormatterUtil;
import ru.bocharova.tm.util.EnumUtil;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name = "project")
@XmlAccessorType(XmlAccessType.FIELD)
public class Project extends AbstractEntity implements Serializable {

    @Nullable
    @JsonFormat(pattern = "yyyy-MM-dd")
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date dateBegin = null;
    @Nullable
    @JsonFormat(pattern = "yyyy-MM-dd")
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date dateEnd = new Date();
    @NotNull
    private String userId = "";
    @NotNull
    @Getter
    private Status status = Status.PLANNED;

    public Project(@NotNull final String userId, @NotNull final String name, @NotNull final String description) {
        this.name = name;
        this.description = description;
        this.dateBegin = new Date();
        this.userId = userId;
    }

    public void setStatus(@NotNull final String status) {
        this.status = EnumUtil.stringToStatus(status);
    }

    public String getStatus() {
        return status.toString();
    }

    @Override
    public String toString() {
        return "Project{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", dateBegin=" + DateFormatterUtil.format(dateBegin) +
                ", dateEnd=" + DateFormatterUtil.format(dateEnd) +
                ", status=" + status +
                ", userId='" + userId + '\'' +
                '}';
    }
}
