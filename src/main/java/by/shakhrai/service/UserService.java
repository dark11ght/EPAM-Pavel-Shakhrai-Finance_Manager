package by.shakhrai.service;

import by.shakhrai.entity.User;
import by.shakhrai.exceptions.UserServiceException;

public interface UserService {

    User signUp(String login, String password) throws UserServiceException;

    User signIn(String login, String password) throws UserServiceException;

    void deactivateAccount(User user, char[] password) throws UserServiceException;


}
