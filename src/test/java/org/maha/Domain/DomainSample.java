package org.maha.Domain;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class DomainSample extends DomainBase {
	public static void main(String[] args) throws Throwable {
		
		launchBrowser();
		
		load("https://www.alternativeairlines.com/air-berlin");
		 Thread.sleep(2000);
		
		 WebElement from = driver.findElement(By.xpath("//input[@id='flight-search-departure-input']"));
		 from.click();
		 from.sendKeys("sha");
		 Actions acc=new Actions(driver);
		 Thread.sleep(2000);
		 WebElement source = driver.findElement(By.xpath("//div[text()='Shanghai - Shanghai Hongqiao International']"));
		 acc.moveToElement(source).perform();
		 source.click();
		 
		 WebElement to = driver.findElement(By.xpath("//input[@id='flight-search-arrival-input']"));
		 to.click();
		 to.sendKeys("Ber");
		 
		 Thread.sleep(2000);
		 WebElement to1 = driver.findElement(By.xpath("//div[@class='autocomplete-suggestion autocomplete-selected']"));
		 acc.moveToElement(to1).perform();
		//JavascriptExecutor jk=(JavascriptExecutor)driver;
		//  jk.executeScript("arguments[0].click()",to1);
		 to1.click();
		 
		 
		 
		 
		

	     WebElement date = driver.findElement(By.xpath("(//input[@name='departureDate'])[1]"));
	    	btnclick(date);	 
	    	Thread.sleep(2000);
	    	
	    	WebElement dateselect = driver.findElement(By.xpath("(//span[@class='day-cell'])[4]"));
	    	
	    	btnclick(dateselect);	
	    	WebElement returnDate = driver.findElement(By.xpath("(//input[@name='returnDate'])[1]"));
		    	btnclick(returnDate);	
		    	
		    	Thread.sleep(5000);
		    	WebElement returndateselect = driver.findElement(By.xpath("(//span[@class='day-cell'])[27]"));
		    	JavascriptExecutor jk=(JavascriptExecutor)driver;
				  jk.executeScript("arguments[0].click()",returndateselect);
		    	
		    	//btnclick(returndateselect);
		    	Thread.sleep(2000);
		    	WebElement cabinclass = driver.findElement(By.xpath("//input[@class='search-form__field']"));
		    	btnclick(cabinclass);	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
	}}