package by.shakhrai.service.impl;

import by.shakhrai.dao.AccountDao;
import by.shakhrai.dao.UserDao;
import by.shakhrai.exceptions.DAOException;
import by.shakhrai.factory.DaoFactory;
import by.shakhrai.entity.Account;
import by.shakhrai.entity.User;
import by.shakhrai.service.ServiceProperty;
import by.shakhrai.service.UserService;
import by.shakhrai.exceptions.UserServiceException;
import by.shakhrai.service.validation.Validator;

public class UserServiceImpl implements UserService {
    private DaoFactory daoFactory = DaoFactory.getInstance();
    private UserDao userDao = daoFactory.getUserDao();
    private AccountDao accountDao = daoFactory.getAccountDao();

    @Override
    public User signUp(String login, String password) throws UserServiceException {
        if (login == null || login.isEmpty()) {
            throw new UserServiceException("Null logIn.");
        }

        if (password == null) {
            throw new UserServiceException("Password is null.");
        }


        if (!Validator.loginValid(login)) {
            throw new UserServiceException("Invalid login.");
        }

        if (!Validator.passValid(password)) {
            throw new UserServiceException("Invalid password.");
        }

        try {
            if (userDao.isUser(login)) {
                throw new UserServiceException("Login is already taken.");
            }
        } catch (DAOException e) {
            throw new UserServiceException(e);
        }
        String pass = password;
        User user = new User(login, pass);
        try {
            userDao.addUser(user);
        } catch (DAOException e) {
            throw new UserServiceException(e);
        }

        Account account = new Account(ServiceProperty.getStringValue("firstDefaultAccountName"), 0.0);
        try {
            accountDao.addAccount(user.getId(), account);
        } catch (DAOException e) {
            throw new UserServiceException("Failed to access users' data.", e);
        }
        return user;
    }

    @Override
    public User signIn(String login, String password) throws UserServiceException {
        if (login == null || login.isEmpty()) {
            throw new UserServiceException("Login is empty");
        }

        if (password == null) {
            throw new UserServiceException("Password is empty");
        }
        try {
            if (userDao.isUser(login)) {

                return userDao.getUser(login);

            } else {
                throw new UserServiceException("User or password incorrect");
            }
        } catch (DAOException e) {

            throw new UserServiceException("Failed user data ");
        }

    }

    @Override
    public void deactivateAccount(User user, char[] password) throws UserServiceException {
        //TODO write method

    }
}
