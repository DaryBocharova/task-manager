package ru.bocharova.tm.command.system;

import com.jcabi.manifests.Manifests;
import ru.bocharova.tm.command.AbstractCommand;

public class AboutCommand extends AbstractCommand {

    @Override
    public String getName() {
        return "about";
    }

    @Override
    public String getDescription() {
        return "About build";
    }

    @Override
    public void execute() {
        String version = Manifests.read("Implementation-Version");
        String developer = Manifests.read("Created-By");
        System.out.println("Version: " + version);
        System.out.println("Created by: " + developer);
    }

    @Override
    public boolean isNeedAuthorization() {
        return false;
    }
}
