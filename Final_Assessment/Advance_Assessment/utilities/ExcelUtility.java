package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

    public static String getData(String sheetName, int rowNum, int cellNum) throws IOException {

        FileInputStream fis = new FileInputStream("./src/test/resources/DDT/data_OHRM.xlsx");

        Workbook wb = WorkbookFactory.create(fis);

        Sheet sh = wb.getSheet(sheetName);

        Row row = sh.getRow(rowNum);

        String data = row.getCell(cellNum).getStringCellValue();

        wb.close();
        fis.close();

        return data;
    }
}
