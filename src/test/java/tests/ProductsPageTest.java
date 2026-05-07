package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ProductsPage;

public class ProductsPageTest extends BaseTest {

    private ProductsPage productsPage;

    @BeforeMethod
    public void openProductsPage() {
        driver.get("https://automationexercise.com/products");
        productsPage = new ProductsPage(driver);
    }

    @Test(priority = 1)
    public void verifyProductsPageLoadsSuccessfully() {
        Assert.assertTrue(productsPage.getCurrentUrl().contains("/products"), "Products page URL is incorrect.");
        Assert.assertTrue(productsPage.isAllProductsHeadingVisible(), "All Products heading is not visible.");
    }

    @Test(priority = 2)
    public void verifySearchBoxIsVisible() {
        Assert.assertTrue(productsPage.isSearchBoxVisible(), "Product search box or button is not visible.");
    }

    @Test(priority = 3)
    public void verifyCategoryAndBrandsSectionsAreVisible() {
        Assert.assertTrue(productsPage.isCategorySectionVisible(), "Category section is not visible.");
        Assert.assertTrue(productsPage.isBrandsSectionVisible(), "Brands section is not visible.");
    }

    @Test(priority = 4)
    public void verifyProductCardsAreVisible() {
        Assert.assertTrue(productsPage.getProductCardCount() > 0, "No product cards are visible.");
        Assert.assertTrue(productsPage.getProductNameCount() > 0, "Product names are not visible.");
        Assert.assertTrue(productsPage.getProductPriceCount() > 0, "Product prices are not visible.");
    }

    @Test(priority = 5)
    public void verifyProductActionsAreVisible() {
        Assert.assertTrue(productsPage.getAddToCartButtonCount() > 0, "Add to Cart buttons are not visible.");
        Assert.assertTrue(productsPage.getViewProductLinkCount() > 0, "View Product links are not visible.");
    }

    @Test(priority = 6)
    public void verifySpecificProductsAreDisplayed() {
        Assert.assertTrue(productsPage.isProductVisibleByName("Blue Top"), "Blue Top product is not visible.");
        Assert.assertTrue(productsPage.isProductVisibleByName("Men Tshirt"), "Men Tshirt product is not visible.");
        Assert.assertTrue(productsPage.isProductVisibleByName("Sleeveless Dress"), "Sleeveless Dress product is not visible.");
    }

    @Test(priority = 7)
    public void verifySearchProductWithValidKeyword() {
        productsPage.searchProduct("Top");
        Assert.assertTrue(productsPage.isSearchedProductsHeadingVisible(), "Searched Products heading is not visible.");
        Assert.assertTrue(productsPage.getProductCardCount() > 0, "No products were returned for valid search keyword.");
    }

    @Test(priority = 8)
    public void verifySearchResultContainsKeyword() {
        productsPage.searchProduct("Top");
        Assert.assertTrue(productsPage.doAllVisibleProductsContainKeyword("Top"), "Not all visible search results contain keyword.");
    }

    @Test(priority = 9)
    public void verifyViewProductNavigation() {
        productsPage.clickFirstViewProduct();
        Assert.assertTrue(productsPage.getCurrentUrl().contains("/product_details"), "View Product did not navigate to product details page.");
    }

    @Test(priority = 10)
    public void verifyAddToCartModalAppears() {
        productsPage.clickFirstAddToCartButton();
        Assert.assertTrue(productsPage.isAddedModalVisible(), "Add to cart modal is not visible.");
        Assert.assertTrue(productsPage.isViewCartButtonVisible(), "View Cart button is not visible in modal.");
        Assert.assertTrue(productsPage.isContinueShoppingButtonVisible(), "Continue Shopping button is not visible in modal.");
    }

    @Test(priority = 11)
    public void verifyViewCartFromAddToCartModal() {
        productsPage.clickFirstAddToCartButton();
        productsPage.clickViewCartFromModal();
        Assert.assertTrue(productsPage.getCurrentUrl().contains("/view_cart"), "View Cart did not navigate to cart page.");
    }

    @Test(priority = 12)
    public void verifySubscriptionWithValidEmailOnProductsPage() {
        productsPage.subscribeWithEmail("products_subscriber@example.com");
        Assert.assertTrue(productsPage.isSubscriptionSuccessMessageVisible(), "Subscription success message is not visible.");
    }
}
