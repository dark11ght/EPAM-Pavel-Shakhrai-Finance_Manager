package by.shakhrai.service.validation;

public class Validator {
    private static final String LOGIN_PASS_PATTERN = "^[a-zA-Z][a-zA-Z0-9-_\\.]{1,20}$";



    public static boolean loginValid(String login) {
        if (login.matches(LOGIN_PASS_PATTERN)){
            return true;
        }
        return false;
    }

    public static boolean passValid(char[] pass) {
        String password = String.valueOf(pass);

        if (!password.matches(LOGIN_PASS_PATTERN)) {
            return true;
        }
        return false;
    }
}
