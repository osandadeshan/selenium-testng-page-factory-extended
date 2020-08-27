package base;

/**
 * Project Name    : selenium-testng-page-factory-demo
 * Developer       : Osanda Deshan
 * Version         : 1.0.0
 * Date            : 8/25/2020
 * Time            : 10:16 PM
 * Description     :
 **/

public class Enums {

    public enum PageTitle {
        LOGIN_PAGE_TITLE("Login - My Store"),
        MY_STORE_PAGE_TITLE("My account - My Store");

        public final String title;

        PageTitle(String title) {
            this.title = title;
        }

        public String asString() {
            return title;
        }
    }

}
