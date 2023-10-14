package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
    private String CONFIG_FILE;
    private Properties properties;

    public Configuration(String configFile) {
        this.CONFIG_FILE = configFile;
        properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream(configFile);
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

    public String getMail(String key) {
        return properties.getProperty(key);
    }

    // Autres méthodes de configuration
}