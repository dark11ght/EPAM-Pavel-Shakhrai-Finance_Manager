package by.shakhrai.dao;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class DaoProperty {
    private static Properties properties;
    static {
        properties = new Properties();
        try {
            properties.load(new FileReader("src/main/java/by/shakhrai/properties/DAOProperties.properties"));
        } catch (IOException ignored) {
        }
    }

    public static String getStringValue(String key){
        return properties.getProperty(key);
    }
}

