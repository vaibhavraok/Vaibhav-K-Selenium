package final_Advance_Assessment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import junit.framework.Assert;
import orange_HRM.BaseClass;
import orange_HRM.buzz;
import orange_HRM.homepage;

public class Assesement_2_orange extends BaseClass{

	@Test
	public void orangeHRM() throws InterruptedException, IOException {
	
		Thread.sleep(2000);
		homepage h = new homepage(d);
		//click buzz link
		h.getBuzzlink();
		Thread.sleep(2000);
				
		buzz b = new buzz(d);
		//pass the text to post
		b.getTextfield();
		Thread.sleep(3000);
		//click on post
		b.getPostbtn();
		System.out.println("posted");
		Thread.sleep(4000);
		//verify it is posted or not
		System.out.println(b.getVerify());
		Assert.assertTrue(b.getVerify());
		System.out.println("posted and verified");
	}
}
