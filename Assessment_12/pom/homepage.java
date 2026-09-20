package Assessment12.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homepage {

	WebDriver d;
	
	public homepage(WebDriver d)
	{
		this.d = d;
		PageFactory.initElements(d,this);
	}
	
	@FindBy(xpath="//span[text()='Recruitment']")
	private WebElement RecruitmentLink;
	
	@FindBy(xpath = "//span[text()='My Info']")
	private WebElement infoLink;

	public void getRecruitmentLink() {
		RecruitmentLink.click();
	}
	
	public void getInfoLink() {
		infoLink.click();
	}
}