package com.epam.brest.course.dataProvider;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Properties;

public class DataProvider {

    private Properties properties;

    private String fileName;

    public DataProvider(String fileName) {
        properties = new Properties();
        this.fileName = fileName;
    }

    public void setPropertiesFromFile() {
        InputStream inputStream;
        try {
            inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
            if (inputStream == null) {
                System.out.println("File with name = [" + fileName + "] not found.");
                return;
            }
            properties.load(inputStream);
            inputStream.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public BigDecimal getCoefficientDelivery() {
        setPropertiesFromFile();
        if (properties != null)
            return BigDecimal.valueOf(Double.parseDouble(properties.getProperty("app.costPerKg")));
        else
            return null;
    }
}
