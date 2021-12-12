package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Project Name    : selenium-testng-page-factory-extended
 * Developer       : Osanda Deshan
 * Version         : 1.0.0
 * Date            : 10/19/2021
 * Time            : 1:36 PM
 * Description     :
 **/

public class PropertyFileReader {

    public static String getPropertyValueFromLoginCredentials(String propertyName) {
        return getPropertyValue("login_credentials.properties", propertyName);
    }

    public static String getPropertyValueFromEnvironment(String propertyName) {
        return getPropertyValue("environment.properties", propertyName);
    }

    private static String getPropertyValue(String propertyFileName, String propertyName) {
        String propertyValue = null;

        try (InputStream input = new FileInputStream("./src/test/resources/testdata/" + propertyFileName)) {
            Properties prop = new Properties();
            prop.load(input);
            propertyValue = prop.getProperty(propertyName);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return propertyValue;
    }
}
