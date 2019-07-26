package ru.bocharova.tm.api.command;

import ru.bocharova.tm.endpoint.AuthenticationSecurityException_Exception;
import ru.bocharova.tm.endpoint.DataValidateException_Exception;
import ru.bocharova.tm.endpoint.IOException_Exception;

public interface AbstractCommand {

    public abstract String getName();

    public abstract String getDescription();

    public abstract void execute(
    ) throws AuthenticationSecurityException_Exception, DataValidateException_Exception, IOException_Exception;
}
