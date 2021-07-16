package UnitTest;

import java.io.IOException;


import org.openqa.selenium.By;

import org.testng.Assert;

import org.testng.annotations.Test;


public class AddDelegate extends CommonFunctions{
	
	@Test(priority=1)
	  public void TestAddDelegate() throws InterruptedException, IOException {
		invokeChromeBrowser("chrome");
		//CommonFunctions cf = new CommonFunctions();
		
//Call GetNewWindow method
			GetNewWindow(driver);
			Thread.sleep(8000);
			
//Call GetNewWindow method
				GetNewWindow(driver);
				Thread.sleep(8000);
//Enter email
				SendKeys("email","Penny.Baker@circlehgdev.com");
				clickOnElement("ClickEmail");

//Call GetNewWindow method
				GetNewWindow(driver);
				Thread.sleep(8000);
//Enter password			
				SendKeys("password","Gumu4304");
				clickOnElement("ClickPassword");

				//Select Yes to Stay Signed In window
//Call GetNewWindow method
				GetNewWindow(driver);
				Thread.sleep(8000);
				clickOnElement("StaySignedIn");
				Thread.sleep(10000);	
//Switch to iframe
				driver.findElement(By.id("adalRenewFramehttps://service.powerapps.com/"));
			   driver.switchTo().frame(0);
//Click Manage Delegate on the menu
			   clickOnElementJS("ManageDelegateButton");
			    clickOnElement("ManageDelegateButton");
	 
//Select Hospital
				//clickOnElementByID("SelectHospitalComboBxMD");
				//clickOnElement("SelectHospitalListitemMD");
				//Hospital selection defaulted to Kings Oak
//Select Delegate
				//Find Text element
				clickOnElement("SelectConsultantComboBxMD");
				Thread.sleep(5000);
				element("SelectConsultantClearMD").clear();
				SendKeys("SelectConsultantTextMD", "akash");
				//cf.element(driver, "(.//*[@placeholder='Type a name'])").sendKeys("akash");
		
		//Click Akash Jadhav in the Search List	
				
				clickOnElement("ClickConsultantTextMD");
//Click Save button
				clickOnElement("SaveButtonMD");
//Click OK pop up message
				clickOnElement("MDOKButton");
//Validate selected delegate is displayed in the Delegates panel
	String message = driver.findElement(By.xpath("//div[@data-control-name='Title1']//descendant::div[5]")).getText();
			String expected ="The Kings Oak Hospital | Penny Baker | Akash Jadhav";
			Assert.assertEquals(message, expected);
			System.out.println(message);
				
	driver.quit();
	}}
