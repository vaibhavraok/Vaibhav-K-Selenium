package Assessments.LastDayTask2.utilities;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtility {
    public static String getData(int row,int cell) throws IOException {
        FileInputStream file=new FileInputStream("src/test/java/Assessments/LastDayTask2/resources/Mind.xlsx");
        Workbook wb= WorkbookFactory.create(file);
        DataFormatter dataFormatter=new DataFormatter();
        return dataFormatter.formatCellValue(wb.getSheet("Sheet1").getRow(row).getCell(cell));
    }
}
