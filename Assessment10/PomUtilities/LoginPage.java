package Assessment10;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    // Initialization
    public LoginPage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);

    }

    // Declaration

    @FindBy(id = "user-name")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    // Business Logic

    public void enterUsername(String user) {

        username.sendKeys(user);

    }

    public void enterPassword(String pass) {

        password.sendKeys(pass);

    }

    public void clickLogin() {

        loginButton.click();

    }

    public void login(String user, String pass) {

        enterUsername(user);

        enterPassword(pass);

        clickLogin();

    }

}