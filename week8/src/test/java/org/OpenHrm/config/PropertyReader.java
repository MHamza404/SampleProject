package org.OpenHrm.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    static Properties prop = new Properties();
    static FileInputStream fs;

    static{
        try {
            fs = new FileInputStream("src/test/java/resources/config.properties");
            prop.load(fs);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public static String getProperty(String identifier) {
        return prop.getProperty(identifier);
    }



}


