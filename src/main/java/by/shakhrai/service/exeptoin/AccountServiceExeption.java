package by.shakhrai.service.exeptoin;

public class AccountServiceExeption extends Exception {
    public AccountServiceExeption() {
    }

    public AccountServiceExeption(String message) {
        super(message);
    }

    public AccountServiceExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountServiceExeption(Throwable cause) {
        super(cause);
    }
}
