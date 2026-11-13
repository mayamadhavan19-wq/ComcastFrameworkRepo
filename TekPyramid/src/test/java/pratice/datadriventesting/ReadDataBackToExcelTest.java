package pratice.datadriventesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataBackToExcelTest {
   public static void main(String[] args) throws Throwable {
	FileInputStream fis = new FileInputStream("C:\\Users\\Sathishkumar\\Desktop\\Tekpyramid\\testscriptdata.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet("org");
	Row row = sh.getRow(1);
	Cell cel = row.createCell(4);
	cel.setCellType(CellType.STRING);
	cel.setCellValue("PASS");
	FileOutputStream fos = new FileOutputStream("C:\\Users\\Sathishkumar\\Desktop\\Tekpyramid\\testscriptdata.xlsx");
	wb.write(fos);
	wb.close();
	System.err.println("====Executed====");
}
}