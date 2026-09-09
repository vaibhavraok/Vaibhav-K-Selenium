package Assessment3;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestCase1 {

	public static void main(String[] args) throws Throwable{
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.easemytrip.com/");
		
		driver.findElement(By.id("FromSector_show")).click();
		driver.findElement(By.id("a_FromSector_show")).sendKeys("Bangalore");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Bengaluru(BLR)']")).click();
		
		
		driver.findElement(By.id("ptt")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("a_Editbox13_show")).sendKeys("Delhi");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='New Delhi(DEL)']")).click();
		
//		driver.findElement(By.xpath("//p[text()='  Departure Date']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@id=\"snd_6_12/09/2026\"]")).click();
		
//		driver.findElement(By.xpath("//p[text()='  Return Date']").click();
//		driver.findElement(By.id("//li[@id=\"trd_4_17/09/2026")).click();
		
		driver.findElement(By.id("spnTraveller")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("add")).click();
		driver.findElement(By.xpath("//span[@id='spanEconomy']")).click();
		
		driver.findElement(By.xpath("//a[text()='  Done']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value=\"Search\"]")).click();
		
		Thread.sleep(2000);
		@Nullable
		String url = driver.getCurrentUrl();
		if(url.contains("flight-search")){
				System.out.println("flight-results page is displayed");
		}
		else {
			System.out.println("flight-results page is not displayed");
		}
		driver.quit();
		

	}

}
