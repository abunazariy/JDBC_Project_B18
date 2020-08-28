package com.cybertek.jdbc.Utility;

import java.io.FileInputStream;
import java.util.Properties;

public class Configuration_Reader {

    private static Properties properties = new Properties();

    static {
        try {
            FileInputStream file = new FileInputStream("configuration.properties");
            properties.load(file);
            file.close();
        } catch (Exception e) {
            System.out.println("Properties File Not Found");
        }

    }
    public static String getProperty(String keyWord){
        return properties.getProperty(keyWord);
    }
}
