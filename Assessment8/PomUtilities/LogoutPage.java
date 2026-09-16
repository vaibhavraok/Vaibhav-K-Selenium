package PomUtilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutPage {

    WebDriver driver;

    WebDriverWait wait;


    // Initialization
    public LogoutPage(WebDriver driver) {

        this.driver = driver;

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        PageFactory.initElements(driver, this);
    }


    // User Menu
    @FindBy(xpath = "//span[contains(@class,'oxd-userdropdown-tab')]")
    private WebElement userMenu;


    // Logout
    @FindBy(xpath = "//a[text()='Logout']")
    private WebElement logout;


    // Logout Method
    public void logout() {

        wait.until(ExpectedConditions.elementToBeClickable(userMenu)).click();

        wait.until(ExpectedConditions.elementToBeClickable(logout)).click();
    }
}