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
import utility.ExcelUtility;
public class Assesement_2_orange extends BaseClass{

	@Test
	public void orangeHRM() throws IOException, InterruptedException {

    homepage h = new homepage(d);

    // click Buzz
    h.getBuzz();

    Thread.sleep(2000);

    buzz b = new buzz(d);

    // get data from Excel
    String data = ExcelUtility.getData("Sheet1", 1, 0);

    // enter data
    b.getEnterdata(data);

    // click Post
    b.getPost();

    Thread.sleep(3000);

    // verify Recent Post
    b.verify(data);

    System.out.println("posted and verified");
}
}
