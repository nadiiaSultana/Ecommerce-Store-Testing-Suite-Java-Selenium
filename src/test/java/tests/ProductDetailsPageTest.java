package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;

public class ProductDetailsPageTest extends BaseTest {

    private ProductDetailsPage productDetailsPage;

    @BeforeMethod
    public void openProductDetailsPage() {
        driver.get("https://automationexercise.com/product_details/1");
        productDetailsPage = new ProductDetailsPage(driver);
    }

    @Test(priority = 1)
    public void verifyProductDetailsPageLoadsSuccessfully() {
        Assert.assertTrue(productDetailsPage.isProductDetailsPageOpened(), "Product details page URL is incorrect.");
        Assert.assertTrue(productDetailsPage.isProductNameVisible(), "Product name Blue Top is not visible.");
    }

    @Test(priority = 2)
    public void verifyProductBasicInformationIsVisible() {
        Assert.assertTrue(productDetailsPage.isProductCategoryVisible(), "Product category is not visible.");
        Assert.assertTrue(productDetailsPage.isProductPriceVisible(), "Product price is not visible.");
        Assert.assertTrue(productDetailsPage.isAvailabilityVisible(), "Availability is not visible.");
        Assert.assertTrue(productDetailsPage.isConditionVisible(), "Condition is not visible.");
        Assert.assertTrue(productDetailsPage.isBrandVisible(), "Brand is not visible.");
    }

    @Test(priority = 3)
    public void verifyDefaultQuantityIsOne() {
        Assert.assertEquals(productDetailsPage.getQuantityValue(), "1", "Default quantity should be 1.");
    }

    @Test(priority = 4)
    public void verifyUserCanUpdateQuantity() {
        productDetailsPage.setQuantity("4");
        Assert.assertEquals(productDetailsPage.getQuantityValue(), "4", "Quantity value was not updated correctly.");
    }

    @Test(priority = 5)
    public void verifyAddToCartModalAppearsFromProductDetailsPage() {
        productDetailsPage.clickAddToCart();
        Assert.assertTrue(productDetailsPage.isAddedModalVisible(), "Add to cart modal is not visible.");
        Assert.assertTrue(productDetailsPage.isViewCartButtonVisible(), "View Cart button is not visible.");
        Assert.assertTrue(productDetailsPage.isContinueShoppingButtonVisible(), "Continue Shopping button is not visible.");
    }

    @Test(priority = 6)
    public void verifyViewCartFromAddToCartModalNavigatesToCartPage() {
        productDetailsPage.clickAddToCart();
        productDetailsPage.clickViewCartFromModal();
        Assert.assertTrue(productDetailsPage.getCurrentUrl().contains("/view_cart"), "View Cart did not navigate to cart page.");
    }

    @Test(priority = 7)
    public void verifyReviewSectionIsVisible() {
        Assert.assertTrue(productDetailsPage.isReviewSectionVisible(), "Review section is not fully visible.");
    }

    @Test(priority = 8)
    public void verifyUserCanSubmitProductReview() {
        productDetailsPage.submitReview("Test User", "testreview@example.com", "This product looks good for automation testing practice.");
        Assert.assertTrue(productDetailsPage.isReviewSuccessMessageVisible(), "Review success message is not visible.");
    }

    @Test(priority = 9)
    public void verifyCategoryAndBrandsSectionsAreVisible() {
        Assert.assertTrue(productDetailsPage.isCategorySectionVisible(), "Category section is not visible.");
        Assert.assertTrue(productDetailsPage.areMainCategoriesVisible(), "Main categories are not visible.");
        Assert.assertTrue(productDetailsPage.isBrandsSectionVisible(), "Brands section is not visible.");
        Assert.assertTrue(productDetailsPage.getBrandCount() >= 8, "Expected at least 8 brand links.");
    }

    @Test(priority = 10)
    public void verifySubscriptionWithValidEmail() {
        productDetailsPage.subscribeWithEmail("product_details_subscriber@example.com");
        Assert.assertTrue(productDetailsPage.isSubscriptionSuccessMessageVisible(), "Subscription success message is not visible.");
    }
}
