package by.shakhrai.controller;

import by.shakhrai.controller.command.Command;

public final class Controller {
    private final CommandProvider commandProvider = new CommandProvider();
    private final char paramDelimetr = ' ';

    public String executeTask(String request) {
        String commandName;
        Command executeCommand;

        commandName = request.substring(0, request.indexOf(paramDelimetr));
        executeCommand = commandProvider.getCommand(commandName);

        String response;
        response = executeCommand.executeRequest(request);

        return response;
    }

}
