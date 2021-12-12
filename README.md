# Selenium TestNG Page Factory Extended
This is a sample project to demonstrate high readable test automation implementation with Selenium + Page Factory and Fluent Interface Design Patterns + TestNG + Java.

### Old approach using page object/page factory design pattern
- Object usages are high
- Test readability and clarity is less

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

### Extended approach using page object/page factory and fluent interface design patterns
- Object usages are less
- Test readability and clarity is high

```java
@Category(SIGN_IN)
@Test(description = "Verify that an invalid user cannot login to the application")
public void testInvalidUserLogin(){
        fragments().getLoginFragment()
        .login(USER_EMAIL,"123456");
        pages().getLoginPage()
        .checkLoginPageTitle();
        }
```
