
package Assessment12.pom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class myinfopage {

    public WebDriver d;

    WebDriverWait wait;


    public myinfopage(WebDriver d) {

        this.d = d;

        PageFactory.initElements(d, this);

        wait = new WebDriverWait(d, Duration.ofSeconds(15));

    }


    @FindBy(name = "firstName")
    private WebElement FN;


    @FindBy(name = "lastName")
    private WebElement LN;


    @FindBy(xpath = "//label[text()='Employee Id']/following::input[1]")
    private WebElement EId;


    @FindBy(xpath = "(//button[@type='submit'])[1]")
    private WebElement savebtn;


    // Wait until form loader disappears

    public void waitForLoader() {

        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.cssSelector(".oxd-form-loader")));

    }


    // First Name

    public void getFN(String value) {

        waitForLoader();

        wait.until(ExpectedConditions.elementToBeClickable(FN));

        FN.click();

        FN.sendKeys(Keys.CONTROL, "a");

        FN.sendKeys(Keys.BACK_SPACE);

        FN.sendKeys(value);

    }


    // Last Name

    public void getLN(String value) {

        waitForLoader();

        wait.until(ExpectedConditions.elementToBeClickable(LN));

        LN.click();

        LN.sendKeys(Keys.CONTROL, "a");

        LN.sendKeys(Keys.BACK_SPACE);

        LN.sendKeys(value);

    }


    // Employee ID

    public void getEId(String value) {

        waitForLoader();

        wait.until(ExpectedConditions.elementToBeClickable(EId));

        EId.click();

        EId.sendKeys(Keys.CONTROL, "a");

        EId.sendKeys(Keys.BACK_SPACE);

        EId.sendKeys(value);

    }


    // Save button

    public void getSavebtn() {

        waitForLoader();

        wait.until(ExpectedConditions.elementToBeClickable(savebtn));

        savebtn.click();

    }


    // Verify First Name

    public String verifyFN() {

        waitForLoader();

        return FN.getAttribute("value");

    }


    // Verify Last Name

    public String verifyLN() {

        waitForLoader();

        return LN.getAttribute("value");

    }


    // Verify Employee ID

    public String verifyEId() {

        waitForLoader();

        return EId.getAttribute("value");

    }

}
