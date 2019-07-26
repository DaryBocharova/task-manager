package ru.bocharova.tm.api.service;

import org.jetbrains.annotations.Nullable;
import ru.bocharova.tm.endpoint.SessionDTO;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface ISessionService {
    SessionDTO getCurrentSession();

    void setCurrentSession(@Nullable final SessionDTO sessionDTO);
}
