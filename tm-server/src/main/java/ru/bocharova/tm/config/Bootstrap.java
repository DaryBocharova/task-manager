package ru.bocharova.tm.config;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import ru.bocharova.tm.api.endpoint.IProjectEndpoint;
import ru.bocharova.tm.api.endpoint.ISessionEndpoint;
import ru.bocharova.tm.api.endpoint.ITaskEndpoint;
import ru.bocharova.tm.api.endpoint.IUserEndpoint;
import ru.bocharova.tm.util.DataGenerator;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.xml.ws.Endpoint;

@ApplicationScoped
@NoArgsConstructor
public class Bootstrap {

    @Inject
    @NotNull
    private IProjectEndpoint projectEndpoint;

    @Inject
    @NotNull
    private ITaskEndpoint taskEndpoint;

    @Inject
    @NotNull
    private IUserEndpoint userEndpoint;

    @Inject
    @NotNull
    private ISessionEndpoint sessionEndpoint;

    @Inject
    @NotNull
    private DataGenerator dataGenerator;


    public void init() {
        dataGenerator.generateUsers();
        dataGenerator.generateData();
        registryEndpoint();
    }

    private void registryEndpoint() {

        String wsdl = "http://localhost:80/" + projectEndpoint.getClass().getSimpleName() + "?wsdl";
        Endpoint.publish(wsdl, projectEndpoint);
        System.out.println(wsdl);

        wsdl = "http://localhost:80/" + taskEndpoint.getClass().getSimpleName() + "?wsdl";
        Endpoint.publish(wsdl, taskEndpoint);
        System.out.println(wsdl);

        wsdl = "http://localhost:80/" + userEndpoint.getClass().getSimpleName() + "?wsdl";
        Endpoint.publish(wsdl, userEndpoint);
        System.out.println(wsdl);

        wsdl = "http://localhost:80/" + sessionEndpoint.getClass().getSimpleName() + "?wsdl";
        Endpoint.publish(wsdl, sessionEndpoint);
        System.out.println(wsdl);
    }
}
