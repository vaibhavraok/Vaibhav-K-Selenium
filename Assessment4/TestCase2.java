package Assessment4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestCase2 {
	public static void main(String [] args) throws Throwable{
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.zomato.com/bangalore/delivery");
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		Thread.sleep(2000);
		driver.switchTo().frame("auth-login-ui");
		driver.findElement(By.xpath("//input[@type='number']")).sendKeys("1234567890");
		driver.switchTo().defaultContent();
		System.out.println(driver.findElement(By.xpath("//p[text()='Biryani']")));
		Thread.sleep(2000);
		System.out.println("The controller is in the main page");
		driver.quit();
	}
}
