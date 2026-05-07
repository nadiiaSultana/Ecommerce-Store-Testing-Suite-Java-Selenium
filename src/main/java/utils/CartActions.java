package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartActions {

    private final WebDriver driver;
    private final WaitUtils waitUtils;

    public CartActions(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    private final By continueShoppingButton = By.xpath("//button[contains(text(),'Continue Shopping')]");
    private final By viewCartButton = By.xpath("//u[contains(text(),'View Cart')]");

    public void addBlueTopFromHomePage() {
        driver.get("https://automationexercise.com/");
        addProductByName("Blue Top");
    }

    public void addMenTshirtFromProductsPage() {
        driver.get("https://automationexercise.com/products");
        addProductByName("Men Tshirt");
    }

    public void addSleevelessDressFromProductsPage() {
        driver.get("https://automationexercise.com/products");
        addProductByName("Sleeveless Dress");
    }

    private void addProductByName(String productName) {
        By addToCartButton = By.xpath(
                "//p[contains(text(),'" + productName + "')]/ancestor::div[contains(@class,'productinfo')]//a[contains(@class,'add-to-cart')]"
        );
        WebElement button = waitUtils.waitForClickability(addToCartButton);
        waitUtils.scrollIntoView(button);
        waitUtils.clickUsingJS(button);
        waitUtils.waitForClickability(continueShoppingButton).click();
    }

    public void addBlueTopFromProductDetailsPageAndGoToCart(String quantity) {
        driver.get("https://automationexercise.com/product_details/1");
        By quantityInput = By.id("quantity");
        By addToCartButton = By.xpath("//button[contains(@class,'cart')]");
        WebElement quantityBox = waitUtils.waitForVisibility(quantityInput);
        quantityBox.clear();
        quantityBox.sendKeys(quantity);
        WebElement button = waitUtils.waitForClickability(addToCartButton);
        waitUtils.scrollIntoView(button);
        button.click();
        waitUtils.waitForClickability(viewCartButton).click();
    }

    public void goToCartPage() {
        driver.get("https://automationexercise.com/view_cart");
    }
}
