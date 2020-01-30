package by.shakhrai.entity;

import java.io.Serializable;
import java.util.Date;


public class User implements Serializable {

    private final int id;
    private String login;
    private String password;


    public User() {
        id = new Date().hashCode();
    }


    public User(String login) {
        id = new Date().hashCode();
        this.login = login;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        id = new Date().hashCode();
    }

    public User(int id, String login) {
        this.id = id;
        this.login = login;
    }

    public User(int id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        User otherUser = (User) obj;
        if (id != otherUser.getId()) {
            return false;
        }
        if (login == null) {
            if (otherUser.login != null) {
                return false;
            }
        } else {
            if (!login.equals(otherUser.login)) {
                return false;
            }
        }

        if (password == null) {
            if (otherUser.password != null) {
                return false;
            }
        } else {
            if (!password.equals(otherUser.password)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return getClass().getName() + "@" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id;
    }
}
