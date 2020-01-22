package by.shakhrai.controller.command.impl;

import by.shakhrai.controller.ControllerProperty;
import by.shakhrai.controller.command.Command;
import by.shakhrai.entity.Account;
import by.shakhrai.service.AccountService;
import by.shakhrai.service.exeptoin.AccountServiceExeption;
import by.shakhrai.service.factory.ServiceFactory;

public class GetAccounts implements Command {
    @Override
    public String executeRequest(String request) {
        String response = "";
        String[] requestData = request.split(delimiter);

        int id = Integer.parseInt(requestData[0]);

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        AccountService accountServiceImpl = serviceFactory.getAccountService();

        try {
            Account[] accounts = accountServiceImpl.getAccounts(id);
            StringBuilder stringBuilder = new StringBuilder();
            for (Account account : accounts) {
                stringBuilder.append(account.getId()).append(delimiter).append(account.getName()).append(delimiter).
                        append(account.getBalance()).append("\n");
            }
            response = stringBuilder.toString();
        } catch (AccountServiceExeption e) {
            response = ControllerProperty.getStringValue("failedToGetAccounts") + e.getMessage();
        }
        return response;
    }
}

