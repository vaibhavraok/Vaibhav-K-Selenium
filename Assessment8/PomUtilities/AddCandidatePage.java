package PomUtilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddCandidatePage {

    WebDriver driver;

    WebDriverWait wait;


    // Initialization
    public AddCandidatePage(WebDriver driver) {

        this.driver = driver;

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        
        PageFactory.initElements(driver, this);
    }


    // Add Button
    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement add;


    // First Name
    @FindBy(name = "firstName")
    private WebElement firstName;


    // Middle Name
    @FindBy(name = "middleName")
    private WebElement middleName;


    // Last Name
    @FindBy(name = "lastName")
    private WebElement lastName;


    // Vacancy
    @FindBy(xpath = "//label[text()='Vacancy']/following::div[contains(@class,'oxd-select-text')][1]")
    private WebElement vacancy;


    // Email
    @FindBy(xpath = "//input[@placeholder='Type here']")
    private WebElement email;


    // Mobile
    @FindBy(xpath = "//label[text()='Contact Number']/following::input[1]")
    private WebElement mobile;


    // Resume
    @FindBy(xpath = "//input[@type='file']")
    private WebElement resume;


    // Save Button
    @FindBy(xpath = "//button[normalize-space()='Save']")
    private WebElement saveButton;


    // Click Add
    public void clickAdd() {
    	wait.until(ExpectedConditions.elementToBeClickable(add)).click();
    }


    // First Name
    public void enterFirstName(String arg) {

        firstName.sendKeys(arg);
    }


    // Middle Name
    public void enterMiddleName(String arg) {

        middleName.sendKeys(arg);
    }


    // Last Name
    public void enterLastName(String arg) {

        lastName.sendKeys(arg);
    }


    // Select Vacancy
    public void selectVacancy() throws InterruptedException {

        vacancy.click();
        Thread.sleep(2000);
        WebElement firstOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='option'][18]")));
        firstOption.click();
    }


    // Email
    public void enterEmail(String arg) {

        email.sendKeys(arg);
    }


    // Mobile
    public void enterMobile(String arg) {

        mobile.sendKeys(arg);
    }


    // Upload Resume
    public void uploadFile(String arg) {

        resume.sendKeys(arg);
    }


    // Save
    public void clickSave() {

        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
    }
}