package by.shakhrai.dao.factory;

import by.shakhrai.dao.AccountDao;
import by.shakhrai.dao.DaoProperty;
import by.shakhrai.dao.UserDao;
import by.shakhrai.dao.impl.FileAccountDaoImpl;
import by.shakhrai.dao.impl.FileUserDaoImpl;


public final class DaoFactory {

    private static final DaoFactory instance = new DaoFactory();

    private final String daoSeparator = DaoProperty.getStringValue("daoSeparator");
    private final UserDao fileUserDaoImpl = new FileUserDaoImpl(DaoProperty.getStringValue("usersFilePath"), daoSeparator);
    private final AccountDao fileAccountDaoImpl = new FileAccountDaoImpl(DaoProperty.getStringValue("accountsFilePath"), daoSeparator);


    private DaoFactory() {

    }

    public static DaoFactory getInstance() {
        return instance;
    }

    public UserDao getUserDao(){
        return fileUserDaoImpl;
    }

    public AccountDao getAccountDao(){
        return fileAccountDaoImpl;
    }



}
