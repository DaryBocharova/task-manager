package ru.bocharova.tm.api.service;

public interface IPropertyService {

    String getJdbcPassword();

    String getJdbcUser();

    String getJdbcURL();

    String getJdbcDriver();

    String getSalt();

    String getCycle();
}