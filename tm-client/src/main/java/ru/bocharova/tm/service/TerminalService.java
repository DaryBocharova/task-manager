package ru.bocharova.tm.service;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import ru.bocharova.tm.api.service.ITerminalService;

import java.util.Scanner;

@NoArgsConstructor
public class TerminalService implements ITerminalService {

    @NotNull
    final Scanner scanner = new Scanner(System.in);

    @Override
    public String nextLine() {
        return scanner.nextLine();
    }
}
