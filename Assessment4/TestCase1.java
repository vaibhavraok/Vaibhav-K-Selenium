package Assessment4;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class TestCase1 {
	public static void main(String [] args) throws Throwable{
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://facebook.com");
		List<WebElement> textfield = driver.findElements(By.tagName("input"));
		int count=textfield.size();
		System.out.println(count);
		Thread.sleep(2000);
		for(WebElement ele:textfield) {
			if(ele.getAttribute("name").equals("pass")) {
				ele.sendKeys("hello");
				System.out.println(ele.getAttribute("name"));
				break;
			}
			System.out.println(ele.getAttribute("name"));
		}
		Thread.sleep(4000);
		driver.quit();
	}
}
