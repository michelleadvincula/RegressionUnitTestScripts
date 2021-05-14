package UnitTest;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitNewReviewAllNo {
		//Dev environment
		public String baseUrl = "https://apps.powerapps.com/play/e7913a8e-0481-4d5d-ba5c-39d42c620097?tenantId=62551275-fac1-4caf-a2b6-2d9c7efcafba&source=portal&screenColor=rgba(1%2C%20131%2C%20134%2C%201)";
		String driverPath ="C:\\Program Files\\selenium\\chromedriver_win32\\chromedriver.exe";
		public static WebDriver driver;

		@BeforeTest
		public void openBrowser() {
				System.setProperty("webdriver.chrome.driver", driverPath);
				ChromeOptions opt = new ChromeOptions();
				opt.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
				opt.addArguments("--no-sandbox");
				opt.addArguments("start-maximized");
				opt.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
				opt.setExperimentalOption("useAutomationExtension", false);
				 WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(opt);
				driver.manage().deleteAllCookies();
				driver.get(baseUrl);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		} 
		
		
		@Test(priority=3)
		  public void TestSubmitNewReviewAllNo() throws InterruptedException {
			CommonFunctions cf = new CommonFunctions();
			GetLastMedDate gc = new GetLastMedDate();
			GetLastBRDate gb = new GetLastBRDate();
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
//Call GetNewWindow method
				cf.GetNewWindow(driver);
				Thread.sleep(8000);
//Enter email
					cf.SendKeys(driver,"//input[@id='i0116']","testuser1@ccbmidev.onmicrosoft.com");
					cf.clickOnElement(driver, "//input[@id='idSIButton9']");

//Call GetNewWindow method
					cf.GetNewWindow(driver);
					Thread.sleep(8000);
//Enter password			
					cf.SendKeys(driver,"//input[@id='i0118']","Dag02587");
					cf.clickOnElement(driver,"//input[@id='idSIButton9']");
//Select Yes to Stay Signed In window
//Call GetNewWindow method
					cf.GetNewWindow(driver);
					Thread.sleep(8000);	
					cf.clickOnElement(driver,"//input[@id='idSIButton9']");
					Thread.sleep(10000);	
//Switch to iframe
					driver.findElement(By.id("adalRenewFramehttps://service.powerapps.com/"));
				    driver.switchTo().frame(0);
//Click Create a new review button
				    cf.clickOnElementJS(driver, "//div[@data-container-name='cmp_LeftMenu']|//div[@data-control-id='12']");
				    cf.clickOnElement(driver, "//div[@data-container-name='cmp_LeftMenu']|//div[@data-control-id='12']");
//Select Hospital
					cf.clickOnElementByID(driver,"react-combobox-view-0");
					cf.clickOnElement(driver,"//li[@data-index='2']");
//Select Consultant
					//Find Text element
					cf.element(driver, "(.//*[@class[contains(.,'react-combobox-view container')]])[2]/div[1]").click();
					Thread.sleep(5000);
					cf.element(driver,"(.//*[@placeholder='Select a consultant'])").clear();
					cf.SendKeys(driver,"(.//*[@placeholder='Select a consultant'])","piotr");	
//Click Piotr Michalak in the Search List	
					cf.element(driver, ".//span[text()='Piotr Michalak']").click();
					Thread.sleep(5000);
//Click Begin button
					try {
						cf.clickOnElementJS(driver, "//div[text()='Begin']");
					} catch (ElementClickInterceptedException ignore) {
					
					}
				    
				   
//Enter Contact Number
					cf.element(driver, "(.//*[text()[contains(.,'Contact number')]]//following::*[@type='text'])[1]").sendKeys("123456789000");	    
//Select Current PP Status
					cf.clickOnElementByID(driver,"react-combobox-view-2");
					driver.findElement(By.xpath("//li[@data-index='0']")).click();	
//Select Prof Reg Body
					cf.clickOnElementByID(driver, "react-combobox-view-3");
					cf.clickOnElement(driver,"//li[@data-index='0']");
//Enter GMC Number
					cf.SendKeys(driver, "(.//*[text()[contains(.,'GMC number')]]//following::*[@type='text'])[1]","7777777");
//Select Designated body
					cf.clickOnElementByID(driver,"react-combobox-view-4");
					cf.clickOnElement(driver,"//li[@data-index='0']");
//Enter Responsible officer
					cf.SendKeys(driver,"(.//*[text()[contains(.,'Responsible officer:')]]//following::*[@type='text'])[1]","Jack Responsible");								
//Click Standard data check compliance
					cf.clickOnElement(driver,"//div[@data-control-name='ico_StandardData']");
//Select Last medical appraisal date
					
					cf.clickOnElement(driver, "//div[@data-control-name='date_LastAppraisalDate']");
					gc.getCurrent(driver);
//Check PDP
					cf.clickOnElement(driver, "(.//div[@class='appmagic-checkbox-placeholder'])[2]");
//Enter Notes
					cf.SendKeys(driver,"(.//*[@class[contains(.,'appmagic-textarea mousetrap')]])[2]","This is an automation test note");
//Select Date of last biennial review	
					cf.clickOnElement(driver, "//div[@data-control-name='date_LastReviewDate']");
					gb.getBRDate(driver);
//Check Prof.body.reg
					cf.clickOnElement(driver, "(.//div[@class='appmagic-checkbox-placeholder'])[2]");
//Enter Submission to national registries
					cf.SendKeys(driver,"(.//*[@class[contains(.,'appmagic-textarea mousetrap')]])[3]","This is an automated Submission to national registries");
//Click Scope of practice
					cf.clickOnElement(driver,"//div[@data-control-name='ico_ScopeOfPractice']");
//Enter Scope of Practice
					cf.SendKeys(driver,"(.//*[@class[contains(.,'appmagic-textarea mousetrap')]])[4]","This scope of practice is an automated message");		
//Choose No Is any part of the scope of practice only undertaken in the private sector?
					cf.clickOnElement(driver, "(.//div[@class='appmagic-checkbox-placeholder'])[9]");		
//Enter  Please specify details of how competence is maintained
					cf.SendKeys(driver, "(.//*[@class[contains(.,'appmagic-textarea mousetrap')]])[6]","This maintenance instruction is an automated message");
//Enter Number of complaints
					cf.SendKeys(driver, "(.//*[@class[contains(.,'appmagic-text mousetrap')]])[7]","1");
//Enter Infection rate
					cf.SendKeys(driver, "(.//*[@class[contains(.,'appmagic-text mousetrap')]])[8]","2");
//Enter Unexpected deaths
					cf.SendKeys(driver, "(.//*[@class[contains(.,'appmagic-text mousetrap')]])[9]","3");
//Enter Unplanned transfers		
					cf.SendKeys(driver, "(.//*[@class[contains(.,'appmagic-text mousetrap')]])[10]","4");
//Enter VTE incidents % of patients
					cf.SendKeys(driver, "(.//*[@class[contains(.,'appmagic-text mousetrap')]])[11]","5");
//Enter Returns to theatre
					cf.SendKeys(driver, "(.//*[@class[contains(.,'appmagic-text mousetrap')]])[12]","6");
//Enter Readmission
					cf.SendKeys(driver, "(.//*[@class[contains(.,'appmagic-text mousetrap')]])[13]","7");
//Enter Never events
					cf.SendKeys(driver, "(.//*[@class[contains(.,'appmagic-text mousetrap')]])[14]","8");		
//Scroll down
					cf.ScrollDown(driver, "(.//div[@class='appmagic-checkbox-placeholder'])[12]");
//Choose No Is all mandatory training completed?
					cf.clickOnElement(driver, "(.//div[@class='appmagic-checkbox-placeholder'])[12]");
//Enter Modules not completed
					cf.SendKeys(driver, "(.//*[@class[contains(.,'appmagic-textarea mousetrap')]])[7]","These are the modules 1 2 3");
//Choose No New procedures
					cf.clickOnElement(driver, "(.//div[@class='appmagic-checkbox-placeholder'])[14]");
//Click Summary and Discussion
					cf.clickOnElement(driver, "//div[@data-control-name='ico_Summary']");
//Enter More Details
					cf.SendKeys(driver, "(.//*[@class[contains(.,'appmagic-textarea mousetrap')]])[9]","This is an automated message");
//Click Incidents, events, and complaints
					cf.clickOnElement(driver, "//div[@data-control-name='ico_Incidents']");
//Enter any review
					cf.SendKeys(driver, "(.//*[@class[contains(.,'appmagic-textarea mousetrap')]])[10]","This is an automated message");
		
//Click Concerns or changes
					cf.clickOnElement(driver, "//div[@data-control-name='ico_Concerns']");
//Choose No Are there any concerns  or changes to practice in other hospitals where the doctor works?
					cf.clickOnElement(driver, "(.//div[@class='appmagic-checkbox-placeholder'])[16]");
//Choose No  Are there any concerns or changes to recognition from an insurer or commissioner?
					cf.clickOnElement(driver, "(.//div[@class='appmagic-checkbox-placeholder'])[18]");		
//Choose No Other concerns relating to the doctor's work; including those related to non-technical/soft skills such as situational awareness, coping with stress etc?
					cf.clickOnElement(driver, "(.//div[@class='appmagic-checkbox-placeholder'])[20]");	
//Click Behavior
					cf.clickOnElement(driver, "//div[@data-control-name='ico_Behaviour']");
//Choose No Are there any incidents or events relating to conduct or behaviour?
					cf.clickOnElement(driver, "(.//div[@class='appmagic-checkbox-placeholder'])[22]");
//Click Feedback from the Practitioner
					cf.clickOnElement(driver, "//div[@data-control-name='ico_Feedback']");
//Enter Feedback
					cf.SendKeys(driver, "(.//*[@class[contains(.,'appmagic-textarea mousetrap')]])[13]","This is an automated message");		
//Click BMI values
					cf.clickOnElement(driver, "//div[@data-control-name='ico_BMIValues']");
//Choose No The Practitioner is aware of the BMI Values
					cf.clickOnElement(driver, "(.//div[@class='appmagic-checkbox-placeholder'])[24]");	
//Choose No The Practitioner has been provided with the latest PP policy and has access to all policies and procedures	
					cf.clickOnElement(driver, "(.//div[@class='appmagic-checkbox-placeholder'])[26]");		
//Click Service development or commercial opportunities
					cf.clickOnElement(driver, "//div[@data-control-name='ico_ServiceDev']");
//Enter service details
					cf.SendKeys(driver, "(.//*[@class[contains(.,'appmagic-textarea mousetrap')]])[14]","This is an automated message");		
//Click Sign off
					cf.clickOnElement(driver, "//div[@data-control-name='ico_SignOff']");
//Choose No Renewal of practicing privileges	
					cf.clickOnElement(driver, "(.//div[@class='appmagic-checkbox-placeholder'])[28]");
//Choose No Are there any elements of the Biennial review which require escalation to the Corporate Team?
					cf.clickOnElement(driver, "(.//div[@class='appmagic-checkbox-placeholder'])[30]");		
//Click Submit
					cf.clickOnElement(driver, "//div[text()='Submit']");
//Click Completed dashboard list
					driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					cf.ActionOnElement(driver, "//div[text()='Completed']");
//Refresh list
					cf.clickOnElementJS(driver, "(.//*[@class[contains(.,'powerapps-icon no-focus-outline')]])[10]");
					Thread.sleep(10000);
//Validate submitted review is displayed in Completed Dashboard
					String consultant = cf.element(driver, "(.//*[@class[contains(.,'appmagic-label-text')]])[21]").getText();
					String expected = "Piotr Michalak";
					Assert.assertEquals(consultant, expected);
					String hospital =cf.element(driver, "(.//*[@class[contains(.,'appmagic-label-text')]])[23]").getText();
					String expected2 = "The Park Hospital";
					Assert.assertEquals(hospital, expected2);
					System.out.println("Consultant is "+consultant);
					System.out.println("Hospital is "+hospital);
					driver.quit();
		}
}