package test_data;

import static util.PropertyFileReader.getPropertyValueFromLoginCredentials;

/**
 * Project Name    : selenium-testng-page-factory-extended
 * Developer       : Osanda Deshan
 * Version         : 1.0.0
 * Date            : 10/19/2021
 * Time            : 10:16 PM
 * Description     :
 **/

public class LoginTestData {

    public static final String USER_EMAIL = getPropertyValueFromLoginCredentials("email");
    public static final String USER_PASSWORD = getPropertyValueFromLoginCredentials("password");
    public static final String FULL_USER_NAME = getPropertyValueFromLoginCredentials("full_user_name");
}
