package Basic_Assessment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
//        Task 1
//        1.Navigate to demoAppsQspiders toggle page 2.Click on disabled toggle buttons
//        3.Click on Place order button. 4.Verify that order is placed.

public class TestCase1 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://demoapps.qspiders.com/ui/toggle/disabled?sublist=1");
		List<WebElement> toggle = driver.findElements(By.xpath("//span[@class='relative bg-gray-300 rounded-full w-9 h-4 transition duration-300 ease-in-out']"));
		for(WebElement i:toggle) {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].removeAttribute('disabled')",i);
			i.click();	
			Thread.sleep(2000);
			}
		driver.findElement(By.id("togglers")).click();
		String text = driver.findElement(By.xpath("//p[text()='Your Order has been successfully placed!']")).getText();
		
		Assert.assertEquals(text,"Your Order has been successfully placed!");
		System.out.println("verification sucessfully");
	}
}
