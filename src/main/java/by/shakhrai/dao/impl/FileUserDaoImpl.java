package by.shakhrai.dao.impl;
import by.shakhrai.dao.UserDao;
import by.shakhrai.exceptions.DAOException;
import by.shakhrai.entity.User;

import java.io.*;
import java.util.Scanner;

public class FileUserDaoImpl implements UserDao {
    private File userFile;
    private String daoSeparator;


    public FileUserDaoImpl(File userFile, String daoSeparator) {
        this.userFile = userFile;
        this.daoSeparator = daoSeparator;
    }

    public FileUserDaoImpl(String path, String dataSeparator) {
        this.userFile = new File(path);
        this.daoSeparator = dataSeparator;
    }

    @Override
    public void addUser(User user) throws DAOException {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(userFile, true));
            bufferedWriter.write(user.getId() + daoSeparator + user.getLogin() + daoSeparator + user.getPassword() +
                    "\n");
        } catch (IOException e) {
            throw new DAOException(e);
        }

    }

    @Override
    public User getUser(String login) throws DAOException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(userFile));
            String line;
            String[] user;

            while ((line = bufferedReader.readLine()) != null) {
                user = line.split(daoSeparator);
                if (login.equals(user[1])) {
                    int id = Integer.parseInt(user[0]);
                    return new User(id, login);
                }
            }

        } catch (IOException e) {
            throw new DAOException(e);
        }
        throw new DAOException("User nor found");

    }

    @Override
    public boolean isUser(String login, String password) throws DAOException {
        try {
            Scanner scanner = new Scanner(userFile);
                        String[] user;
            while (scanner.hasNextLine()) {
                user = scanner.nextLine().split(daoSeparator);
                if (login.equals(user[1]) && password.equals(user[2])) {
                    return true;
                }
            }

        } catch (FileNotFoundException e) {
            throw new DAOException(e);
        }
        return false;
    }


    @Override
    public boolean isUser(String login) throws DAOException {
        try {
            Scanner scanner = new Scanner(userFile);
            String[] user;
            while (scanner.hasNextLine()) {
                user = scanner.nextLine().split(daoSeparator);
                if (login.equals(user[1])) {
                    return true;
                }
            }

        } catch (FileNotFoundException e) {
            throw new DAOException(e);
        }
        return false;
    }


    @Override
    public void deleteUser(int userId) throws DAOException {
        //TODO write method

    }


}
