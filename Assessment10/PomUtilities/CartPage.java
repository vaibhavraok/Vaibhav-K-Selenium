package Assessment10;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    WebDriver driver;

    // Initialization
    public CartPage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);

    }

    // Declaration

    @FindBy(xpath = "//div[@class='inventory_item_name' and text()='Sauce Labs Backpack']")
    private WebElement backpackName;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    // Business Logic

    public String getBackpackName() {

        return backpackName.getText();

    }

    public void clickCheckout() {

        checkoutButton.click();

    }

}