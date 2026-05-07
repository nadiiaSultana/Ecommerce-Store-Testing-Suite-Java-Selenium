package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitUtils;

public class CartPage {

    private final WebDriver driver;
    private final WaitUtils waitUtils;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    private final By cartBreadcrumb = By.xpath("//li[contains(text(),'Shopping Cart')]");
    private final By cartTable = By.id("cart_info_table");
    private final By cartRows = By.cssSelector("#cart_info_table tbody tr");
    private final By productImages = By.cssSelector(".cart_product img");
    private final By productDescriptions = By.cssSelector(".cart_description h4 a");
    private final By productCategories = By.cssSelector(".cart_description p");
    private final By productPrices = By.cssSelector(".cart_price p");
    private final By productQuantities = By.cssSelector(".cart_quantity button");
    private final By productTotals = By.cssSelector(".cart_total p");
    private final By deleteButtons = By.cssSelector(".cart_delete a");

    private final By blueTopCartProduct = By.xpath("//td[@class='cart_description']//a[contains(text(),'Blue Top')]");
    private final By menTshirtCartProduct = By.xpath("//td[@class='cart_description']//a[contains(text(),'Men Tshirt')]");
    private final By sleevelessDressCartProduct = By.xpath("//td[@class='cart_description']//a[contains(text(),'Sleeveless Dress')]");

    private final By proceedToCheckoutButton = By.xpath("//a[contains(text(),'Proceed To Checkout')]");
    private final By registerLoginModalLink = By.xpath("//u[contains(text(),'Register / Login')]");
    private final By continueOnCartButton = By.xpath("//button[contains(text(),'Continue On Cart')]");
    private final By emptyCartMessage = By.xpath("//*[contains(text(),'Cart is empty!')]");
    private final By hereLink = By.xpath("//a[contains(text(),'here')]");

    private final By subscriptionTitle = By.xpath("//h2[contains(text(),'Subscription')]");
    private final By subscriptionEmailInput = By.id("susbscribe_email");
    private final By subscribeButton = By.id("subscribe");
    private final By subscriptionSuccessMessage = By.xpath("//*[contains(text(),'You have been successfully subscribed!')]");

    private final By homeLink = By.xpath("//a[contains(text(),'Home')]");
    private final By productsLink = By.xpath("//a[contains(text(),'Products')]");
    private final By signupLoginLink = By.xpath("//a[contains(text(),'Signup / Login')]");
    private final By contactUsLink = By.xpath("//a[contains(text(),'Contact us')]");

    public String getCurrentUrl() { return driver.getCurrentUrl(); }
    public boolean isCartPageOpened() { return getCurrentUrl().contains("/view_cart"); }
    public boolean isCartBreadcrumbVisible() { return waitUtils.isElementVisible(cartBreadcrumb); }
    public boolean isCartTableVisible() { return waitUtils.isElementVisible(cartTable); }
    public int getCartRowCount() { return driver.findElements(cartRows).size(); }
    public boolean isCartNotEmpty() { return getCartRowCount() > 0; }
    public int getProductImageCount() { return driver.findElements(productImages).size(); }
    public int getProductDescriptionCount() { return driver.findElements(productDescriptions).size(); }
    public int getProductCategoryCount() { return driver.findElements(productCategories).size(); }
    public int getProductPriceCount() { return driver.findElements(productPrices).size(); }
    public int getProductQuantityCount() { return driver.findElements(productQuantities).size(); }
    public int getProductTotalCount() { return driver.findElements(productTotals).size(); }
    public int getDeleteButtonCount() { return driver.findElements(deleteButtons).size(); }
    public boolean isProductVisibleInCart(String productName) { return waitUtils.isElementVisible(By.xpath("//td[@class='cart_description']//a[contains(text(),'" + productName + "')]")); }
    public boolean isBlueTopVisibleInCart() { return waitUtils.isElementVisible(blueTopCartProduct); }
    public boolean isMenTshirtVisibleInCart() { return waitUtils.isElementVisible(menTshirtCartProduct); }
    public boolean isSleevelessDressVisibleInCart() { return waitUtils.isElementVisible(sleevelessDressCartProduct); }

    public String getProductPriceByName(String productName) {
        By locator = By.xpath("//td[@class='cart_description']//a[contains(text(),'" + productName + "')]/ancestor::tr//td[@class='cart_price']/p");
        return waitUtils.waitForVisibility(locator).getText();
    }

    public String getProductQuantityByName(String productName) {
        By locator = By.xpath("//td[@class='cart_description']//a[contains(text(),'" + productName + "')]/ancestor::tr//td[@class='cart_quantity']/button");
        return waitUtils.waitForVisibility(locator).getText();
    }

    public String getProductTotalByName(String productName) {
        By locator = By.xpath("//td[@class='cart_description']//a[contains(text(),'" + productName + "')]/ancestor::tr//td[@class='cart_total']/p");
        return waitUtils.waitForVisibility(locator).getText();
    }

    public int extractAmount(String priceText) { return Integer.parseInt(priceText.replace("Rs.", "").trim()); }
    public int extractQuantity(String quantityText) { return Integer.parseInt(quantityText.trim()); }

    public boolean isTotalCorrectForProduct(String productName) {
        int price = extractAmount(getProductPriceByName(productName));
        int quantity = extractQuantity(getProductQuantityByName(productName));
        int total = extractAmount(getProductTotalByName(productName));
        return total == price * quantity;
    }

    public boolean areCartColumnsVisibleForAllProducts() {
        int rowCount = getCartRowCount();
        return getProductImageCount() == rowCount
                && getProductDescriptionCount() == rowCount
                && getProductPriceCount() == rowCount
                && getProductQuantityCount() == rowCount
                && getProductTotalCount() == rowCount
                && getDeleteButtonCount() == rowCount;
    }

    public void removeProductFromCart(String productName) {
        By deleteButton = By.xpath("//td[@class='cart_description']//a[contains(text(),'" + productName + "')]/ancestor::tr//td[@class='cart_delete']/a");
        waitUtils.waitForClickability(deleteButton).click();
    }

    public boolean waitUntilProductRemoved(String productName) {
        By product = By.xpath("//td[@class='cart_description']//a[contains(text(),'" + productName + "')]");
        return waitUtils.waitUntilInvisible(product);
    }

    public boolean isProceedToCheckoutButtonVisible() { return waitUtils.isElementVisible(proceedToCheckoutButton); }
    public void clickProceedToCheckout() { waitUtils.waitForClickability(proceedToCheckoutButton).click(); }
    public boolean isRegisterLoginLinkVisibleInCheckoutModal() { return waitUtils.isElementVisible(registerLoginModalLink); }
    public boolean isContinueOnCartButtonVisible() { return waitUtils.isElementVisible(continueOnCartButton); }
    public void clickContinueOnCart() { waitUtils.waitForClickability(continueOnCartButton).click(); }
    public boolean isEmptyCartMessageVisible() { return waitUtils.isElementVisible(emptyCartMessage); }
    public boolean isHereLinkVisible() { return waitUtils.isElementVisible(hereLink); }
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
    public void clickSignupLoginLink() { waitUtils.waitForClickability(signupLoginLink).click(); }
    public void clickContactUsLink() { waitUtils.waitForClickability(contactUsLink).click(); }
}
