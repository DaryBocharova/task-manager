package ru.bocharova.tm;

import org.jetbrains.annotations.NotNull;
import ru.bocharova.tm.config.Bootstrap;
import ru.bocharova.tm.endpoint.ProjectEndpoint;
import ru.bocharova.tm.endpoint.SessionEndpoint;
import ru.bocharova.tm.endpoint.TaskEndpoint;
import ru.bocharova.tm.endpoint.UserEndpoint;

public class AppClient {
    public static void main(String[] args) {
        @NotNull final Bootstrap bootstrap = new Bootstrap();
        Class[] endpoints = new Class[]{ProjectEndpoint.class, TaskEndpoint.class, UserEndpoint.class, SessionEndpoint.class};
        bootstrap.init(endpoints);
    }
}