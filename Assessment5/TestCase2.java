package Assessment5;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase2 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		FileInputStream fis = new FileInputStream("./src/main/resources/Data/Data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		WebDriver driver = null;
		String Browser = wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
		String url = wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
		String username = wb.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
		String password = wb.getSheet("Sheet1").getRow(1).getCell(3).getStringCellValue();

		if(Browser.equals("chrome")) {
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")).click();
		Thread.sleep(4000);
		driver.quit();
	}

}
