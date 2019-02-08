package com.epam.brest.course.dataProvider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Properties;

public class DataFileProviderImpl implements DataProvider {

    private Properties properties;

    private String fileName;

    private static final Logger LOGGER = LogManager.getLogger();

    public DataFileProviderImpl(String fileName) {
        LOGGER.debug("Create object DataFileProviderImpl.");
        properties = new Properties();
        this.fileName = fileName;
        setPropertiesFromFile();
    }

    public BigDecimal getCoefficientDeliveryPerKg() {
        LOGGER.debug("Get coefficient delivery per kg.");
        if (properties != null)
            return BigDecimal.valueOf(Double.parseDouble(properties.getProperty("app.costPerKg")));
        else
            return null;
    }

    public BigDecimal getCoefficientDeliveryPerKm() {
        LOGGER.debug("Get coefficient delivery per km.");
        if (properties != null)
            return BigDecimal.valueOf(Double.parseDouble(properties.getProperty("app.costPerKm")));
        else
            return null;
    }

    private void setPropertiesFromFile() {
        InputStream inputStream;
        try {
            inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
            if (inputStream == null) {
                LOGGER.error("File with name = [{}] not found.", fileName);
                return;
            }
            properties.load(inputStream);
            inputStream.close();

        } catch (IOException ex) {
            LOGGER.error("Error of reading file. Exception = [{}]", ex);
        }
    }
}
