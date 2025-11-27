package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestConfig {

    private static Properties props = new Properties();

    static {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
            props.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Unable to load config.properties file!", e);
        }
    }

    public static String get(String key) {
        String value = props.getProperty(key);
        return value != null ? value.trim() : null;
    }
}
