package ru.bocharova.tm;

import org.jetbrains.annotations.NotNull;
import ru.bocharova.tm.api.endpoint.AuthenticationSecurityException_Exception;
import ru.bocharova.tm.config.Bootstrap;
import ru.bocharova.tm.endpoint.*;

import java.io.IOException;

public class AppClient {
    public static void main(String[] args) throws AuthenticationSecurityException_Exception, IOException{
        @NotNull final Bootstrap bootstrap = new Bootstrap();
        Class[] endpoints = new Class[]{ProjectEndpoint.class, TaskEndpoint.class, UserEndpoint.class,
                SessionEndpoint.class, AdminEndpoint.class};
        bootstrap.init(endpoints);
    }
}