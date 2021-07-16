package UnitTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class GetLastBRDate extends CommonFunctions{
	public void getBRDate(WebDriver driver) throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver,90);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		//CommonFunctionsXpathOnly cf = new CommonFunctionsXpathOnly();
//Create object of SimpleDateFormat class and decide the format
		DateFormat MonthFormat = new SimpleDateFormat("MMMM");
		DateFormat DayFormat = new SimpleDateFormat("dd");
		
		//get current date time with Date()
		Date date = new Date();
		 
		 //Format the date
		
		 String month2 = MonthFormat.format(date);
		 String day2 = DayFormat.format(date);
		 
		 //Get Current data for Last medical appraisal date:
		 while(true)
		 {
		String mo1 = driver.findElement(By.xpath("(.//*[@class='pika-label-month'])[2]")).getText();
		if(mo1.equals(month2))
		{
			break;
		}
		else
		{
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(.//*[@class='pika-next'])[2]")));
		executor.executeScript("arguments[0].click()", driver.findElement(By.xpath("(.//*[@class='pika-next'])[2]")));
		
		}
		}
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[1]//div//div//div//div[5]//div[3]//div//table//tbody//tr//td/button[contains(text(),"+day2+")]")));
		executor.executeScript("arguments[0].click()", driver.findElement(By.xpath("//div[1]//div//div//div//div[5]//div[3]//div//table//tbody//tr//td/button[contains(text(),"+day2+")]")));
			
		
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(.//button[@class='appmagic-datepicker-ok-button'])[2]")));
		executor.executeScript("arguments[0].click()", driver.findElement(By.xpath("(.//button[@class='appmagic-datepicker-ok-button'])[2]")));

	}
}	