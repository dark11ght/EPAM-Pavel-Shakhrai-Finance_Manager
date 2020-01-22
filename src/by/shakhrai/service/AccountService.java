package by.shakhrai.service;

import by.shakhrai.entity.Account;
import by.shakhrai.service.exeptoin.AccountServiceExeption;

public interface AccountService {
    void addAccount(int userId, Account account) throws AccountServiceExeption;

    void editAccount(int userId, Account editedAccount) throws AccountServiceExeption;

    void deleteAccount(int userId, int accountId) throws AccountServiceExeption;

    Account[] getAccounts(int userId) throws AccountServiceExeption;
}
