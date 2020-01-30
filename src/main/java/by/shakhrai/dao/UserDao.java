package by.shakhrai.dao;

import by.shakhrai.exceptions.DAOException;
import by.shakhrai.entity.User;

public interface UserDao {
    void addUser(User user) throws DAOException;

    User getUser(String login) throws DAOException;

    boolean isUser(String login, String password) throws DAOException;

    boolean isUser(String login) throws DAOException;

    void deleteUser(int userId) throws DAOException;


}
