package ru.bocharova.tm.command;

import ru.bocharova.tm.endpoint.AuthenticationSecurityException_Exception;
import ru.bocharova.tm.endpoint.DataValidateException_Exception;

public interface ICommand {

    public abstract String getName();

    public abstract String getDescription();

    public abstract void execute(
    ) throws AuthenticationSecurityException_Exception, DataValidateException_Exception;
}
