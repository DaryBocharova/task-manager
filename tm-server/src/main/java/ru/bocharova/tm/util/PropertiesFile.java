package ru.bocharova.tm.util;

import org.jetbrains.annotations.NotNull;
import ru.bocharova.tm.AppServer;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFile {

    public static Properties load(Class main){
        @NotNull final Properties propertiesFile = new Properties();
        try (InputStream resourceStream = main.getClassLoader().getResourceAsStream("application.properties")) {
            propertiesFile.load(resourceStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return propertiesFile;
    }
}
