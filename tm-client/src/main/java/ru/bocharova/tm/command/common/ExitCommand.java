package ru.bocharova.tm.command.common;

import lombok.NoArgsConstructor;
import ru.bocharova.tm.command.ICommand;

@NoArgsConstructor
public final class ExitCommand implements ICommand {

    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public String getDescription() {
        return "Quit from application.";
    }

    @Override
    public void execute() {
        System.exit(0);
    }
}
