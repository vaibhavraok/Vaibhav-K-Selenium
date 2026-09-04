package SeleniumnTestCase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
public class instagram {
	public static void main(String[] args) throws Throwable {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://instagram.com");
		driver.findElement(By.name("email")).sendKeys("Admin@gmail",Keys.chord(Keys.CONTROL,"a"),Keys.chord(Keys.CONTROL,"c"),Keys.TAB,Keys.chord(Keys.CONTROL,"v"),Keys.ENTER);
		Thread.sleep(2000);
		driver.quit();
	}
}
