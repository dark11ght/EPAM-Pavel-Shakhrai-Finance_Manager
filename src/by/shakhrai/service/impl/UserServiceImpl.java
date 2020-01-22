package by.shakhrai.service.impl;

import by.shakhrai.dao.AccountDao;
import by.shakhrai.dao.UserDao;
import by.shakhrai.dao.exception.DAOException;
import by.shakhrai.dao.factory.DaoFactory;
import by.shakhrai.entity.Account;
import by.shakhrai.entity.User;
import by.shakhrai.service.ServiceProperty;
import by.shakhrai.service.UserService;
import by.shakhrai.service.exeptoin.UserServiceExeption;
import by.shakhrai.service.validation.Validator;

public class UserServiceImpl implements UserService {
    private DaoFactory daoFactory = DaoFactory.getInstance();
    private UserDao userDao = daoFactory.getUserDao();
    private AccountDao accountDao = daoFactory.getAccountDao();

    @Override
    public User signUp(String login, String password) throws UserServiceExeption {
        if (login == null || login.isEmpty()) {
            throw new UserServiceExeption("Null logIn.");
        }

        if (password == null) {
            throw new UserServiceExeption("Password is null.");
        }


        if (!Validator.loginValid(login)) {
            throw new UserServiceExeption("Invalid login.");
        }

        if (!Validator.passValid(password)) {
            throw new UserServiceExeption("Invalid password.");
        }

        try {
            if (userDao.isUser(login)) {
                throw new UserServiceExeption("Login is already taken.");
            }
        } catch (DAOException e) {
            throw new UserServiceExeption(e);
        }
        String pass = password;
        User user = new User(login, pass);
        try {
            userDao.addUser(user);
        } catch (DAOException e) {
            throw new UserServiceExeption(e);
        }

        Account account = new Account(ServiceProperty.getStringValue("firstDefaultAccountName"), 0.0);
        try {
            accountDao.addAccount(user.getId(), account);
        } catch (DAOException e) {
            throw new UserServiceExeption("Failed to access users' data.", e);
        }
        return user;
    }

    @Override
    public User signIn(String login, String password) throws UserServiceExeption {
        if (login == null || login.isEmpty()) {
            throw new UserServiceExeption("Login is empty");
        }

        if (password == null) {
            throw new UserServiceExeption("Password is empty");
        }
        try {
            if (userDao.isUser(login)) {

                return userDao.getUser(login);

            } else {
                throw new UserServiceExeption("User or password incorrect");
            }
        } catch (DAOException e) {

            throw new UserServiceExeption("Failed user data ");
        }

    }

    @Override
    public void deactivateAccount(User user, char[] password) throws UserServiceExeption {
        //TODO write method

    }
}
