package Advance_Assessment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BuzzPage {
	WebDriver driver;
	public BuzzPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//span[text()='Buzz']")
	private WebElement buzz;
	
	@FindBy(css = "[placeholder=\"What's on your mind?\"]")
	private WebElement enterdata;
	
	@FindBy(css = "[type='submit']")
	private WebElement post;
	
	@FindBy(xpath = "(//div[contains(@class,'orangehrm-buzz-post-body')])[1]")
	private WebElement recentPost;
	
	public void getBuzz() {
		buzz.click();
	}
	
	public void getEnterdata(String data) {
		enterdata.sendKeys(data);
	}
	
	
	public void getPost() {
		post.click();
	}
	
	public boolean getRecentPost(String test) {
		String txt=recentPost.getText();
		return txt.equals(test);
	}
	
	public void verify(String args) {
		Assert.assertTrue(getRecentPost(args));
		System.out.println("verification successfull");
	}
	
	
}
