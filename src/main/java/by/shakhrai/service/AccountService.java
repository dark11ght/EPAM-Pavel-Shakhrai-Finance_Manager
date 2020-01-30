package by.shakhrai.service;

import by.shakhrai.entity.Account;
import by.shakhrai.exceptions.AccountServiceException;

public interface AccountService {
    void addAccount(int userId, Account account) throws AccountServiceException;

    void editAccount(int userId, Account editedAccount) throws AccountServiceException;

    void deleteAccount(int userId, int accountId) throws AccountServiceException;

    Account[] getAccounts(int userId) throws AccountServiceException;
}
