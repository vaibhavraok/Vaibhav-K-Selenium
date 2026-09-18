package Assessment10;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SauceDemoTest extends BaseClass {

    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;

    @Test(priority = 1)
    public void loginTest() throws InterruptedException {

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);

        Thread.sleep(2000);

        String username = p.getProperty("username");
        String password = p.getProperty("password");

        loginPage.login(username, password);

        Thread.sleep(2000);

        String actualTitle = productsPage.getProductsTitle();

        Assert.assertEquals(actualTitle, "Products");

        System.out.println("Products page is displayed successfully.");

        Thread.sleep(2000);
    }


    @Test(priority = 2, dependsOnMethods = "loginTest")
    public void orderPlacementTest() throws IOException, InterruptedException {

        productsPage = new ProductsPage(driver);

        // Add Sauce Labs Backpack
        productsPage.addBackpack();

        Thread.sleep(2000);

        // Verify cart contains 1 item
        String cartCount = productsPage.getCartCount();

        Assert.assertEquals(cartCount, "1");

        System.out.println("Cart contains 1 item.");

        Thread.sleep(2000);

        // Open cart
        productsPage.clickCart();

        Thread.sleep(2000);

        cartPage = new CartPage(driver);

        // Verify Backpack is displayed
        String productName = cartPage.getBackpackName();

        Assert.assertEquals(productName, "Sauce Labs Backpack");

        System.out.println("Sauce Labs Backpack is displayed.");

        Thread.sleep(2000);

        // Click Checkout
        cartPage.clickCheckout();

        Thread.sleep(2000);

        checkoutPage = new CheckoutPage(driver);

        // Read data from Excel
        FileInputStream fis = new FileInputStream("./src/test/resources/Assessment10_data/TestData.xlsx");

	    Workbook wb = WorkbookFactory.create(fis);

	    String firstName = wb.getSheet("Sheet1").getRow(1).getCell(0).toString();
	    String lastName = wb.getSheet("Sheet1").getRow(1).getCell(1).toString();
	    String postalCode = wb.getSheet("Sheet1").getRow(1).getCell(2).toString();

        // Enter First Name
        checkoutPage.enterFirstName(firstName);

        Thread.sleep(1000);

        // Enter Last Name
        checkoutPage.enterLastName(lastName);

        Thread.sleep(1000);

        // Enter Postal Code
        checkoutPage.enterPostalCode(postalCode);

        Thread.sleep(2000);

        // Click Continue
        checkoutPage.clickContinue();

        Thread.sleep(2000);

        // Verify Checkout: Overview
        String overviewTitle = checkoutPage.getOverviewTitle();

        Assert.assertEquals(overviewTitle, "Checkout: Overview");

        System.out.println("Checkout: Overview page is displayed.");

        Thread.sleep(2000);

        // Click Finish
        checkoutPage.clickFinish();

        Thread.sleep(3000);

        // Verify success message
        String message = checkoutPage.getSuccessMessage();

        Assert.assertEquals(message, "Thank you for your order!");

        System.out.println("Thank you for your order!");

        Thread.sleep(3000);
    }
}
