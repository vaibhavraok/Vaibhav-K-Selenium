package Assessment10;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {

    WebDriver driver;

    // Initialization
    public ProductsPage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);

    }

    // Declaration

    @FindBy(className = "title")
    private WebElement productsTitle;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addBackpackButton;

    @FindBy(className = "shopping_cart_badge")
    private WebElement cartCount;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartLink;

    // Business Logic

    public String getProductsTitle() {

        return productsTitle.getText();

    }

    public void addBackpack() {

        addBackpackButton.click();

    }

    public String getCartCount() {

        return cartCount.getText();

    }

    public void clickCart() {

        cartLink.click();

    }

}