# Selenium TestNG Page Factory Extended
This is a sample project to demonstrate high readable test automation implementation with Selenium + Page Factory and Fluent Interface Design Patterns + TestNG + Java.

### Old approach using page object/page factory design pattern
- Object usages are high
- Test readability and clarity is less

```java
@Test
public void verifyValidUserLogin() {
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
@Test
public void verifyValidUserLogin() {
    loginFragment
        .login("osanda@mailinator.com", "1qaz2wsx@")
        .checkHomePageTitle()
        .checkLoggedInUsername("Osanda Nimalarathna")
        .logout();
}
```
