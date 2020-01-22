package by.shakhrai.controller.command;

public interface Command {
    String delimiter = " ";
    String executeRequest(String request);
}
