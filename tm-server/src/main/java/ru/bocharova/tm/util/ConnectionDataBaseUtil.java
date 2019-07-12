package ru.bocharova.tm.util;

import org.jetbrains.annotations.NotNull;

import java.sql.*;

public class ConnectionDataBaseUtil {

   static public Connection create(@NotNull final String url, @NotNull final String user, @NotNull final String password){
       try (Connection connection  = DriverManager.getConnection(url, user, password)) {
           return connection;

       } catch (SQLException e) {
           e.printStackTrace();
       }
       return null;
   }
}
