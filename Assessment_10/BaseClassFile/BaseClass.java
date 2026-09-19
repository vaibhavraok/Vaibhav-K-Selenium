package Assessment10;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

// This is BaseClass
public class BaseClass {
	WebDriver driver = null;
	protected Properties p = new Properties();
    @BeforeSuite
    public void Bs() {
        System.out.println("DataBase connectivity");
    }

    @AfterSuite
    public void As() {
        System.out.println("close - DataBase connectivity");
    }

    @BeforeTest
    public void Bt() {
        System.out.println("pre-conditions");
    }

    @AfterTest
    public void At() {
        System.out.println("post-conditions");
    }

    @BeforeClass
    public void setUp() throws IOException, InterruptedException {

        FileInputStream fis = new FileInputStream("./src/test/resources/Assessment10_data/config.properties");

        
        p.load(fis);

        String browser = p.getProperty("browser");

        if (browser.equals("chrome")) {
            driver = new ChromeDriver();
        }
        else if (browser.equals("edge")) {
            driver = new EdgeDriver();
        }
        else if (browser.equals("firefox")) {
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();

        driver.get(p.getProperty("url"));
        Thread.sleep(3000);
    }

    @AfterClass
    public void Ac() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
    
    @BeforeMethod
    public void Bm() {
    	
        System.out.println("Login done");
    }

    @AfterMethod
    public void Am() {
	    System.out.println("Logout Executed");
    }
}
