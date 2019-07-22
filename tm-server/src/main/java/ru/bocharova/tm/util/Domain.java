package ru.bocharova.tm.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import ru.bocharova.tm.model.entity.*;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "Domain")
@XmlAccessorType(XmlAccessType.FIELD)
public class Domain implements Serializable {

    @NotNull
    @XmlElementWrapper(name = "projects")
    @XmlElement(name = "projects")
    private Collection<Project> projects;

    @NotNull
    @XmlElementWrapper(name = "tasks")
    @XmlElement(name = "tasks")
    private Collection<Task> tasks;

    @NotNull
    @XmlElementWrapper(name = "users")
    @XmlElement(name = "users")
    private Collection<User> users;

    public <E> Domain(ArrayList<E> es, ArrayList<E> es1) {
    }
}
