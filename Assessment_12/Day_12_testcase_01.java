package Assessment_12;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import Assessment_12.BaseClass;
import Assessment12.pom.homepage;
import Assessment12.pom.myinfopage;
import org.apache.poi.ss.usermodel.DataFormatter;

public class Day_12_testcase_02 extends BaseClass {

	@Test(priority = 1)
	public void infoTest() throws EncryptedDocumentException, IOException, InterruptedException {
		//reading data from excel file
		FileInputStream file = new FileInputStream("./src/test/resources/Assessment12_data/Testcase2.xlsx");
		Workbook wb = WorkbookFactory.create(file);
		Sheet sh = wb.getSheet("Sheet2");
		Row row = sh.getRow(1);
		DataFormatter df = new DataFormatter();
		String fN = row.getCell(0).getStringCellValue();
		String lN = row.getCell(1).getStringCellValue();
		String EId = df.formatCellValue(row.getCell(2));
		
		// object creation for home page
		homepage h = new homepage(d);
		//click my info
		h.getInfoLink();
		
		// object creation for my info page
		myinfopage m = new myinfopage(d);
		Thread.sleep(2000);
		//first name
		m.getFN(fN);
		Thread.sleep(2000);
		//last name
		m.getLN(lN);
		Thread.sleep(2000);
		//employee id
		m.getEId(EId);
		Thread.sleep(2000);
		//click save
		m.getSavebtn();
		
	}
	
	@Test(priority = 2, dependsOnMethods = "infoTest")
	public void verify() throws InterruptedException {
		
		// object creation for home page
		homepage h = new homepage(d);
		//click my info
		h.getInfoLink();
		
		// object creation for my info page
		myinfopage m = new myinfopage(d);
		
		//printing details
		Thread.sleep(2000);
		System.out.println("First Name: " + m.verifyFN());
	    System.out.println("Last Name: " + m.verifyLN());
	    System.out.println("Employee ID: " + m.verifyEId());
	    
	    Thread.sleep(2000);
	    
	    //verifying using assert 
		Assert.assertEquals(m.verifyFN(), "Vaibhav");
		Thread.sleep(1000);
		Assert.assertEquals(m.verifyLN(), "K");
		Thread.sleep(1000);
		Assert.assertEquals(m.verifyEId(), "107");
		Thread.sleep(1000);
		System.out.println("Record Found");
	}
	
}
