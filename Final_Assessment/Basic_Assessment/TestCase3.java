package Basic_Assessment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

//			Task 3
//        1.Navigate to demoAppsQspiders draganddrop multiple page
//        2.drag and drop the accessories accordingly.

public class TestCase3 {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://demoapps.qspiders.com/ui/dragDrop/dragToCorrect?sublist=2");
		WebElement Mobile= driver.findElement(By.xpath("//div[text()='Mobile Charger']"));
		WebElement Laptop= driver.findElement(By.xpath("//div[text()='Laptop Charger']"));
		WebElement MobileCover= driver.findElement(By.xpath("//div[text()='Mobile Cover']"));
		WebElement LaptopCover= driver.findElement(By.xpath("//div[text()='Laptop Cover']"));
		WebElement MobileAccessories=driver.findElement(By.xpath("//div[text()='Mobile Accessories']"));
		WebElement LaptopAccessories=driver.findElement(By.xpath("//div[text()='Laptop Accessories']"));
		Actions action=new Actions(driver);
		action.dragAndDrop(Mobile, MobileAccessories).perform();
		action.dragAndDrop(MobileCover, MobileAccessories).perform();
		action.dragAndDrop(Laptop, LaptopAccessories).perform();
		action.dragAndDrop(LaptopCover, LaptopAccessories).perform();
	}
}
