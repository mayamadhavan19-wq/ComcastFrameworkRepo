package pratice.datadriventesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataBasedConditionTest {
   public static void main(String[] args) throws Throwable {
	String expectedTestID = "tc_02";
	
	FileInputStream fis = new FileInputStream("C:\\Users\\Sathishkumar\\Desktop\\Tekpyramid\\testscriptdata.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet("org");
	int rowCount = sh.getLastRowNum();
	for(int i=0;i<=rowCount;i++) {
		String data ="";
		try {
			data = sh.getRow(i).getCell(0).toString();
		}catch(Exception e) {}
		System.out.println(data);
	}
	wb.close();
}
}