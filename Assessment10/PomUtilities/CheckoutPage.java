package Assessment10;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

    WebDriver driver;

    // Initialization
    public CheckoutPage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);

    }

    // Declaration

    @FindBy(id = "first-name")
    private WebElement firstName;

    @FindBy(id = "last-name")
    private WebElement lastName;

    @FindBy(id = "postal-code")
    private WebElement postalCode;

    @FindBy(id = "continue")
    private WebElement continueButton;

    @FindBy(className = "title")
    private WebElement overviewTitle;

    @FindBy(id = "finish")
    private WebElement finishButton;

    @FindBy(className = "complete-header")
    private WebElement successMessage;

    // Business Logic

    public void enterFirstName(String name) {

        firstName.sendKeys(name);

    }

    public void enterLastName(String name) {

        lastName.sendKeys(name);

    }

    public void enterPostalCode(String code) {

        postalCode.sendKeys(code);

    }

    public void clickContinue() {

        continueButton.click();

    }

    public String getOverviewTitle() {

        return overviewTitle.getText();

    }

    public void clickFinish() {

        finishButton.click();

    }

    public String getSuccessMessage() {

        return successMessage.getText();

    }

}