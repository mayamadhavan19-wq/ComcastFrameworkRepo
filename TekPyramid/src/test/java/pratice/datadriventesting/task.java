package pratice.datadriventesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class task {

    public static void main(String[] args) throws Throwable {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("https://www.flipkart.com/");

        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[@role='button']")).click();
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("mobiles");

        driver.findElement(By.className("XFwMiH")).click();

        Thread.sleep(3000);

        
        List<WebElement> mobiles = driver.findElements(
                By.xpath("//div[@class='RG5Slk']"));

        System.out.println("Mobile count = " + mobiles.size());

        

        
        writeDataInExcel(mobiles);

        driver.quit();
    }

    private static void writeDataInExcel(List<WebElement> mobiles) {

        String path ="C:\\Users\\Sathishkumar\\Desktop\\Tekpyramid\\mobiles.xlsx";

        try {

            FileInputStream f1 = new FileInputStream(path);

            Workbook book = WorkbookFactory.create(f1);

           
            Sheet sh;

            if (book.getSheet("sheet1") != null) {
                sh = book.getSheet("sheet1");

                
                for (int i = sh.getLastRowNum(); i >= 0; i--) {
                    Row row = sh.getRow(i);

                    if (row != null) {
                        sh.removeRow(row);
                    }
                }

            } else {
                sh = book.createSheet("sheet1");
            }

            
            Row firstrow = sh.createRow(0);
            firstrow.createCell(0).setCellValue("Mobile Names");

            
            for (int i = 0; i < mobiles.size(); i++) {

                Row row = sh.createRow(i + 1);

                row.createCell(0).setCellValue(
                        mobiles.get(i).getText()
                );
            }
            FileOutputStream f2 = new FileOutputStream(path);

            book.write(f2);

            f2.close();
            f1.close();
            book.close();

            System.out.println("Data successfully written into Excel.");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}