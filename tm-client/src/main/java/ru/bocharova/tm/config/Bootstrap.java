package ru.bocharova.tm.config;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.bocharova.tm.api.service.IEndpointServiceLocator;
import ru.bocharova.tm.command.AbstractCommand;
import ru.bocharova.tm.service.EndpointServiceLocator;

import java.util.HashMap;
import java.util.Map;

public class Bootstrap {
    @NotNull
    final IEndpointServiceLocator endpointServiceLocator = new EndpointServiceLocator();

    public void init(Class[] arrayCommands) {
        menu(initializeCommands(endpointServiceLocator, arrayCommands));
    }

    private Map<String, AbstractCommand> initializeCommands(@NotNull final IEndpointServiceLocator endpointServiceLocator, @NotNull final Class[] arrayCommands) {
        @NotNull final Map<String, AbstractCommand> mapCommand = new HashMap<>();

        for (Class command : arrayCommands) {
            if (command.getSuperclass().equals(AbstractCommand.class)) {
                try {
                    AbstractCommand abstractCommand = (AbstractCommand) command.newInstance();
                    abstractCommand.setEndpointServiceLocator(endpointServiceLocator);
                    registryCommand(abstractCommand, mapCommand);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return mapCommand;
    }

    private void registryCommand(@NotNull final AbstractCommand abstractCommand, @NotNull final Map<String, AbstractCommand> command) {
        command.put(abstractCommand.getName(), abstractCommand);
    }

    private void menu(@NotNull final Map<String, AbstractCommand> commands) {
        System.out.println("==Добро пожаловать в Task manager!==\n" +
                "Введите help для получения информации по командам");

        while (true) {
            System.out.println("Введите Вашу команду:");
            @NotNull
            String commandName = endpointServiceLocator.getTerminalService().nextLine();
            @Nullable
            AbstractCommand command = commands.get(commandName);
            if (command != null) {
                command.execute();
            }
        }
    }
}