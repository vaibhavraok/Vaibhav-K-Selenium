package Assessment_12;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import Assessment12.pom.loginpage;
import Assessment12.pom.logoutpage;


public class BaseClass {

	public WebDriver d;
	String browser;
	String Url;
	String un;
	String pw;
	
	@BeforeClass
	public void bc() throws IOException, InterruptedException {
		System.out.println("Open the browser");
		FileInputStream file = new FileInputStream("./src/test/resources/Assessment12_data/common_data.properties");
		Properties p = new Properties();
		p.load(file);
		browser = p.getProperty("browser");
		Url = p.getProperty("url");
		un = p.getProperty("username");
		pw = p.getProperty("password");
		
		Thread.sleep(3000);
		// Avoid Change Password popup
		ChromeOptions settings = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("profile.password_manager_leak_detection", false);
		settings.setExperimentalOption("prefs", prefs);
		Thread.sleep(2000);
		
		if(browser.equals("chrome"))
			d = new ChromeDriver(settings);
		if(browser.equals("edge"))
			d = new EdgeDriver();
		if(browser.equals("firefox"))
			d = new FirefoxDriver();
		
		d.manage().window().maximize();
		
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterClass
	public void ac() {
		System.out.println("close the browser");
		d.quit();
	}
	
	@BeforeMethod
	public void bm() throws InterruptedException {
		System.out.println("Login");
		d.get(Url);
		Thread.sleep(2000);
		loginpage l = new loginpage(d);
		//user name
		l.getUN(un);
		//password
		l.getPW(pw);
		Thread.sleep(2000);
		//login button
		l.getLoginbtn();
	}
	
	@AfterMethod
	public void am() throws InterruptedException {
		System.out.println("logout");
		logoutpage lo = new logoutpage(d);
		lo.getDd();
		Thread.sleep(2000);
		lo.getLogoutbtn();
	}

}