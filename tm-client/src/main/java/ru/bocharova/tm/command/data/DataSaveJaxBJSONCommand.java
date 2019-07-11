package ru.bocharova.tm.command.data;

import org.jetbrains.annotations.NotNull;
import ru.bocharova.tm.api.endpoint.AuthenticationSecurityException_Exception;
import ru.bocharova.tm.api.endpoint.Session;
import ru.bocharova.tm.command.AbstractCommand;
import ru.bocharova.tm.endpoint.UserEndpoint;

public class DataSaveJaxBJSONCommand  extends AbstractCommand {

    @NotNull
    @Override
    public String getName() {
        return "data-save-jaxb-json";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Save data from json file provided by jaxb.";
    }

    @NotNull
    @Override
    public void execute() throws AuthenticationSecurityException_Exception {
        @NotNull final UserEndpoint userEndpoint = endpointServiceLocator.getUserEndpoint();
        @NotNull final Session currentSession = endpointServiceLocator.getSession();
        endpointServiceLocator.getSessionEndpoint().validateSession(currentSession);
        userEndpoint.saveUserDataJaxbJSON(currentSession);
        System.out.println("Success all data load!");
    }

    @NotNull
    @Override
    public boolean isNeedAuthorization() {
        return true;
    }
}

