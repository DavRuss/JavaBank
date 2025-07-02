package Singleton;

public class ConfigManager {
    private static ConfigManager instance;
    private Properties configProperties;

    private ConfigManager() {
        configProperties = new Properties();
        // Load configuration properties
    }

    public static ConfigManager getInstance() {
        if (instance == null) {
            synchronized (ConfigManager.class) {
                if (instance == null) {
                    instance = new ConfigManager();
                }
            }
        }
        return instance;
    }

    public String getProperty(String key) {
        return configProperties.getProperty(key);
    }
}

