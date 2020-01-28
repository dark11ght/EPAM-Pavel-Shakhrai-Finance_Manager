package by.shakhrai.service.exeptoin;

public class UserServiceExeption extends Exception{
    public UserServiceExeption() {
    }

    public UserServiceExeption(String message) {
        super(message);
    }

    public UserServiceExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public UserServiceExeption(Throwable cause) {
        super(cause);
    }
}
