package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitUtils;

public class ProductDetailsPage {

    private final WebDriver driver;
    private final WaitUtils waitUtils;

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    private final By productName = By.xpath("//h2[contains(text(),'Blue Top')]");
    private final By productCategory = By.xpath("//p[contains(text(),'Category: Women > Tops')]");
    private final By productPrice = By.xpath("//span/span[contains(text(),'Rs. 500')]");
    private final By quantityInput = By.id("quantity");
    private final By addToCartButton = By.xpath("//button[contains(@class,'cart')]");
    private final By availability = By.xpath("//b[contains(text(),'Availability:')]/parent::p[contains(text(),'In Stock')]");
    private final By condition = By.xpath("//b[contains(text(),'Condition:')]/parent::p[contains(text(),'New')]");
    private final By brand = By.xpath("//b[contains(text(),'Brand:')]/parent::p[contains(text(),'Polo')]");

    private final By addedModalTitle = By.xpath("//h4[contains(text(),'Added!')]");
    private final By addedModalMessage = By.xpath("//p[contains(text(),'Your product has been added to cart.')]");
    private final By viewCartButton = By.xpath("//u[contains(text(),'View Cart')]");
    private final By continueShoppingButton = By.xpath("//button[contains(text(),'Continue Shopping')]");

    private final By writeYourReviewTitle = By.xpath("//a[contains(text(),'Write Your Review')]");
    private final By reviewNameInput = By.id("name");
    private final By reviewEmailInput = By.id("email");
    private final By reviewTextArea = By.id("review");
    private final By reviewSubmitButton = By.id("button-review");
    private final By reviewSuccessMessage = By.xpath("//*[contains(text(),'Thank you for your review.')]");

    private final By categoryTitle = By.xpath("//h2[contains(text(),'Category')]");
    private final By womenCategory = By.xpath("//a[@href='#Women']");
    private final By menCategory = By.xpath("//a[@href='#Men']");
    private final By kidsCategory = By.xpath("//a[@href='#Kids']");
    private final By brandsTitle = By.xpath("//h2[contains(text(),'Brands')]");
    private final By brandLinks = By.cssSelector(".brands-name a");

    private final By subscriptionTitle = By.xpath("//h2[contains(text(),'Subscription')]");
    private final By subscriptionEmailInput = By.id("susbscribe_email");
    private final By subscribeButton = By.id("subscribe");
    private final By subscriptionSuccessMessage = By.xpath("//*[contains(text(),'You have been successfully subscribed!')]");

    private final By homeLink = By.xpath("//a[contains(text(),'Home')]");
    private final By productsLink = By.xpath("//a[contains(text(),'Products')]");
    private final By cartLink = By.xpath("//a[contains(text(),'Cart')]");
    private final By signupLoginLink = By.xpath("//a[contains(text(),'Signup / Login')]");
    private final By contactUsLink = By.xpath("//a[contains(text(),'Contact us')]");

    public String getCurrentUrl() { return driver.getCurrentUrl(); }
    public boolean isProductDetailsPageOpened() { return getCurrentUrl().contains("/product_details/1"); }
    public boolean isProductNameVisible() { return waitUtils.isElementVisible(productName); }
    public boolean isProductCategoryVisible() { return waitUtils.isElementVisible(productCategory); }
    public boolean isProductPriceVisible() { return waitUtils.isElementVisible(productPrice); }
    public boolean isAvailabilityVisible() { return waitUtils.isElementVisible(availability); }
    public boolean isConditionVisible() { return waitUtils.isElementVisible(condition); }
    public boolean isBrandVisible() { return waitUtils.isElementVisible(brand); }
    public String getQuantityValue() { return waitUtils.waitForVisibility(quantityInput).getAttribute("value"); }

    public void setQuantity(String quantity) {
        WebElement quantityBox = waitUtils.waitForVisibility(quantityInput);
        quantityBox.clear();
        quantityBox.sendKeys(quantity);
    }

    public void clickAddToCart() {
        WebElement button = waitUtils.waitForClickability(addToCartButton);
        waitUtils.scrollIntoView(button);
        button.click();
    }

    public boolean isAddedModalVisible() { return waitUtils.isElementVisible(addedModalTitle) && waitUtils.isElementVisible(addedModalMessage); }
    public boolean isViewCartButtonVisible() { return waitUtils.isElementVisible(viewCartButton); }
    public boolean isContinueShoppingButtonVisible() { return waitUtils.isElementVisible(continueShoppingButton); }
    public void clickContinueShopping() { waitUtils.waitForClickability(continueShoppingButton).click(); }
    public void clickViewCartFromModal() { waitUtils.waitForClickability(viewCartButton).click(); }

    public boolean isReviewSectionVisible() {
        return waitUtils.isElementVisible(writeYourReviewTitle)
                && waitUtils.isElementVisible(reviewNameInput)
                && waitUtils.isElementVisible(reviewEmailInput)
                && waitUtils.isElementVisible(reviewTextArea)
                && waitUtils.isElementVisible(reviewSubmitButton);
    }

    public void submitReview(String name, String email, String reviewText) {
        WebElement nameInput = waitUtils.waitForVisibility(reviewNameInput);
        waitUtils.scrollIntoView(nameInput);
        nameInput.clear();
        nameInput.sendKeys(name);
        WebElement emailInput = waitUtils.waitForVisibility(reviewEmailInput);
        emailInput.clear();
        emailInput.sendKeys(email);
        WebElement textArea = waitUtils.waitForVisibility(reviewTextArea);
        textArea.clear();
        textArea.sendKeys(reviewText);
        waitUtils.waitForClickability(reviewSubmitButton).click();
    }

    public boolean isReviewSuccessMessageVisible() { return waitUtils.isElementVisible(reviewSuccessMessage); }
    public boolean isCategorySectionVisible() { return waitUtils.isElementVisible(categoryTitle); }
    public boolean areMainCategoriesVisible() { return waitUtils.isElementVisible(womenCategory) && waitUtils.isElementVisible(menCategory) && waitUtils.isElementVisible(kidsCategory); }
    public boolean isBrandsSectionVisible() { return waitUtils.isElementVisible(brandsTitle); }
    public int getBrandCount() { return driver.findElements(brandLinks).size(); }
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
    public void clickSignupLoginLink() { waitUtils.waitForClickability(signupLoginLink).click(); }
    public void clickContactUsLink() { waitUtils.waitForClickability(contactUsLink).click(); }
}
