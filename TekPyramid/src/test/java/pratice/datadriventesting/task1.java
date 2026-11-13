package pratice.datadriventesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class task1 {
    public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[@role='button']")).click();
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("mobiles");

        driver.findElement(By.className("XFwMiH")).click();

        Thread.sleep(3000);

        
        List<WebElement> mobiles = driver.findElements(
                By.xpath("//div[@class='RG5Slk']"));
        
//        for(int i=0;i<mobiles.size();i++) {
//        	WebElement mobile = mobiles.get(i);
//        	String name = mobile.getText();
//        	System.out.println(name);
//        }
        
        writeDataInExcel(mobiles);
        
	}

	private static void writeDataInExcel(List<WebElement> mobiles) throws Throwable  {
		FileInputStream fis = new FileInputStream("C:\\Users\\Sathishkumar\\Desktop\\Tekpyramid\\task.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("sheet1");
		for (int i = 0; i < mobiles.size(); i++) {

		    Row row = sh.createRow(i + 1);

		    Cell cel = row.createCell(0);

		    cel.setCellValue(mobiles.get(i).getText());
		}
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Sathishkumar\\Desktop\\Tekpyramid\\task.xlsx");
		wb.write(fos);
		wb.close();
		
		
		
	}
}