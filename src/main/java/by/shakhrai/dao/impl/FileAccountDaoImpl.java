package by.shakhrai.dao.impl;

import by.shakhrai.dao.AccountDao;
import by.shakhrai.exceptions.DAOException;
import by.shakhrai.entity.Account;

import java.io.*;
import java.util.ArrayList;

public class FileAccountDaoImpl implements AccountDao {
    private File accountsFile;
    private String daoSeparator;

    public FileAccountDaoImpl(File file, String daoSeparator) {
        this.accountsFile = file;
        this.daoSeparator = daoSeparator;
    }

    public FileAccountDaoImpl(String path, String daoSeparator) {
        this.accountsFile = new File(path);
        this.daoSeparator = daoSeparator;
    }


    @Override
    public void addAccount(int userId, Account account) throws DAOException {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(accountsFile, true));
            bufferedWriter.write(userId + daoSeparator + account.getId()
                    + daoSeparator + account.getName() + daoSeparator + account.getBalance() + "\n");
        } catch (IOException e) {
            throw new DAOException(e);
        }

    }

    @Override
    public void editAccount(int userId, Account editedAccount) throws DAOException {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(accountsFile, true));
            bufferedWriter.write(userId + daoSeparator + editedAccount.getId()
                    + daoSeparator + editedAccount.getName() + daoSeparator + editedAccount.getBalance() + "\n");
        } catch (IOException e) {
            throw new DAOException(e);
        }

    }

    @Override
    public void deleteAccount(int userId, int accountId) throws DAOException {
        //TODO write method

    }

    @Override
    public Account[] getAllAccounts(int userId) throws DAOException {

        try {
            ArrayList <Account> accounts = new ArrayList <>();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(accountsFile));
            String currentLine, currentUserId;
            String[] account;
            while ((currentLine = bufferedReader.readLine()) != null) {
                account = currentLine.split(daoSeparator);
                currentUserId = account[0];
                if (!currentUserId.equals(String.valueOf(userId))) {
                    continue;
                }

                accounts.add(new Account(Integer.parseInt(account[1]), account[2], Double.parseDouble(account[3])));
            }

            Account[] accountsArray = new Account[accounts.size()];
            return accounts.toArray(accountsArray);
        } catch (IOException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public Account getAccount(int userId, int accountId) throws DAOException {
        try {
            boolean isFound = false;
            BufferedReader bufferedReader = new BufferedReader(new FileReader(accountsFile));
            String currentLine, currentUserAccountId, currentUserId;
            String[] accounts;
            Account account = new Account();
            while ((currentLine = bufferedReader.readLine()) != null) {
                accounts = currentLine.split(daoSeparator);
                currentUserId = accounts[0];
                currentUserAccountId = accounts[1];
                if (currentUserId.equals(String.valueOf(userId)) && currentUserAccountId.equals(String.valueOf(accountId))) {
                    account = new Account(Integer.parseInt(accounts[1]), accounts[2], Double.parseDouble(accounts[3]));
                    isFound = true;
                    break;
                }
            }

            if (!isFound) {
                throw new DAOException("Account not found");
            }
            return account;
        } catch (IOException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public boolean isAccount(int userId, int accountId) throws DAOException {
        boolean isFound = false;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(accountsFile));
            String currentLine, currentAccountUserId, currentAccountId;
            String[] accountInfo;
            while ((currentLine = bufferedReader.readLine()) != null) {

                accountInfo = currentLine.split(daoSeparator);
                currentAccountUserId = accountInfo[0];
                currentAccountId = accountInfo[1];
                if (!(currentAccountUserId.equals(String.valueOf(userId)) && currentAccountId.equals(String.valueOf(accountId)))) {
                    continue;
                }
                isFound = true;
            }
        } catch (IOException e) {
            throw new DAOException(e);
        }
        return isFound;
    }
}

