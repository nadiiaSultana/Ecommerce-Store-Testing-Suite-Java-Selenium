package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginSignupPage;

public class LoginSignupPageTest extends BaseTest {

    private LoginSignupPage loginSignupPage;

    @BeforeMethod
    public void openLoginSignupPage() {
        driver.get("https://automationexercise.com/login");
        loginSignupPage = new LoginSignupPage(driver);
    }

    @Test(priority = 1)
    public void verifyLoginSignupPageLoadsSuccessfully() {
        Assert.assertTrue(loginSignupPage.getCurrentUrl().contains("/login"), "Login/Signup page URL is incorrect.");
        Assert.assertTrue(loginSignupPage.isLoginHeadingVisible(), "Login heading is not visible.");
        Assert.assertTrue(loginSignupPage.isSignupHeadingVisible(), "Signup heading is not visible.");
    }

    @Test(priority = 2)
    public void verifyLoginFormIsVisible() {
        Assert.assertTrue(loginSignupPage.isLoginFormVisible(), "Login form is not fully visible.");
    }

    @Test(priority = 3)
    public void verifySignupFormIsVisible() {
        Assert.assertTrue(loginSignupPage.isSignupFormVisible(), "Signup form is not fully visible.");
    }

    @Test(priority = 4)
    public void verifyInvalidLoginShowsErrorMessage() {
        loginSignupPage.login("wronguser@example.com", "wrongpassword123");
        Assert.assertTrue(loginSignupPage.isIncorrectLoginErrorVisible(), "Incorrect login error message is not visible.");
    }

    @Test(priority = 5)
    public void verifyNewUserSignupNavigatesToAccountInformationPage() {
        String uniqueEmail = "testuser_" + System.currentTimeMillis() + "@example.com";
        loginSignupPage.signup("Test User", uniqueEmail);
        Assert.assertTrue(loginSignupPage.isEnterAccountInformationVisible(), "User did not navigate to Enter Account Information page.");
    }

    @Test(priority = 6)
    public void verifySubscriptionWithValidEmailOnLoginPage() {
        loginSignupPage.subscribeWithEmail("subscriber@example.com");
        Assert.assertTrue(loginSignupPage.isSubscriptionSuccessMessageVisible(), "Subscription success message is not visible.");
    }

    @Test(priority = 7)
    public void verifyProductsNavigationFromLoginPage() {
        loginSignupPage.clickProductsLink();
        Assert.assertTrue(loginSignupPage.getCurrentUrl().contains("/products"), "Products link did not navigate.");
    }
}
