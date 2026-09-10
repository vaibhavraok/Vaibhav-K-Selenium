package Assessment4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestCase3 {

	public static void main(String[] args)throws Throwable{
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://bigbasket.com");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("apples",Keys.ENTER);
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		WebElement v = driver.findElement(By.xpath("//button[text()='Add']"));
		Thread.sleep(2000);
		act.scrollToElement(v).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Add']")).click();
		System.out.println(driver.findElement(By.xpath("//p[text()='An item has been added to your basket successfully']")).getText());
		Thread.sleep(2000);
		driver.quit();
	}

}
