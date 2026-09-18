package Assessment10;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public static String getData(String sheetName, int row, int column) throws IOException {

	    FileInputStream fis = new FileInputStream("./src/test/resources/Assessment10_data/TestData.xlsx");

	    Workbook workbook = WorkbookFactory.create(fis);

	    String data = workbook.getSheet(sheetName).getRow(row).getCell(column).toString();

	    workbook.close();
	    fis.close();

	    return data;
	}
}
