package ru.bocharova.tm.service;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;
import ru.bocharova.tm.api.service.ISessionService;
import ru.bocharova.tm.endpoint.SessionDTO;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@NoArgsConstructor
public class SessionService implements ISessionService {
    @Nullable
    private SessionDTO sessionDTO;


    @Override
    public SessionDTO getCurrentSession() {
        return sessionDTO;
    }

    @Override
    public void setCurrentSession(
            @Nullable final SessionDTO sessionDTO) {
        this.sessionDTO = sessionDTO;
    }
}
