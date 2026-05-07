package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitUtils;

public class LoginSignupPage {

    private final WebDriver driver;
    private final WaitUtils waitUtils;

    public LoginSignupPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    private final By loginHeading = By.xpath("//h2[contains(text(),'Login to your account')]");
    private final By signupHeading = By.xpath("//h2[contains(text(),'New User Signup!')]");
    private final By loginEmailInput = By.cssSelector("input[data-qa='login-email']");
    private final By loginPasswordInput = By.cssSelector("input[data-qa='login-password']");
    private final By loginButton = By.cssSelector("button[data-qa='login-button']");
    private final By incorrectLoginError = By.xpath("//p[contains(text(),'Your email or password is incorrect!')]");
    private final By signupNameInput = By.cssSelector("input[data-qa='signup-name']");
    private final By signupEmailInput = By.cssSelector("input[data-qa='signup-email']");
    private final By signupButton = By.cssSelector("button[data-qa='signup-button']");
    private final By existingEmailError = By.xpath("//p[contains(text(),'Email Address already exist!')]");
    private final By enterAccountInfoHeading = By.xpath("//b[contains(text(),'Enter Account Information')]");
    private final By homeLink = By.xpath("//a[contains(text(),'Home')]");
    private final By productsLink = By.xpath("//a[contains(text(),'Products')]");
    private final By cartLink = By.xpath("//a[contains(text(),'Cart')]");
    private final By contactUsLink = By.xpath("//a[contains(text(),'Contact us')]");
    private final By subscriptionTitle = By.xpath("//h2[contains(text(),'Subscription')]");
    private final By subscriptionEmailInput = By.id("susbscribe_email");
    private final By subscribeButton = By.id("subscribe");
    private final By subscriptionSuccessMessage = By.xpath("//*[contains(text(),'You have been successfully subscribed!')]");

    public String getCurrentUrl() { return driver.getCurrentUrl(); }
    public boolean isLoginHeadingVisible() { return waitUtils.isElementVisible(loginHeading); }
    public boolean isSignupHeadingVisible() { return waitUtils.isElementVisible(signupHeading); }
    public boolean isLoginFormVisible() { return waitUtils.isElementVisible(loginEmailInput) && waitUtils.isElementVisible(loginPasswordInput) && waitUtils.isElementVisible(loginButton); }
    public boolean isSignupFormVisible() { return waitUtils.isElementVisible(signupNameInput) && waitUtils.isElementVisible(signupEmailInput) && waitUtils.isElementVisible(signupButton); }

    public void login(String email, String password) {
        WebElement emailInput = waitUtils.waitForVisibility(loginEmailInput);
        emailInput.clear();
        emailInput.sendKeys(email);
        WebElement passwordInput = waitUtils.waitForVisibility(loginPasswordInput);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        waitUtils.waitForClickability(loginButton).click();
    }

    public boolean isIncorrectLoginErrorVisible() { return waitUtils.isElementVisible(incorrectLoginError); }

    public void signup(String name, String email) {
        WebElement nameInput = waitUtils.waitForVisibility(signupNameInput);
        nameInput.clear();
        nameInput.sendKeys(name);
        WebElement emailInput = waitUtils.waitForVisibility(signupEmailInput);
        emailInput.clear();
        emailInput.sendKeys(email);
        waitUtils.waitForClickability(signupButton).click();
    }

    public boolean isEnterAccountInformationVisible() { return waitUtils.isElementVisible(enterAccountInfoHeading); }
    public boolean isExistingEmailErrorVisible() { return waitUtils.isElementVisible(existingEmailError); }
    public boolean isSubscriptionSectionVisible() { return waitUtils.isElementVisible(subscriptionTitle); }

    public void subscribeWithEmail(String email) {
        WebElement emailInput = waitUtils.waitForVisibility(subscriptionEmailInput);
        waitUtils.scrollIntoView(emailInput);
        emailInput.clear();
        emailInput.sendKeys(email);
        waitUtils.waitForClickability(subscribeButton).click();
    }

    public boolean isSubscriptionSuccessMessageVisible() { return waitUtils.isElementVisible(subscriptionSuccessMessage); }
    public void clickHomeLink() { waitUtils.waitForClickability(homeLink).click(); }
    public void clickProductsLink() { waitUtils.waitForClickability(productsLink).click(); }
    public void clickCartLink() { waitUtils.waitForClickability(cartLink).click(); }
    public void clickContactUsLink() { waitUtils.waitForClickability(contactUsLink).click(); }
}
