package Assessment2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver d = new ChromeDriver();
		//maximize the window
		d.manage().window().maximize();
		//implicit wait
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//launch the browser
		d.get("https://www.facebook.com/");
		Thread.sleep(2000);
		//click the create button
		d.findElement(By.xpath("(//span[@class='x1lliihq x193iq5w x6ikm8r x10wlt62 xlyipyv xuxw1ft'])[3]")).click();
		Thread.sleep(2000);
		//locate the WebElements
		WebElement firstname = d.findElement(By.id("_R_1cl2p4jikacppb6amH1_"));
		WebElement lastname = d.findElement(By.id("_R_1kl2p4jikacppb6amH1_"));
		//get x and y coordinates
		int fnx = firstname.getLocation().getX();
		System.out.println(fnx);
		int lnx = lastname.getLocation().getX();
		System.out.println(lnx);
		int fny = firstname.getLocation().getY();
		System.out.println(fny);
		int lny = lastname.getLocation().getY();
		System.out.println(lny);
		//verify
		if(fny==lny)
			System.out.println("Are aligned in the same line");
		else
			System.out.println("Not aligned in the same line");
		//close the browser
		d.quit();
	}
}