package ru.bocharova.tm.config;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import ru.bocharova.tm.api.endpoint.IEndPoint;
import ru.bocharova.tm.api.service.*;
import ru.bocharova.tm.entity.Project;
import ru.bocharova.tm.service.*;

import javax.xml.ws.Endpoint;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

@NoArgsConstructor
public class Bootstrap{
    public void init(Class[] endpoints) {
        @NotNull final IServiceLocator serviceLocator = new ServiceLocator();
        registryEndpoint(endpoints, serviceLocator);
    }

    private void registryEndpoint(@NotNull final Class[] endpoints, IServiceLocator serviceLocator) {
        for (Class endpoint:endpoints){
            if (endpoint == null) continue;
            if(endpoint.isInterface()) continue;
            if(endpoint.getSuperclass().equals(IEndPoint.class)) continue;
            Constructor endpointConstructor = null;
            try {
                endpointConstructor = endpoint.getConstructor(IServiceLocator.class);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            String wsdl = "http://localhost:80/" + endpoint.getSimpleName() + "?wsdl";
            try {
                Endpoint.publish(wsdl, endpointConstructor.newInstance(serviceLocator));
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            System.out.println(wsdl);
        }
    }
}