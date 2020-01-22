package by.shakhrai.controller.command.impl;

import by.shakhrai.controller.ControllerProperty;
import by.shakhrai.controller.command.Command;
import by.shakhrai.entity.User;
import by.shakhrai.service.UserService;
import by.shakhrai.service.exeptoin.UserServiceExeption;
import by.shakhrai.service.factory.ServiceFactory;

public class SignIn implements Command {


    @Override
    public String executeRequest(String request) {
        String response = "";

        String[] requestData = request.split(delimiter);
        String login = requestData[1];
        char[] password = requestData[2].toCharArray();

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserService userService = serviceFactory.getUserService();

        try{
            User user = userService.signIn(login, password);
            response = user.getId() + delimiter + user.getLogin();
        }catch (UserServiceExeption e){
            response = ControllerProperty.getStringValue("signInFailed") + e.getMessage();

        }

        return response;
    }
}
