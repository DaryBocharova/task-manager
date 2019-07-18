package ru.bocharova.tm.command;

import org.jetbrains.annotations.NotNull;
import ru.bocharova.tm.api.endpoint.AuthenticationSecurityException_Exception;
import ru.bocharova.tm.api.service.IEndpointServiceLocator;
import ru.bocharova.tm.exception.AuthenticationSecurityException;

import java.io.IOException;

public abstract class AbstractCommand {
    protected IEndpointServiceLocator endpointServiceLocator;

    public abstract String getName();

    public abstract String getDescription();

    public abstract void execute() throws AuthenticationSecurityException_Exception, IOException, AuthenticationSecurityException;

    public abstract boolean isNeedAuthorization();

    public void setEndpointServiceLocator(@NotNull final IEndpointServiceLocator endpointServiceLocator) {
        this.endpointServiceLocator = endpointServiceLocator;
    }
}
