package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import utils.CartActions;

public class CartPageTest extends BaseTest {

    private CartPage cartPage;
    private CartActions cartActions;

    @BeforeMethod
    public void setupCartTest() {
        cartPage = new CartPage(driver);
        cartActions = new CartActions(driver);
    }

    @Test(priority = 1)
    public void verifyCartPageLoadsSuccessfully() {
        driver.get("https://automationexercise.com/view_cart");
        Assert.assertTrue(cartPage.isCartPageOpened(), "Cart page URL is incorrect.");
    }

    @Test(priority = 2)
    public void verifyEmptyCartPageMessage() {
        driver.get("https://automationexercise.com/view_cart");
        Assert.assertTrue(cartPage.isEmptyCartMessageVisible(), "Empty cart message is not visible.");
        Assert.assertTrue(cartPage.isHereLinkVisible(), "Here link is not visible on empty cart page.");
    }

    @Test(priority = 3)
    public void verifyProductAddedFromHomePageAppearsInCart() {
        cartActions.addBlueTopFromHomePage();
        cartActions.goToCartPage();
        Assert.assertTrue(cartPage.isCartTableVisible(), "Cart table is not visible after adding product.");
        Assert.assertTrue(cartPage.isBlueTopVisibleInCart(), "Blue Top added from homepage is not visible in cart.");
    }

    @Test(priority = 4)
    public void verifyProductAddedFromProductsPageAppearsInCart() {
        cartActions.addMenTshirtFromProductsPage();
        cartActions.goToCartPage();
        Assert.assertTrue(cartPage.isCartTableVisible(), "Cart table is not visible after adding product.");
        Assert.assertTrue(cartPage.isMenTshirtVisibleInCart(), "Men Tshirt added from products page is not visible in cart.");
    }

    @Test(priority = 5)
    public void verifyMultipleProductsFromDifferentPagesAppearInCart() {
        cartActions.addBlueTopFromHomePage();
        cartActions.addMenTshirtFromProductsPage();
        cartActions.addSleevelessDressFromProductsPage();
        cartActions.goToCartPage();
        Assert.assertTrue(cartPage.isBlueTopVisibleInCart(), "Blue Top is not visible in cart.");
        Assert.assertTrue(cartPage.isMenTshirtVisibleInCart(), "Men Tshirt is not visible in cart.");
        Assert.assertTrue(cartPage.isSleevelessDressVisibleInCart(), "Sleeveless Dress is not visible in cart.");
        Assert.assertTrue(cartPage.getCartRowCount() >= 3, "Cart should contain at least 3 products.");
    }

    @Test(priority = 6)
    public void verifyCartTableColumnsAreVisibleForAddedProducts() {
        cartActions.addBlueTopFromHomePage();
        cartActions.addMenTshirtFromProductsPage();
        cartActions.goToCartPage();
        Assert.assertTrue(cartPage.areCartColumnsVisibleForAllProducts(), "One or more cart table columns are missing.");
    }

    @Test(priority = 7)
    public void verifyCartProductPriceQuantityAndTotalAreVisible() {
        cartActions.addBlueTopFromHomePage();
        cartActions.goToCartPage();
        Assert.assertTrue(cartPage.getProductPriceByName("Blue Top").contains("Rs."), "Blue Top price is not visible.");
        Assert.assertEquals(cartPage.getProductQuantityByName("Blue Top"), "1", "Blue Top quantity should be 1.");
        Assert.assertTrue(cartPage.getProductTotalByName("Blue Top").contains("Rs."), "Blue Top total price is not visible.");
    }

    @Test(priority = 8)
    public void verifyCartTotalCalculationForSingleQuantityProduct() {
        cartActions.addMenTshirtFromProductsPage();
        cartActions.goToCartPage();
        Assert.assertTrue(cartPage.isTotalCorrectForProduct("Men Tshirt"), "Cart total is not calculated correctly.");
    }

    @Test(priority = 9)
    public void verifyProductAddedFromProductDetailsPageWithCustomQuantity() {
        cartActions.addBlueTopFromProductDetailsPageAndGoToCart("4");
        Assert.assertTrue(cartPage.isBlueTopVisibleInCart(), "Blue Top added from details page is not visible in cart.");
        Assert.assertEquals(cartPage.getProductQuantityByName("Blue Top"), "4", "Blue Top quantity in cart should be 4.");
    }

    @Test(priority = 10)
    public void verifyCartTotalCalculationForCustomQuantityProduct() {
        cartActions.addBlueTopFromProductDetailsPageAndGoToCart("3");
        Assert.assertTrue(cartPage.isTotalCorrectForProduct("Blue Top"), "Cart total is not calculated correctly for custom quantity.");
    }

    @Test(priority = 11)
    public void verifyRemoveSingleProductFromCart() {
        cartActions.addBlueTopFromHomePage();
        cartActions.goToCartPage();
        Assert.assertTrue(cartPage.isBlueTopVisibleInCart(), "Blue Top should be visible before removal.");
        cartPage.removeProductFromCart("Blue Top");
        Assert.assertTrue(cartPage.waitUntilProductRemoved("Blue Top"), "Blue Top was not removed from the cart.");
    }

    @Test(priority = 12)
    public void verifyRemoveOneProductDoesNotRemoveOtherProducts() {
        cartActions.addBlueTopFromHomePage();
        cartActions.addMenTshirtFromProductsPage();
        cartActions.goToCartPage();
        cartPage.removeProductFromCart("Blue Top");
        Assert.assertTrue(cartPage.waitUntilProductRemoved("Blue Top"), "Blue Top was not removed from the cart.");
        Assert.assertTrue(cartPage.isMenTshirtVisibleInCart(), "Men Tshirt should still remain in cart.");
    }

    @Test(priority = 13)
    public void verifyProceedToCheckoutButtonIsVisibleForNonEmptyCart() {
        cartActions.addBlueTopFromHomePage();
        cartActions.goToCartPage();
        Assert.assertTrue(cartPage.isProceedToCheckoutButtonVisible(), "Proceed To Checkout button is not visible.");
    }

    @Test(priority = 14)
    public void verifyProceedToCheckoutShowsRegisterLoginModalForGuestUser() {
        cartActions.addBlueTopFromHomePage();
        cartActions.goToCartPage();
        cartPage.clickProceedToCheckout();
        Assert.assertTrue(cartPage.isRegisterLoginLinkVisibleInCheckoutModal(), "Register / Login link is not visible.");
        Assert.assertTrue(cartPage.isContinueOnCartButtonVisible(), "Continue On Cart button is not visible.");
    }

    @Test(priority = 15)
    public void verifySubscriptionWithValidEmailOnCartPage() {
        driver.get("https://automationexercise.com/view_cart");
        cartPage.subscribeWithEmail("cart_subscriber@example.com");
        Assert.assertTrue(cartPage.isSubscriptionSuccessMessageVisible(), "Subscription success message is not visible.");
    }
}
