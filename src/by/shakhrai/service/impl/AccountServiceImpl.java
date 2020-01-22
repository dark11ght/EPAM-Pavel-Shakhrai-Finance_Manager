package by.shakhrai.service.impl;

import by.shakhrai.dao.AccountDao;
import by.shakhrai.dao.exception.DAOException;
import by.shakhrai.dao.factory.DaoFactory;
import by.shakhrai.entity.Account;
import by.shakhrai.service.AccountService;
import by.shakhrai.service.exeptoin.AccountServiceExeption;

public class AccountServiceImpl implements AccountService {
    private DaoFactory daoFactory = DaoFactory.getInstance();
    private AccountDao accountDAO = daoFactory.getAccountDao();


    @Override
    public void addAccount(int userId, Account account) throws AccountServiceExeption {
        if (account == null) {
            throw new AccountServiceExeption("Account is Null.");
        }

        if (account.getName().isEmpty() || account.getName() == null) {
            throw new AccountServiceExeption("Account name is Null.");
        }

        try {
            accountDAO.addAccount(userId, account);
        } catch (DAOException e) {
            throw new AccountServiceExeption("Failed account data", e);
        }
    }


    @Override
    public void editAccount(int userId, Account editedAccount) throws AccountServiceExeption {
        if (editedAccount == null) {
            throw new AccountServiceExeption("Account is Null.");
        }

        if (editedAccount.getName().isEmpty() || editedAccount.getName() == null) {
            throw new AccountServiceExeption("Account name is Null.");
        }

        try {

            if(!accountDAO.isAccount(userId, editedAccount.getId())){
                throw new AccountServiceExeption("Unknown account");
            }
            accountDAO.editAccount(userId, editedAccount);
        } catch (DAOException e) {
            throw new AccountServiceExeption("Failed account data.", e);
        }
    }

    @Override
    public void deleteAccount(int userId, int accountId) throws AccountServiceExeption {

    }

    @Override
    public Account[] getAccounts(int userId) throws AccountServiceExeption {
        Account[] accounts;
        try {
            accounts = accountDAO.getAllAccounts(userId);
        } catch (DAOException e) {
            throw new AccountServiceExeption("Failed account data.", e);
        }
        return accounts;
    }
}
