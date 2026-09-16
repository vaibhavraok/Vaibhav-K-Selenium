package PomUtilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CandidatesPage {

    WebDriver driver;

    WebDriverWait wait;


    // Initialization
    public CandidatesPage(WebDriver driver) {

        this.driver = driver;

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        PageFactory.initElements(driver, this);
    }


    // Candidates
    @FindBy(xpath = "//a[normalize-space()='Candidates']")
    private WebElement candidates;


    // Job Title
    @FindBy(xpath = "//label[text()='Job Title']/following::div[contains(@class,'oxd-select-text')][1]")
    private WebElement jobTitle;


    // Vacancy
    @FindBy(xpath = "//label[text()='Vacancy']/following::div[contains(@class,'oxd-select-text')][1]")
    private WebElement vacancy;


    // Hiring Manager
    @FindBy(xpath = "//label[text()='Hiring Manager']/following::div[contains(@class,'oxd-select-text')][1]")
    private WebElement hiringManager;


    // Status
    @FindBy(xpath = "//label[text()='Status']/following::div[contains(@class,'oxd-select-text')][1]")
    private WebElement status;


    // Candidate Name
    @FindBy(xpath = "//label[text()='Candidate Name']/following::input[1]")
    private WebElement candidateName;


    // Search Button
    @FindBy(xpath = "//button[normalize-space()='Search']")
    private WebElement searchButton;


    // Click Candidates
    public void clickCandidates() {

        wait.until(ExpectedConditions.elementToBeClickable(candidates)).click();
    }


    // Select Job Title
    public void selectJobTitle() throws InterruptedException {

        jobTitle.click();
        Thread.sleep(2000);
        WebElement firstOption = wait.until( ExpectedConditions.elementToBeClickable( By.xpath("//div[@role='option'][29]")));

        firstOption.click();
    }


    // Select Vacancy
    public void selectVacancy() throws InterruptedException {

        vacancy.click();
        Thread.sleep(2000);
        WebElement firstOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='option'][32]")));

        firstOption.click();
    }


    // Select Hiring Manager
    public void selectHiringManager() throws InterruptedException {

        hiringManager.click();
        Thread.sleep(2000);
        WebElement firstOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='option'][2]")));

        firstOption.click();
    }


    // Select Status
    public void selectStatus() throws InterruptedException {

        status.click();
        Thread.sleep(2000);
        WebElement firstOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='option'][2]")));

        firstOption.click();
    }


    // Enter Candidate Name
    public void enterCandidateName(String f,String m,String l) throws InterruptedException {
    	Thread.sleep(2000);
        candidateName.sendKeys(f+" "+m+" "+l);
    }


    // Search
    public void clickSearch() throws InterruptedException {
    	Thread.sleep(2000);
        searchButton.click();
    }


    // Verify Candidate
    public boolean verifyCandidate(String arg) {

        try {

            WebElement candidate = wait.until(ExpectedConditions.visibilityOfElementLocated( By.xpath("//div[@role='row']//div[contains(text(),'"+ arg +"')]")));

            return candidate.isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }
}