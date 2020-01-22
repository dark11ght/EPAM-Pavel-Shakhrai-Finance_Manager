package by.shakhrai.entity;

import java.io.Serializable;
import java.util.Date;


public class Account implements Serializable {
    private final int id;
    private String name;
    private double balance;


    public Account() {
        id = new Date().hashCode();
    }

    public Account(String name, double balance) {
        id = new Date().hashCode();
        this.name = name;
        this.balance = balance;
    }

    public Account(int id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Account otherAccount = (Account) obj;
        if (id != otherAccount.id) {
            return false;
        }
        if (name == null) {
            if (otherAccount.name != null) {
                return false;
            }
        } else {
            if (!name.equals(otherAccount.name)) {
                return false;
            }
        }

        if (balance != otherAccount.balance) {
            return false;
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance;
    }
}
