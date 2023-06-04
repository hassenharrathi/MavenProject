package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
    private static final String CONFIG_FILE = "src/main/java/resources/config.properties";
    private Properties properties;

    public Configuration() {
        properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream(CONFIG_FILE);
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getUsername(String key) {
        return properties.getProperty(key);
    }

    public String getPassword(String key) {
        return properties.getProperty(key);
    }

    // Autres méthodes de configuration
}