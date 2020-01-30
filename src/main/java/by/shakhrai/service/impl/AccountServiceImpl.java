package by.shakhrai.service.impl;

import by.shakhrai.dao.AccountDao;
import by.shakhrai.exceptions.DAOException;
import by.shakhrai.factory.DaoFactory;
import by.shakhrai.entity.Account;
import by.shakhrai.service.AccountService;
import by.shakhrai.exceptions.AccountServiceException;

public class AccountServiceImpl implements AccountService {
    private DaoFactory daoFactory = DaoFactory.getInstance();
    private AccountDao accountDAO = daoFactory.getAccountDao();


    @Override
    public void addAccount(int userId, Account account) throws AccountServiceException {
        if (account == null) {
            throw new AccountServiceException("Account is Null.");
        }

        if (account.getName().isEmpty() || account.getName() == null) {
            throw new AccountServiceException("Account name is Null.");
        }

        try {
            accountDAO.addAccount(userId, account);
        } catch (DAOException e) {
            throw new AccountServiceException("Failed account data", e);
        }
    }


    @Override
    public void editAccount(int userId, Account editedAccount) throws AccountServiceException {
        if (editedAccount == null) {
            throw new AccountServiceException("Account is Null.");
        }

        if (editedAccount.getName().isEmpty() || editedAccount.getName() == null) {
            throw new AccountServiceException("Account name is Null.");
        }

        try {

            if(!accountDAO.isAccount(userId, editedAccount.getId())){
                throw new AccountServiceException("Unknown account");
            }
            accountDAO.editAccount(userId, editedAccount);
        } catch (DAOException e) {
            throw new AccountServiceException("Failed account data.", e);
        }
    }

    @Override
    public void deleteAccount(int userId, int accountId) throws AccountServiceException {

    }

    @Override
    public Account[] getAccounts(int userId) throws AccountServiceException {
        Account[] accounts;
        try {
            accounts = accountDAO.getAllAccounts(userId);
        } catch (DAOException e) {
            throw new AccountServiceException("Failed account data.", e);
        }
        return accounts;
    }
}
