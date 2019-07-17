package ru.bocharova.tm.util;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class ParameterValidator {

    public static boolean validate(@NotNull final String parameter){

        Map<String, String> parameters = new HashMap<>(4);
        parameters.put("order", "order");
        parameters.put("dateStart", "datesStart");
        parameters.put("dateEnd", "dateEnd");
        parameters.put("status", "status");
        if (parameters.get(parameter)==null) return false;
        return true;
    }
}
