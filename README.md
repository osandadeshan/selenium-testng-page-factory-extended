# Selenium TestNG Page Factory Extended
This is a sample project to demonstrate high readable test automation implementation with Selenium + Page Factory and Fluent Interface Design Patterns + TestNG + Java.

### Old approach using page object/page factory design pattern
- Object usages are high
- Test readability and clarity is less

```java
@Category(SIGN_IN)
@Test(description = "Verify that a valid user can login to the application")
public void testValidUserLogin(){
    loginpage.setEmail("osanda@mailinator.com");
    loginpage.setPassword("1qaz2wsx@");
    loginpage.clickOnSignInButton();
    Assert.assertEquals(commonPage.getBrowserTabTitle(), "My account - My Store");
    Assert.assertEquals(homepage.getLoggedInUsername(), "Osanda Nimalarathna");
}
```

### Extended approach using page object/page factory and fluent interface design patterns
- Object usages are less
- Test readability and clarity is high

```java
@Category(SIGN_IN)
@Test(description = "Verify that a valid user can login to the application")
public void testValidUserLogin(){
    fragments().getLoginFragment()
        .login(USER_EMAIL,USER_PASSWORD)
        .checkHomePageTitle()
        .getNavigationBlock()
        .checkLoggedInUsername(FULL_USER_NAME);
}
```
