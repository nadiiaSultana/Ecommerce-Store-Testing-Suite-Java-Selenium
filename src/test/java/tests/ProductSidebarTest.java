package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ProductsPage;

public class ProductSidebarTest extends BaseTest {

    private ProductsPage productsPage;

    @BeforeMethod
    public void openProductsPage() {
        driver.get("https://automationexercise.com/products");
        productsPage = new ProductsPage(driver);
    }

    @Test(priority = 1)
    public void verifyCategorySidebarTitleIsVisible() {
        Assert.assertTrue(productsPage.isCategorySidebarTitleVisible(), "Category sidebar title is not visible.");
    }

    @Test(priority = 2)
    public void verifyMainCategoryHeadersAreVisible() {
        Assert.assertTrue(productsPage.areCategoryHeadersVisible(), "Women, Men, or Kids category header is not visible.");
    }

    @Test(priority = 3)
    public void verifyCategoryPlusIconsAreVisible() {
        Assert.assertTrue(productsPage.areCategoryPlusIconsVisible(), "One or more category plus icons are not visible.");
    }

    @Test(priority = 4)
    public void verifyWomenCategoryExpandsAndShowsSubcategories() {
        productsPage.expandWomenCategory();
        Assert.assertTrue(productsPage.areWomenSubcategoriesVisible(), "Women subcategories are not visible.");
    }

    @Test(priority = 5)
    public void verifyMenCategoryExpandsAndShowsSubcategories() {
        productsPage.expandMenCategory();
        Assert.assertTrue(productsPage.areMenSubcategoriesVisible(), "Men subcategories are not visible.");
    }

    @Test(priority = 6)
    public void verifyKidsCategoryExpandsAndShowsSubcategories() {
        productsPage.expandKidsCategory();
        Assert.assertTrue(productsPage.areKidsSubcategoriesVisible(), "Kids subcategories are not visible.");
    }

    @Test(priority = 7)
    public void verifyWomenDressCategoryNavigation() {
        productsPage.clickWomenDressCategory();
        Assert.assertTrue(productsPage.getCurrentUrl().contains("/category_products/1"), "Women Dress category did not navigate correctly.");
    }

    @Test(priority = 8)
    public void verifyWomenTopsCategoryNavigation() {
        productsPage.clickWomenTopsCategory();
        Assert.assertTrue(productsPage.getCurrentUrl().contains("/category_products/2"), "Women Tops category did not navigate correctly.");
    }

    @Test(priority = 9)
    public void verifyMenTshirtsCategoryNavigation() {
        productsPage.clickMenTshirtsCategory();
        Assert.assertTrue(productsPage.getCurrentUrl().contains("/category_products/3"), "Men Tshirts category did not navigate correctly.");
    }

    @Test(priority = 10)
    public void verifyBrandsSidebarTitleIsVisible() {
        Assert.assertTrue(productsPage.isBrandsSidebarTitleVisible(), "Brands sidebar title is not visible.");
    }

    @Test(priority = 11)
    public void verifyAllExpectedBrandsAreVisible() {
        Assert.assertTrue(productsPage.areAllExpectedBrandsVisible(), "One or more expected brands are not visible.");
    }

    @Test(priority = 12)
    public void verifyTotalBrandCount() {
        Assert.assertEquals(productsPage.getTotalBrandCount(), 8, "Total brand count should be 8.");
    }

    @Test(priority = 13)
    public void verifyBrandTextsWithProductCounts() {
        Assert.assertTrue(productsPage.getPoloBrandText().contains("POLO") && productsPage.getPoloBrandText().contains("(6)"), "Polo text/count incorrect.");
        Assert.assertTrue(productsPage.getHMBrandText().contains("H&M") && productsPage.getHMBrandText().contains("(5)"), "H&M text/count incorrect.");
        Assert.assertTrue(productsPage.getMadameBrandText().contains("MADAME") && productsPage.getMadameBrandText().contains("(5)"), "Madame text/count incorrect.");
        Assert.assertTrue(productsPage.getMastHarbourBrandText().contains("MAST & HARBOUR") && productsPage.getMastHarbourBrandText().contains("(3)"), "Mast & Harbour text/count incorrect.");
        Assert.assertTrue(productsPage.getBabyhugBrandText().contains("BABYHUG") && productsPage.getBabyhugBrandText().contains("(4)"), "Babyhug text/count incorrect.");
        Assert.assertTrue(productsPage.getAllenSollyJuniorBrandText().contains("ALLEN SOLLY JUNIOR") && productsPage.getAllenSollyJuniorBrandText().contains("(3)"), "Allen Solly text/count incorrect.");
        Assert.assertTrue(productsPage.getKookieKidsBrandText().contains("KOOKIE KIDS") && productsPage.getKookieKidsBrandText().contains("(3)"), "Kookie Kids text/count incorrect.");
        Assert.assertTrue(productsPage.getBibaBrandText().contains("BIBA") && productsPage.getBibaBrandText().contains("(5)"), "Biba text/count incorrect.");
    }

    @Test(priority = 14)
    public void verifyPoloBrandFilterNavigation() {
        productsPage.clickPoloBrandFilter();
        Assert.assertTrue(productsPage.getCurrentUrl().contains("/brand_products/Polo"), "Polo brand filter did not navigate correctly.");
    }
}
