package Assessment12.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class recruitmentPage {

	public WebDriver d;

	public recruitmentPage(WebDriver d) {
		this.d = d;
		PageFactory.initElements(d , this);
	}
	
	@FindBy(xpath="//a[text()='Vacancies']")
	private WebElement vaccLink;
	
	@FindBy(xpath="//button[text()=' Add ']")
	private WebElement Addbtn;
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[2]")
	private WebElement VName;
	
	@FindBy(xpath="//div[text()='-- Select --']")
	private WebElement jobtitle;
	
	@FindBy(xpath="//textarea[@placeholder='Type description here']")
	private WebElement description;
	
	@FindBy(xpath="//input[@placeholder='Type for hints...']")
	private WebElement HR;
	
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[3]")
	private WebElement positions;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement savebtn;

	public void getVaccLink() {
		vaccLink.click();
	}

	public void getAddbtn() {
		Addbtn.click();
	}

	public void getVName(String value) {
		VName.sendKeys(value);;
	}

	public void getJobtitle() throws AWTException {
		jobtitle.click();
		Robot r = new Robot();
		
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	public void getDescription(String value) {
		description.sendKeys(value);;
	}
	public void getHR(String value) {
		description.sendKeys(value);;
	}

	public void getPositions(String value) {
		positions.sendKeys(value);
	}

	public void getSavebtn() {
		savebtn.click();
	}
	
}