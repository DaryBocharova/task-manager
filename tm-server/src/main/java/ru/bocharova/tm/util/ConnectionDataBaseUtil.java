package ru.bocharova.tm.util;

import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.Properties;

public class ConnectionDataBaseUtil {

    @SneakyThrows
    static public Connection create(@NotNull final Properties properties) {
        @NotNull final String url = properties.getProperty("url");
        @NotNull final String user = properties.getProperty("user");
        @NotNull final String driver = properties.getProperty("com.mysql.jdbc.Driver");
        @NotNull final String password = properties.getProperty("password");
        return DriverManager.getConnection(url, user, password);
    }
}
