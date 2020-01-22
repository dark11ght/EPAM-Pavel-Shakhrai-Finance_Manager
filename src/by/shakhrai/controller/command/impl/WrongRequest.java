package by.shakhrai.controller.command.impl;

import by.shakhrai.controller.ControllerProperty;
import by.shakhrai.controller.command.Command;


public class WrongRequest implements Command {
    @Override
    public String executeRequest(String request) {
        return ControllerProperty.getStringValue("wrongRequestResponse");
    }
}
