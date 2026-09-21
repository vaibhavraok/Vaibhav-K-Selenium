package Assessment12.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class logoutpage {

	public WebDriver d;
	public logoutpage(WebDriver d)
	{
		this.d = d;
		PageFactory.initElements(d , this);
	}
	
	@FindBy(xpath="//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")
	private WebElement dd;
	
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logoutbtn;
	
	public void getDd() {
		dd.click();
	}

	public void getLogoutbtn() throws InterruptedException {
		logoutbtn.click();
		Thread.sleep(2000);
	}
	
	
}
