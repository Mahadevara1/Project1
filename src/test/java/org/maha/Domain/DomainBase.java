package org.maha.Domain;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DomainBase {

	
			 public static WebDriver driver;
		
		public static WebDriver launchBrowser() {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\Today\\drivers\\chromedriver.exe");
			driver= new ChromeDriver();
			driver.manage().window().maximize();
			return driver;
			}
		public static void load( String url) {
			driver.get(url);
			}
		public static void fill(WebElement e, String s) {
			e.sendKeys(s);

		}
		public static void btnclick(WebElement e) {
			e.click();

		}
		public static void quitBrowser() {
			driver.quit();

		}
		
		public static String getData(int rowNo,int cellNo) throws Throwable  {
			String name = null;
			File loc = new File("C:\\Users\\HP\\eclipse-workspace\\Domain\\teadtData\\Domain.xlsx");
			FileInputStream s=new FileInputStream(loc);
			Workbook w= new XSSFWorkbook(s);
			Sheet s1 = w.getSheet("Sheet1");
			Row r= s1.getRow(rowNo);
			Cell c = r.getCell(cellNo);
			int type = c.getCellType();
			
			
			if(type==1) {
				name  = c.getStringCellValue();
			}
			
		
			
			else if	(type==0) {
				if(DateUtil.isCellDateFormatted(c)) {
					Date dateCellValue = c.getDateCellValue();
					SimpleDateFormat sim=new SimpleDateFormat("dd-MMM-yy");
					name=sim.format(dateCellValue);
					
				}
				else {
					double numericCellValue = c.getNumericCellValue();
					long l=(long)numericCellValue;
					name=String.valueOf(l);
				}
					
			}
			 return name;
		}
			
			 public static void screen(String path) throws IOException {
				 TakesScreenshot tk = (TakesScreenshot)driver;
				 File s = tk.getScreenshotAs(OutputType.FILE);
				 File f= new File(path);
				 FileUtils.copyFile(s,f);
				 
				   
				  }
			
	               
	               
			
			
			
			
			
		}
		

		
		
		
		
		
		
	
	