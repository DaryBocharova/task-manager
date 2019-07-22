package ru.bocharova.tm;

import org.jetbrains.annotations.NotNull;
import ru.bocharova.tm.config.Bootstrap;
import ru.bocharova.tm.endpoint.*;

import java.io.IOException;

public class AppServer {

    public static void main(String[] args) throws IOException {
        @NotNull final Bootstrap bootstrap = new Bootstrap();
        Class[] endpoints = new Class[]{ProjectEndpoint.class, TaskEndpoint.class, UserEndpoint.class, SessionEndpoint.class};
        bootstrap.init(endpoints);
    }
}


