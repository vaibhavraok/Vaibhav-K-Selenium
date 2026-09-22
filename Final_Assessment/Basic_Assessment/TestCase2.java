package Basic_Assessment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class TestCase2 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://demoapps.qspiders.com/ui/slider?sublist=0");
		WebElement slide = driver.findElement(By.id("slide"));
		Actions act=new Actions(driver);
		Thread.sleep(3000);
		act.dragAndDropBy(slide, 120,0).perform();
		Thread.sleep(2000);
		boolean text = driver.findElement(By.xpath("//h3[text()='Mens Cotton Jacket']")).isDisplayed();
		Assert.assertTrue(text);
		System.out.println("verification successfull");
		driver.quit();
	}

}
