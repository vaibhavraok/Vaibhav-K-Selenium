package orange_HRM;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ExcelUtility;

public class buzz {

    WebDriver d;

    public buzz(WebDriver d) {
        this.d = d;
        PageFactory.initElements(d, this);
    }

    @FindBy(xpath="//textarea[@class='oxd-buzz-post-input']")
    private WebElement textfield;

    @FindBy(xpath="//button[@type='submit']")
    private WebElement postbtn;

    @FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--label-warn orangehrm-post-filters-button']/../..//p[@class='oxd-text oxd-text--p orangehrm-buzz-post-body-text']")
    private WebElement verify;

    public void getTextfield() throws IOException {

        String text = ExcelUtility.getData("sheet2", 1, 0);

        textfield.sendKeys(text);
    }

    public void getPostbtn() {
        postbtn.click();
    }

    public boolean getVerify() {
        return verify.isDisplayed();
    }
}
