package Assessment5;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase3 {

	public static void main(String[] args) throws IOException, ParseException, InterruptedException {
		FileReader fis = new FileReader("./src/main/resources/Data/Data.json");
		JSONParser j = new JSONParser();
		Object obj = j.parse(fis);
		JSONObject json = (JSONObject)obj;
		String Browser = json.get("browser").toString();
		String url = json.get("url").toString();
		String email = json.get("email").toString();
		String password = json.get("password").toString();
		WebDriver driver = null;
		
		if(Browser.equals("chrome")) {
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("password")).sendKeys(password);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

}
