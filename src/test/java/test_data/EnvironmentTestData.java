package test_data;

import static util.PropertyFileReader.getPropertyValueFromEnvironment;

/**
 * Project Name    : selenium-testng-page-factory-extended
 * Developer       : Osanda Deshan
 * Version         : 1.0.0
 * Date            : 10/20/2021
 * Time            : 9:47 AM
 * Description     :
 **/

public class EnvironmentTestData {

    public static final String APPLICATION_URL = getPropertyValueFromEnvironment("application_url");
}
