package by.shakhrai.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ControllerProperty {
    private static Properties properties;

    static {
        properties = new Properties();
        try {
            properties.load(new FileReader("src/src/main/java/by/shakhrai/properties/ControllerProperties.properties"));
        } catch (IOException ignored) {
        }
    }

    public static String getStringValue(String key) {
        return properties.getProperty(key);
    }
}


