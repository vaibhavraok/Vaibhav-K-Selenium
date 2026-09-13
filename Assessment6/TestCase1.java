package Assessment6;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase1 {

	public static void main(String[] args) throws InterruptedException, IOException {
		FileInputStream fis = new FileInputStream("src/main/resources/Assessment6_Data/common_data.properties");
		Properties p = new Properties();
		p.load(fis);
		String Browser = p.getProperty("browser");
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		
		FileInputStream t = new FileInputStream("src/main/resources/Assessment6_Data/Testing_Data.xlsx");
		Workbook wb = WorkbookFactory.create(t);
		String firstname = wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
		String middlename = wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
		String lastname = wb.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
		String empid = wb.getSheet("Sheet1").getRow(1).getCell(3).getStringCellValue();
		String username = wb.getSheet("Sheet1").getRow(1).getCell(4).getStringCellValue();
		String password = wb.getSheet("Sheet1").getRow(1).getCell(5).getStringCellValue();
		
		WebDriver driver = null;
		if(Browser.equals("chrome")) {
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		driver.findElement(By.name("username")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("// button[@type='submit']")).click();
		// Avoid Change Password popup
//				ChromeOptions settings = new ChromeOptions();
//				Map<String, Object> prefs = new HashMap<>();
//				prefs.put("profile.password_manager_leak_detection", false);
//				settings.setExperimentalOption("prefs", prefs);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='button']")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("firstName")).sendKeys(firstname);
		driver.findElement(By.name("middleName")).sendKeys(middlename);
		driver.findElement(By.name("lastName")).sendKeys(lastname);
		driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--active']")).sendKeys(empid);
		driver.findElement(By.xpath("//span[@class='oxd-switch-input oxd-switch-input--active --label-right']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[3]")).sendKeys(username,Keys.TAB,Keys.TAB,Keys.TAB,password);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

}
