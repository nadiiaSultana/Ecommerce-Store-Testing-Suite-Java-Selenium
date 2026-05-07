package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitUtils;

import java.util.List;

public class HomePage {

    private final WebDriver driver;
    private final WaitUtils waitUtils;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    private final By logo = By.cssSelector("img[alt='Website for automation practice']");
    private final By homeLink = By.xpath("//a[contains(text(),'Home')]");
    private final By productsLink = By.xpath("//a[contains(text(),'Products')]");
    private final By cartLink = By.xpath("//a[contains(text(),'Cart')]");
    private final By signupLoginLink = By.xpath("//a[contains(text(),'Signup / Login')]");
    private final By testCasesLink = By.xpath("//a[contains(text(),'Test Cases')]");
    private final By apiTestingLink = By.xpath("//a[contains(text(),'API Testing')]");
    private final By videoTutorialsLink = By.xpath("//a[contains(text(),'Video Tutorials')]");
    private final By contactUsLink = By.xpath("//a[contains(text(),'Contact us')]");

    private final By heroTitle = By.xpath("//h1[contains(text(),'Automation Exercise')]");
    private final By heroSubtitle = By.xpath("//h2[contains(text(),'Full-Fledged practice website for Automation Engineers')]");

    private final By categoryTitle = By.xpath("//h2[contains(text(),'Category')]");
    private final By womenCategory = By.xpath("//a[@href='#Women']");
    private final By menCategory = By.xpath("//a[@href='#Men']");
    private final By kidsCategory = By.xpath("//a[@href='#Kids']");
    private final By womenDressSubcategory = By.xpath("//div[@id='Women']//a[contains(text(),'Dress')]");
    private final By womenTopsSubcategory = By.xpath("//div[@id='Women']//a[contains(text(),'Tops')]");
    private final By womenSareeSubcategory = By.xpath("//div[@id='Women']//a[contains(text(),'Saree')]");

    private final By brandsTitle = By.xpath("//h2[contains(text(),'Brands')]");
    private final By brandLinks = By.cssSelector(".brands-name a");

    private final By featuredItemsTitle = By.xpath("//h2[contains(text(),'Features Items')]");
    private final By productCards = By.cssSelector(".features_items .product-image-wrapper");
    private final By productNames = By.cssSelector(".features_items .productinfo p");
    private final By productPrices = By.cssSelector(".features_items .productinfo h2");
    private final By addToCartButtons = By.cssSelector(".features_items .productinfo a.add-to-cart");
    private final By viewProductLinks = By.xpath("//a[contains(text(),'View Product')]");

    private final By addedModalTitle = By.xpath("//h4[contains(text(),'Added!')]");
    private final By addedModalText = By.xpath("//p[contains(text(),'Your product has been added to cart.')]");
    private final By viewCartButton = By.xpath("//u[contains(text(),'View Cart')]");
    private final By continueShoppingButton = By.xpath("//button[contains(text(),'Continue Shopping')]");

    private final By recommendedItemsTitle = By.xpath("//h2[contains(text(),'recommended items')]");
    private final By recommendedAddToCartButtons = By.cssSelector(".recommended_items a.add-to-cart");

    private final By subscriptionTitle = By.xpath("//h2[contains(text(),'Subscription')]");
    private final By subscriptionEmailInput = By.id("susbscribe_email");
    private final By subscribeButton = By.id("subscribe");
    private final By subscriptionSuccessMessage = By.xpath("//*[contains(text(),'You have been successfully subscribed!')]");

    public String getCurrentUrl() { return driver.getCurrentUrl(); }
    public boolean isLogoVisible() { return waitUtils.isElementVisible(logo); }
    public boolean isHomeLinkVisible() { return waitUtils.isElementVisible(homeLink); }
    public boolean isProductsLinkVisible() { return waitUtils.isElementVisible(productsLink); }
    public boolean isCartLinkVisible() { return waitUtils.isElementVisible(cartLink); }
    public boolean isSignupLoginLinkVisible() { return waitUtils.isElementVisible(signupLoginLink); }
    public boolean isTestCasesLinkVisible() { return waitUtils.isElementVisible(testCasesLink); }
    public boolean isApiTestingLinkVisible() { return waitUtils.isElementVisible(apiTestingLink); }
    public boolean isVideoTutorialsLinkVisible() { return waitUtils.isElementVisible(videoTutorialsLink); }
    public boolean isContactUsLinkVisible() { return waitUtils.isElementVisible(contactUsLink); }
    public boolean isHeroTitleVisible() { return waitUtils.isElementVisible(heroTitle); }
    public boolean isHeroSubtitleVisible() { return waitUtils.isElementVisible(heroSubtitle); }
    public boolean isCategorySectionVisible() { return waitUtils.isElementVisible(categoryTitle); }
    public boolean areMainCategoriesVisible() { return waitUtils.isElementVisible(womenCategory) && waitUtils.isElementVisible(menCategory) && waitUtils.isElementVisible(kidsCategory); }

    public void openWomenCategory() { waitUtils.waitForClickability(womenCategory).click(); }
    public boolean areWomenSubcategoriesVisible() { return waitUtils.isElementVisible(womenDressSubcategory) && waitUtils.isElementVisible(womenTopsSubcategory) && waitUtils.isElementVisible(womenSareeSubcategory); }

    public boolean isBrandSectionVisible() { return waitUtils.isElementVisible(brandsTitle); }
    public int getBrandCount() { return driver.findElements(brandLinks).size(); }

    public boolean isFeaturedItemsSectionVisible() { return waitUtils.isElementVisible(featuredItemsTitle); }
    public int getFeaturedProductCount() { return driver.findElements(productCards).size(); }
    public int getProductNameCount() { return driver.findElements(productNames).size(); }
    public int getProductPriceCount() { return driver.findElements(productPrices).size(); }
    public int getAddToCartButtonCount() { return driver.findElements(addToCartButtons).size(); }
    public int getViewProductLinkCount() { return driver.findElements(viewProductLinks).size(); }
    public boolean isProductDisplayedByName(String productName) { return waitUtils.isElementVisible(By.xpath("//p[contains(text(),'" + productName + "')]")); }

    public void clickFirstAddToCartButton() {
        List<WebElement> buttons = driver.findElements(addToCartButtons);
        WebElement firstButton = buttons.get(0);
        waitUtils.scrollIntoView(firstButton);
        waitUtils.clickUsingJS(firstButton);
    }

    public boolean isAddedModalDisplayed() { return waitUtils.isElementVisible(addedModalTitle) && waitUtils.isElementVisible(addedModalText); }
    public boolean isViewCartButtonVisible() { return waitUtils.isElementVisible(viewCartButton); }
    public boolean isContinueShoppingButtonVisible() { return waitUtils.isElementVisible(continueShoppingButton); }
    public void clickContinueShopping() { waitUtils.waitForClickability(continueShoppingButton).click(); }
    public void clickViewCartFromModal() { waitUtils.waitForClickability(viewCartButton).click(); }

    public boolean isRecommendedItemsSectionVisible() { return waitUtils.isElementVisible(recommendedItemsTitle); }
    public int getRecommendedAddToCartButtonCount() { return driver.findElements(recommendedAddToCartButtons).size(); }

    public boolean isSubscriptionSectionVisible() { return waitUtils.isElementVisible(subscriptionTitle); }
    public void subscribeWithEmail(String email) {
        WebElement emailInput = waitUtils.waitForVisibility(subscriptionEmailInput);
        waitUtils.scrollIntoView(emailInput);
        emailInput.clear();
        emailInput.sendKeys(email);
        waitUtils.waitForClickability(subscribeButton).click();
    }
    public boolean isSubscriptionSuccessMessageVisible() { return waitUtils.isElementVisible(subscriptionSuccessMessage); }

    public void clickProductsLink() { waitUtils.waitForClickability(productsLink).click(); }
    public void clickCartLink() { waitUtils.waitForClickability(cartLink).click(); }
    public void clickSignupLoginLink() { waitUtils.waitForClickability(signupLoginLink).click(); }
    public void clickContactUsLink() { waitUtils.waitForClickability(contactUsLink).click(); }
    public void clickTestCasesLink() { waitUtils.waitForClickability(testCasesLink).click(); }
    public void clickApiTestingLink() { waitUtils.waitForClickability(apiTestingLink).click(); }
}
