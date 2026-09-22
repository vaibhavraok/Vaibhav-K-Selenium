package orange_HRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class buzz {

    WebDriver d;

    public buzz(WebDriver d) {
        this.d = d;
        PageFactory.initElements(d, this);
    }

    @FindBy(xpath="//textarea[@class='oxd-buzz-post-input']")
    private WebElement enterdata;

    @FindBy(xpath="//button[@type='submit']")
    private WebElement post;

    @FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--label-warn orangehrm-post-filters-button']/../..//p[@class='oxd-text oxd-text--p orangehrm-buzz-post-body-text']")
    private WebElement recentPost;


    public void getEnterdata(String data) {
        enterdata.sendKeys(data);
    }


    public void getPost() {
        post.click();
    }


    public boolean getRecentPost(String test) {
        String txt = recentPost.getText();
        return txt.equals(test);
    }


    public void verify(String args) {
        Assert.assertTrue(getRecentPost(args));
        System.out.println("verification successfull");
    }
}
