package UnitTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.WebDriver;

public class GetLastMedDate {

	public void getCurrent(WebDriver driver){
		CommonFunctions cf = new CommonFunctions();
//Create object of SimpleDateFormat class and decide the format
		DateFormat MonthFormat = new SimpleDateFormat("MMMM");
		DateFormat DayFormat = new SimpleDateFormat("dd");
		
		//get current date time with Date()
		Date date = new Date();
		 
		 //Format the date
		
		 String month = MonthFormat.format(date);
		 String day = DayFormat.format(date);
		 
		 //Get Current data for Last medical appraisal date:
		 while(true)
		 {
		String mo = cf.element(driver,".//*[@class='pika-label-month']").getText();
		if(mo.equals(month))
		{
			break;
		}
		else
		{
			cf.clickOnElementJS(driver, ".//*[@class='pika-next']");
		}
		}
		cf.clickOnElementJS(driver, "//div[1]//div//div//div//div[5]//div[2]//div//table[1]//tbody[1]//tr//td/button[contains(text(),"+day+")]");
		cf.clickOnElementJS(driver,"(.//button[@class='appmagic-datepicker-ok-button'])");
		
	}
}	
