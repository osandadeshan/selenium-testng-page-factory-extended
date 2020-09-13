# Selenium TestNG Page Factory Extended
This is a sample project of more readable implementation with Selenium + Page Factory + TestNG + Java

### Old way
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

