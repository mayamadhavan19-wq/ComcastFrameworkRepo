package pratice.datadriventesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipledataUsinggetLastRowNum {
   public static void main(String[] args) throws Throwable {
	FileInputStream fis = new FileInputStream("C:\\Users\\Sathishkumar\\Desktop\\Tekpyramid\\sheet1.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet("sheet1");
	
	int rowcount = sh.getLastRowNum();
	for(int i=1;i<=rowcount;i++) {
		Row row = sh.getRow(i);
		String column1Data = row.getCell(0).toString();
		String column2Data = row.getCell(1).toString();
		System.out.println(column1Data+"\t"+column2Data);
	}
	wb.close();
}
}