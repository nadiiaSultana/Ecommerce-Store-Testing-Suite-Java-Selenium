# Automation Exercise Selenium Test Suite

Java + Selenium + TestNG + Maven automation framework for https://automationexercise.com/

## Requirements

- Java 17+
- Maven
- Google Chrome
- IntelliJ IDEA / Eclipse / VS Code

## How to run

```bash
mvn clean test
```

Run a specific suite by editing `testng.xml` or running a specific test class from the IDE.

## Project structure

```text
src/main/java/pages       Page Object classes
src/main/java/utils       Wait and reusable cart action utilities
src/test/java/base        Base Selenium setup
src/test/java/tests       TestNG test classes
```

## Covered pages

- Landing/Home page
- Login/Signup page
- Products page
- Products sidebar: Category and Brands
- Product details page
- Cart page with products added from multiple pages

## Notes

- Tests are independent because a fresh browser session is created for each test.
- Cart tests add products inside the same test before asserting cart behavior.
- Some add-to-cart clicks use JavaScript click to avoid hover/click interception issues on product cards.
