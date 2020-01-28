package by.shakhrai.service;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ServiceProperty {
    private static Properties properties;
    static {
        properties = new Properties();
        try {
            properties.load(new FileReader("src/src/main/java/by/shakhrai/properties/ServiceProperties.properties"));
        } catch (IOException ignored) {
        }
    }

    public static String getStringValue(String key){
        return properties.getProperty(key);
    }
}
