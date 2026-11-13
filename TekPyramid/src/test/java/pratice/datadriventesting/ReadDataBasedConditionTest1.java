package pratice.datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataBasedConditionTest1 {
    public static void main(String[] args) throws Throwable, IOException {
		String expectedTestID = "tc_02";
		String data1 = "";
		String data2 = "";
		String data3 = "";
		
		FileInputStream fis = new FileInputStream("C:\\Users\\Sathishkumar\\Desktop\\Tekpyramid\\testscriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("org");
		int rowCount = sh.getLastRowNum();
		for(int i=0;i<=rowCount;i++) {
			String data = "";
			try {
				data = sh.getRow(i).getCell(0).toString();
				if(data.equals(expectedTestID)) {
					data1 = sh.getRow(i).getCell(1).toString();
					data2 = sh.getRow(i).getCell(2).toString();
					data3 = sh.getRow(i).getCell(3).toString();
				}
			}catch(Exception e) {
				System.out.println(data1);
				System.out.println(data2);
				System.out.println(data3);
			}
		}
		wb.close();
		
	}
}