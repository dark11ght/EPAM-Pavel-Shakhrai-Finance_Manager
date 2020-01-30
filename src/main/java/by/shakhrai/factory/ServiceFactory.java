package by.shakhrai.factory;

import by.shakhrai.service.AccountService;
import by.shakhrai.service.UserService;
import by.shakhrai.service.impl.AccountServiceImpl;
import by.shakhrai.service.impl.UserServiceImpl;

public final class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final UserService userServiceImpl = new UserServiceImpl();
    private final AccountService accountServiceImpl = new AccountServiceImpl();

    private ServiceFactory() {
    }


    public static ServiceFactory getInstance() {
        return instance;
    }

    public UserService getUserService() {
        return userServiceImpl;

    }

    public AccountService getAccountService(){
        return accountServiceImpl;
    }
}
