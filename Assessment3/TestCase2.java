package Assessment3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase2 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/ui/datePick?sublist=0");
		driver.findElement(By.xpath("//input[@type=\"text\"]")).click();
		driver.findElement(By.xpath("//span[@class='react-datepicker__navigation-icon react-datepicker__navigation-icon--next']"));
		driver.findElement(By.xpath("//div[text()='1']")).click();
		WebElement date = driver.findElement(By.xpath("//input[@value='01/10/2026']"));
		if(date.toString().contains("01")) {
			System.out.println("selected date is displayed correctly");
		}
		else {
			System.out.println("selected date is not displayed correctly");
		}
	}

}
