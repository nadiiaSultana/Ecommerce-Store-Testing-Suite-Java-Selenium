package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTest extends BaseTest {

    @Test(priority = 1)
    public void verifyHomePageLoadsSuccessfully() {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.getCurrentUrl().contains("automationexercise.com"), "Home page URL is incorrect.");
        Assert.assertTrue(homePage.isLogoVisible(), "Website logo is not visible on landing page.");
        Assert.assertTrue(homePage.isHeroTitleVisible(), "Hero title is not visible.");
        Assert.assertTrue(homePage.isHeroSubtitleVisible(), "Hero subtitle is not visible.");
    }

    @Test(priority = 2)
    public void verifyNavbarLinksAreVisible() {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isHomeLinkVisible(), "Home link is not visible.");
        Assert.assertTrue(homePage.isProductsLinkVisible(), "Products link is not visible.");
        Assert.assertTrue(homePage.isCartLinkVisible(), "Cart link is not visible.");
        Assert.assertTrue(homePage.isSignupLoginLinkVisible(), "Signup/Login link is not visible.");
        Assert.assertTrue(homePage.isTestCasesLinkVisible(), "Test Cases link is not visible.");
        Assert.assertTrue(homePage.isApiTestingLinkVisible(), "API Testing link is not visible.");
        Assert.assertTrue(homePage.isVideoTutorialsLinkVisible(), "Video Tutorials link is not visible.");
        Assert.assertTrue(homePage.isContactUsLinkVisible(), "Contact Us link is not visible.");
    }

    @Test(priority = 3)
    public void verifyCategorySectionIsVisible() {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isCategorySectionVisible(), "Category section is not visible.");
        Assert.assertTrue(homePage.areMainCategoriesVisible(), "Main categories are not visible.");
    }

    @Test(priority = 4)
    public void verifyWomenCategoryExpandsAndShowsSubcategories() {
        HomePage homePage = new HomePage(driver);
        homePage.openWomenCategory();
        Assert.assertTrue(homePage.areWomenSubcategoriesVisible(), "Women category subcategories are not visible.");
    }

    @Test(priority = 5)
    public void verifyBrandSectionIsVisible() {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isBrandSectionVisible(), "Brand section is not visible.");
        Assert.assertTrue(homePage.getBrandCount() >= 8, "Expected at least 8 brands.");
    }

    @Test(priority = 6)
    public void verifyFeaturedItemsSectionIsVisible() {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isFeaturedItemsSectionVisible(), "Featured Items section is not visible.");
        Assert.assertTrue(homePage.getFeaturedProductCount() > 0, "No featured product cards are visible.");
    }

    @Test(priority = 7)
    public void verifyFeaturedProductsHaveNamePriceAndActions() {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.getProductNameCount() > 0, "Product names are not visible.");
        Assert.assertTrue(homePage.getProductPriceCount() > 0, "Product prices are not visible.");
        Assert.assertTrue(homePage.getAddToCartButtonCount() > 0, "Add to cart buttons are not visible.");
        Assert.assertTrue(homePage.getViewProductLinkCount() > 0, "View Product links are not visible.");
    }

    @Test(priority = 8)
    public void verifySpecificFeaturedProductsAreDisplayed() {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isProductDisplayedByName("Blue Top"), "Blue Top product is not displayed.");
        Assert.assertTrue(homePage.isProductDisplayedByName("Men Tshirt"), "Men Tshirt product is not displayed.");
        Assert.assertTrue(homePage.isProductDisplayedByName("Sleeveless Dress"), "Sleeveless Dress product is not displayed.");
    }

    @Test(priority = 9)
    public void verifyAddToCartModalAppearsForFeaturedProduct() {
        HomePage homePage = new HomePage(driver);
        homePage.clickFirstAddToCartButton();
        Assert.assertTrue(homePage.isAddedModalDisplayed(), "Add to cart confirmation modal is not displayed.");
        Assert.assertTrue(homePage.isViewCartButtonVisible(), "View Cart button is not visible in modal.");
        Assert.assertTrue(homePage.isContinueShoppingButtonVisible(), "Continue Shopping button is not visible in modal.");
    }

    @Test(priority = 10)
    public void verifyViewCartButtonFromAddToCartModalNavigatesToCartPage() {
        HomePage homePage = new HomePage(driver);
        homePage.clickFirstAddToCartButton();
        homePage.clickViewCartFromModal();
        Assert.assertTrue(homePage.getCurrentUrl().contains("/view_cart"), "View Cart button did not navigate to cart page.");
    }

    @Test(priority = 11)
    public void verifyRecommendedItemsSectionIsVisible() {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isRecommendedItemsSectionVisible(), "Recommended Items section is not visible.");
        Assert.assertTrue(homePage.getRecommendedAddToCartButtonCount() > 0, "Recommended Add to Cart buttons are not visible.");
    }

    @Test(priority = 12)
    public void verifySubscriptionWithValidEmail() {
        HomePage homePage = new HomePage(driver);
        homePage.subscribeWithEmail("testuser@example.com");
        Assert.assertTrue(homePage.isSubscriptionSuccessMessageVisible(), "Subscription success message is not visible.");
    }

    @Test(priority = 13)
    public void verifyNavbarNavigation() {
        HomePage homePage = new HomePage(driver);
        homePage.clickProductsLink();
        Assert.assertTrue(homePage.getCurrentUrl().contains("/products"), "Products link did not navigate.");
    }
}
