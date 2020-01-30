package by.shakhrai.controller;

import by.shakhrai.controller.command.Command;
import by.shakhrai.controller.command.CommandName;
import by.shakhrai.controller.command.impl.GetAccounts;
import by.shakhrai.controller.command.impl.SignIn;
import by.shakhrai.controller.command.impl.SignUp;
import by.shakhrai.controller.command.impl.WrongRequest;

import java.util.HashMap;
import java.util.Map;

public final class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();

    CommandProvider() {
        repository.put(CommandName.SIGN_IN, new SignIn());
        repository.put(CommandName.SIGN_UP, new SignUp());
        repository.put(CommandName.ADD_ACCOUNT, new GetAccounts());
        repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
    }

    Command getCommand(String name) {
        CommandName commandName = null;
        Command command = null;
        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e) {
            command = repository.get(CommandName.WRONG_REQUEST);

        }
        return command;
    }

}
