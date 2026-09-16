package PomUtilities;

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


    // Username
    @FindBy(name = "username")
    private WebElement username;


    // Password
    @FindBy(name = "password")
    private WebElement password;


    // Login Button
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;


    // Enter Username
    public void enterUsername(String arg) {

        username.sendKeys(arg);
    }


    // Enter Password
    public void enterPassword(String arg) {

        password.sendKeys(arg);
    }


    // Click Login
    public void clickLogin() {

        loginButton.click();
    }
}