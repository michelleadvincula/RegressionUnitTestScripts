package UnitTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;

public class GetLastBRDate {
	public void getBRDate(WebDriver driver) throws InterruptedException{
		CommonFunctions cf = new CommonFunctions();
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
		String mo1 = cf.element(driver,"(.//*[@class='pika-label-month'])[2]").getText();
		if(mo1.equals(month2))
		{
			break;
		}
		else
		{
			cf.clickOnElementJS(driver, "(.//*[@class='pika-next'])[2]");
		}
		}
		cf.clickOnElementJS(driver, "//div[1]//div//div//div//div[5]//div[3]//div//table[1]//tbody[1]//tr//td/button[contains(text(),"+day2+")]");
		Thread.sleep(5000);
		cf.clickOnElementJS(driver,"(.//button[@class='appmagic-datepicker-ok-button'])[2]");
		
	}
}	