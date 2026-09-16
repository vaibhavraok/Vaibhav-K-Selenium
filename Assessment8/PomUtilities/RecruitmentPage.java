package PomUtilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RecruitmentPage {

    WebDriver driver;

    WebDriverWait wait;


    // Initialization
    public RecruitmentPage(WebDriver driver) {

        this.driver = driver;

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        PageFactory.initElements(driver, this);
    }


    // Recruitment
    @FindBy(xpath = "//span[text()='Recruitment']")
    private WebElement recruitment;


    // Click Recruitment
    public void clickRecruitment() {

        wait.until(ExpectedConditions.elementToBeClickable(recruitment)).click();
    }
}