package Assessment12.pom;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class myinfopage {

	public WebDriver d;
	public myinfopage(WebDriver d)
	{
		this.d = d;
		PageFactory.initElements(d , this);
	}
	
	@FindBy(name="firstName")
	private WebElement FN;
	
	@FindBy(name="lastName")
	private WebElement LN;
	
	@FindBy(xpath="//label[text()='Employee Id']/following::input[1]")
	private WebElement EId;
	
	@FindBy(xpath="(//button[@type='submit'])[1]")
	private WebElement savebtn;
	
	@FindBy(xpath="//p[text()='Vishusneha Bohaddurk']")
	private WebElement verify;
	
	
	public void getFN(String value) throws InterruptedException {
		 FN.click();
		 FN.sendKeys(Keys.CONTROL, "a");
		 Thread.sleep(2000);
		 FN.sendKeys(Keys.BACK_SPACE);
		 FN.sendKeys(value);
	}

	public void getLN(String value) throws InterruptedException {
		 LN.click();
		 LN.sendKeys(Keys.CONTROL, "a");
		 Thread.sleep(2000);
		 LN.sendKeys(Keys.BACK_SPACE);
		 LN.sendKeys(value);
	}

	public void getEId(String value) throws InterruptedException {
		EId.click();
		EId.sendKeys(Keys.CONTROL, "a");
		Thread.sleep(2000);
		EId.sendKeys(Keys.BACK_SPACE);
		EId.sendKeys(value);
	}

	public void getSavebtn() {
		savebtn.click();
	}
	
	public String verifyFN() {
		return FN.getAttribute("value");
	}
	
	public String verifyLN() {
		return LN.getAttribute("value");
	}

	public String verifyEId() {
		return EId.getAttribute("value");
	}
	
}