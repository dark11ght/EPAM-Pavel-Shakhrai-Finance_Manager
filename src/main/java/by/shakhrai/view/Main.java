package by.shakhrai.view;

import by.shakhrai.controller.Controller;


public class Main {

    public static void main(String[] args) {
        String delimiter = " ";
        Controller controller = new Controller();

        String signInResponse = controller.executeTask("Sign_In pavel password");
        System.out.println(signInResponse);

    }

}

