package org.example.properties;

import lombok.NonNull;
import org.example.Program;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class PropertyManagerImpl implements PropertyManager {

    private static final Logger logger = LoggerFactory.getLogger(PropertyManagerImpl.class);
    private String configFilePath;
    private Properties properties = null;

    public PropertyManagerImpl(@NonNull String configFilePath) throws Exception {
        this.configFilePath = configFilePath;
        this.boot();
    }

    protected void boot() throws Exception {
        logger.info("Booting property manager, loading config: {}", this.configFilePath);
        this.properties = new Properties();
        this.properties.load(Program.class.getResourceAsStream(this.configFilePath));
    }

    @Override
    public String get(@NonNull String key) {
        return this.properties.getProperty(key);
    }
}
