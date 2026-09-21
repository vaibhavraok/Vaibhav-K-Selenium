package Assessment12.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage {

	public WebDriver d;
	public loginpage(WebDriver d)
	{
		this.d = d;
		PageFactory.initElements(d , this);
	}
	
	@FindBy(name="username")
	private WebElement UN;
	
	@FindBy(name="password")
	private WebElement PW;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginbtn;
	
	public void getUN(String value) {
		UN.sendKeys(value);
	}

	public void getPW(String value) {
		PW.sendKeys(value);;
	}

	public void getLoginbtn() {
		loginbtn.click();
	}
	
}
