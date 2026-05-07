package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitUtils;

import java.util.List;

public class ProductsPage {

    private final WebDriver driver;
    private final WaitUtils waitUtils;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    private final By allProductsHeading = By.xpath("//h2[contains(text(),'All Products')]");
    private final By searchedProductsHeading = By.xpath("//h2[contains(text(),'Searched Products')]");
    private final By categoryHeading = By.xpath("//h2[contains(text(),'Category')]");
    private final By brandsHeading = By.xpath("//h2[contains(text(),'Brands')]");

    private final By searchInput = By.id("search_product");
    private final By searchButton = By.id("submit_search");

    private final By productCards = By.cssSelector(".features_items .product-image-wrapper");
    private final By productNames = By.cssSelector(".features_items .productinfo p");
    private final By productPrices = By.cssSelector(".features_items .productinfo h2");
    private final By addToCartButtons = By.cssSelector(".features_items .productinfo a.add-to-cart");
    private final By viewProductLinks = By.xpath("//a[contains(text(),'View Product')]");

    private final By addedModalTitle = By.xpath("//h4[contains(text(),'Added!')]");
    private final By addedModalText = By.xpath("//p[contains(text(),'Your product has been added to cart.')]");
    private final By viewCartButton = By.xpath("//u[contains(text(),'View Cart')]");
    private final By continueShoppingButton = By.xpath("//button[contains(text(),'Continue Shopping')]");

    private final By womenCategoryHeader = By.xpath("//a[@href='#Women']");
    private final By menCategoryHeader = By.xpath("//a[@href='#Men']");
    private final By kidsCategoryHeader = By.xpath("//a[@href='#Kids']");
    private final By womenPlusIcon = By.xpath("//a[@href='#Women']//i[contains(@class,'fa-plus')]");
    private final By menPlusIcon = By.xpath("//a[@href='#Men']//i[contains(@class,'fa-plus')]");
    private final By kidsPlusIcon = By.xpath("//a[@href='#Kids']//i[contains(@class,'fa-plus')]");

    private final By womenDressOption = By.xpath("//div[@id='Women']//a[contains(text(),'Dress')]");
    private final By womenTopsOption = By.xpath("//div[@id='Women']//a[contains(text(),'Tops')]");
    private final By womenSareeOption = By.xpath("//div[@id='Women']//a[contains(text(),'Saree')]");
    private final By menTshirtsOption = By.xpath("//div[@id='Men']//a[contains(text(),'Tshirts')]");
    private final By menJeansOption = By.xpath("//div[@id='Men']//a[contains(text(),'Jeans')]");
    private final By kidsDressOption = By.xpath("//div[@id='Kids']//a[contains(text(),'Dress')]");
    private final By kidsTopsShirtsOption = By.xpath("//div[@id='Kids']//a[contains(text(),'Tops & Shirts')]");
    private final By categoryProductsHeading = By.xpath("//h2[contains(@class,'title') and contains(text(),'Products')]");

    private final By brandLinks = By.cssSelector(".brands-name a");
    private final By poloBrand = By.xpath("//a[contains(text(),'Polo')]");
    private final By hmBrand = By.xpath("//a[contains(text(),'H&M')]");
    private final By madameBrand = By.xpath("//a[contains(text(),'Madame')]");
    private final By mastHarbourBrand = By.xpath("//a[contains(text(),'Mast & Harbour')]");
    private final By babyhugBrand = By.xpath("//a[contains(text(),'Babyhug')]");
    private final By allenSollyJuniorBrand = By.xpath("//a[contains(text(),'Allen Solly Junior')]");
    private final By kookieKidsBrand = By.xpath("//a[contains(text(),'Kookie Kids')]");
    private final By bibaBrand = By.xpath("//a[contains(text(),'Biba')]");
    private final By brandProductsHeading = By.xpath("//h2[contains(@class,'title') and contains(text(),'Brand')]");

    private final By subscriptionTitle = By.xpath("//h2[contains(text(),'Subscription')]");
    private final By subscriptionEmailInput = By.id("susbscribe_email");
    private final By subscribeButton = By.id("subscribe");
    private final By subscriptionSuccessMessage = By.xpath("//*[contains(text(),'You have been successfully subscribed!')]");

    private final By homeLink = By.xpath("//a[contains(text(),'Home')]");
    private final By cartLink = By.xpath("//a[contains(text(),'Cart')]");
    private final By signupLoginLink = By.xpath("//a[contains(text(),'Signup / Login')]");
    private final By contactUsLink = By.xpath("//a[contains(text(),'Contact us')]");

    public String getCurrentUrl() { return driver.getCurrentUrl(); }
    public boolean isAllProductsHeadingVisible() { return waitUtils.isElementVisible(allProductsHeading); }
    public boolean isSearchBoxVisible() { return waitUtils.isElementVisible(searchInput) && waitUtils.isElementVisible(searchButton); }
    public boolean isCategorySectionVisible() { return waitUtils.isElementVisible(categoryHeading); }
    public boolean isBrandsSectionVisible() { return waitUtils.isElementVisible(brandsHeading); }
    public int getProductCardCount() { return driver.findElements(productCards).size(); }
    public int getProductNameCount() { return driver.findElements(productNames).size(); }
    public int getProductPriceCount() { return driver.findElements(productPrices).size(); }
    public int getAddToCartButtonCount() { return driver.findElements(addToCartButtons).size(); }
    public int getViewProductLinkCount() { return driver.findElements(viewProductLinks).size(); }
    public boolean isProductVisibleByName(String productName) { return waitUtils.isElementVisible(By.xpath("//p[contains(text(),'" + productName + "')]")); }

    public void searchProduct(String keyword) {
        WebElement input = waitUtils.waitForVisibility(searchInput);
        input.clear();
        input.sendKeys(keyword);
        waitUtils.waitForClickability(searchButton).click();
    }

    public boolean isSearchedProductsHeadingVisible() { return waitUtils.isElementVisible(searchedProductsHeading); }

    public boolean doAllVisibleProductsContainKeyword(String keyword) {
        List<WebElement> names = driver.findElements(productNames);
        for (WebElement name : names) {
            if (!name.getText().toLowerCase().contains(keyword.toLowerCase())) {
                return false;
            }
        }
        return !names.isEmpty();
    }

    public void clickFirstViewProduct() {
        WebElement firstLink = driver.findElements(viewProductLinks).get(0);
        waitUtils.scrollIntoView(firstLink);
        waitUtils.clickUsingJS(firstLink);
    }

    public void clickFirstAddToCartButton() {
        WebElement firstButton = driver.findElements(addToCartButtons).get(0);
        waitUtils.scrollIntoView(firstButton);
        waitUtils.clickUsingJS(firstButton);
    }

    public boolean isAddedModalVisible() { return waitUtils.isElementVisible(addedModalTitle) && waitUtils.isElementVisible(addedModalText); }
    public boolean isViewCartButtonVisible() { return waitUtils.isElementVisible(viewCartButton); }
    public boolean isContinueShoppingButtonVisible() { return waitUtils.isElementVisible(continueShoppingButton); }
    public void clickContinueShopping() { waitUtils.waitForClickability(continueShoppingButton).click(); }
    public void clickViewCartFromModal() { waitUtils.waitForClickability(viewCartButton).click(); }

    public boolean isCategorySidebarTitleVisible() { return waitUtils.isElementVisible(categoryHeading); }
    public boolean areCategoryHeadersVisible() { return waitUtils.isElementVisible(womenCategoryHeader) && waitUtils.isElementVisible(menCategoryHeader) && waitUtils.isElementVisible(kidsCategoryHeader); }
    public boolean areCategoryPlusIconsVisible() { return waitUtils.isElementVisible(womenPlusIcon) && waitUtils.isElementVisible(menPlusIcon) && waitUtils.isElementVisible(kidsPlusIcon); }
    public void expandWomenCategory() { waitUtils.waitForClickability(womenCategoryHeader).click(); }
    public void expandMenCategory() { waitUtils.waitForClickability(menCategoryHeader).click(); }
    public void expandKidsCategory() { waitUtils.waitForClickability(kidsCategoryHeader).click(); }
    public boolean areWomenSubcategoriesVisible() { return waitUtils.isElementVisible(womenDressOption) && waitUtils.isElementVisible(womenTopsOption) && waitUtils.isElementVisible(womenSareeOption); }
    public boolean areMenSubcategoriesVisible() { return waitUtils.isElementVisible(menTshirtsOption) && waitUtils.isElementVisible(menJeansOption); }
    public boolean areKidsSubcategoriesVisible() { return waitUtils.isElementVisible(kidsDressOption) && waitUtils.isElementVisible(kidsTopsShirtsOption); }

    public void clickWomenDressCategory() { expandWomenCategory(); waitUtils.waitForClickability(womenDressOption).click(); }
    public void clickWomenTopsCategory() { expandWomenCategory(); waitUtils.waitForClickability(womenTopsOption).click(); }
    public void clickWomenSareeCategory() { expandWomenCategory(); waitUtils.waitForClickability(womenSareeOption).click(); }
    public void clickMenTshirtsCategory() { expandMenCategory(); waitUtils.waitForClickability(menTshirtsOption).click(); }
    public void clickMenJeansCategory() { expandMenCategory(); waitUtils.waitForClickability(menJeansOption).click(); }
    public void clickKidsDressCategory() { expandKidsCategory(); waitUtils.waitForClickability(kidsDressOption).click(); }
    public void clickKidsTopsShirtsCategory() { expandKidsCategory(); waitUtils.waitForClickability(kidsTopsShirtsOption).click(); }
    public boolean isCategoryProductsHeadingVisible() { return waitUtils.isElementVisible(categoryProductsHeading); }

    public boolean isBrandsSidebarTitleVisible() { return waitUtils.isElementVisible(brandsHeading); }
    public int getTotalBrandCount() { return driver.findElements(brandLinks).size(); }
    public int getBrandCount() { return getTotalBrandCount(); }
    public boolean areAllExpectedBrandsVisible() { return waitUtils.isElementVisible(poloBrand) && waitUtils.isElementVisible(hmBrand) && waitUtils.isElementVisible(madameBrand) && waitUtils.isElementVisible(mastHarbourBrand) && waitUtils.isElementVisible(babyhugBrand) && waitUtils.isElementVisible(allenSollyJuniorBrand) && waitUtils.isElementVisible(kookieKidsBrand) && waitUtils.isElementVisible(bibaBrand); }
    public String getPoloBrandText() { return waitUtils.waitForVisibility(poloBrand).getText(); }
    public String getHMBrandText() { return waitUtils.waitForVisibility(hmBrand).getText(); }
    public String getMadameBrandText() { return waitUtils.waitForVisibility(madameBrand).getText(); }
    public String getMastHarbourBrandText() { return waitUtils.waitForVisibility(mastHarbourBrand).getText(); }
    public String getBabyhugBrandText() { return waitUtils.waitForVisibility(babyhugBrand).getText(); }
    public String getAllenSollyJuniorBrandText() { return waitUtils.waitForVisibility(allenSollyJuniorBrand).getText(); }
    public String getKookieKidsBrandText() { return waitUtils.waitForVisibility(kookieKidsBrand).getText(); }
    public String getBibaBrandText() { return waitUtils.waitForVisibility(bibaBrand).getText(); }
    public void clickPoloBrandFilter() { waitUtils.waitForClickability(poloBrand).click(); }
    public void clickHMBrandFilter() { waitUtils.waitForClickability(hmBrand).click(); }
    public void clickMadameBrandFilter() { waitUtils.waitForClickability(madameBrand).click(); }
    public void clickMastHarbourBrandFilter() { waitUtils.waitForClickability(mastHarbourBrand).click(); }
    public void clickBabyhugBrandFilter() { waitUtils.waitForClickability(babyhugBrand).click(); }
    public void clickAllenSollyJuniorBrandFilter() { waitUtils.waitForClickability(allenSollyJuniorBrand).click(); }
    public void clickKookieKidsBrandFilter() { waitUtils.waitForClickability(kookieKidsBrand).click(); }
    public void clickBibaBrandFilter() { waitUtils.waitForClickability(bibaBrand).click(); }
    public void clickPoloBrand() { clickPoloBrandFilter(); }
    public void clickHMBrand() { clickHMBrandFilter(); }
    public void clickMadameBrand() { clickMadameBrandFilter(); }
    public boolean isBrandProductsHeadingVisible() { return waitUtils.isElementVisible(brandProductsHeading); }

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
    public void clickCartLink() { waitUtils.waitForClickability(cartLink).click(); }
    public void clickSignupLoginLink() { waitUtils.waitForClickability(signupLoginLink).click(); }
    public void clickContactUsLink() { waitUtils.waitForClickability(contactUsLink).click(); }
}
