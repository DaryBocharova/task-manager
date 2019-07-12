package ru.bocharova.tm.command.system;

import ru.bocharova.tm.command.AbstractCommand;

public final class ExitCommand extends AbstractCommand {

    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public String getDescription() {
        return "If input exit";
    }

    @Override
    public void execute() {
        System.exit(0);
    }

    @Override
    public boolean isNeedAuthorization() {
        return false;
    }
}
