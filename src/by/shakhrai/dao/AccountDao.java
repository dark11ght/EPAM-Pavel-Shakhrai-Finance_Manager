package by.shakhrai.dao;

import by.shakhrai.dao.exception.DAOException;
import by.shakhrai.entity.Account;

public interface AccountDao {
    void addAccount(int userId, Account account) throws DAOException;

    void editAccount(int userId, Account editedAccount) throws DAOException;

    void deleteAccount(int userId, int accountId) throws DAOException;

    Account[] getAllAccounts(int userId) throws DAOException;

    Account getAccount(int userId, int accountId) throws DAOException;

    boolean isAccount(int userId, int accountId) throws DAOException;
}
