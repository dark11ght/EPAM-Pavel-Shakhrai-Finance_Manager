package by.shakhrai.controller.command.impl;

import by.shakhrai.controller.ControllerProperty;
import by.shakhrai.controller.command.Command;
import by.shakhrai.entity.Account;
import by.shakhrai.service.AccountService;
import by.shakhrai.exceptions.AccountServiceException;
import by.shakhrai.factory.ServiceFactory;


public class AddAccount implements Command {
    @Override
    public String executeRequest(String request) {
        String response;
        String[] requestData = request.split(delimiter);

        int userId = Integer.parseInt(requestData[0]);
        String accountName = requestData[1];
        double balance = Double.parseDouble(requestData[2]);

        Account account = new Account(accountName, balance);

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        AccountService financeTracker = serviceFactory.getAccountService();

        try {
            financeTracker.addAccount(userId, account);
            response = ControllerProperty.getStringValue("accountAdd");
        } catch (AccountServiceException e) {
            response = ControllerProperty.getStringValue("failedToAddAccount") + e.getMessage();
        }
        return response;
    }
}
