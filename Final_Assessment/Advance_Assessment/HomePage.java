package Advance_Assessment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver d;
	
	public HomePage(WebDriver d)
	{
		this.d = d;
		PageFactory.initElements(d,this);
	}
	
	@FindBy(xpath="//a[@class='oxd-main-menu-item']")
	private WebElement BuzzLink;
	

	public void getBuzzLink() {
		BuzzLink.click();
	}
	
}