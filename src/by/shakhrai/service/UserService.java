package by.shakhrai.service;

import by.shakhrai.entity.User;
import by.shakhrai.service.exeptoin.UserServiceExeption;

public interface UserService {

    User signUp(String login, String password) throws UserServiceExeption;

    User signIn(String login, String password) throws UserServiceExeption;

    void deactivateAccount(User user, char[] password) throws UserServiceExeption;


}
