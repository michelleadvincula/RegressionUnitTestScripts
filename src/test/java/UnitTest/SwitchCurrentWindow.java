package UnitTest;

import org.openqa.selenium.WebDriver;

public class SwitchCurrentWindow {
public void GetNewWindow(WebDriver driver) {
	
	for (String windowName : driver.getWindowHandles()) {
		   driver.switchTo().window(windowName);
	   		} 
}
}