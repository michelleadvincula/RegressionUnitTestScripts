package UnitTest;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class SubmitNewReviewAllYes {
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
			driver.get(baseUrl);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	} 
	
	
	@Test(priority=1)
	  public void TestSubmitNewReview() throws InterruptedException {
		CommonFunctions cf = new CommonFunctions();
		SwitchCurrentWindow sc = new SwitchCurrentWindow();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
//Call GetNewWindow method
			sc.GetNewWindow(driver);
			Thread.sleep(8000);
//Enter email
				cf.element(driver,"//input[@id='i0116']").sendKeys("testuser1@ccbmidev.onmicrosoft.com");
				cf.clickOnElement(driver, "//input[@id='idSIButton9']");

//Call GetNewWindow method
				sc.GetNewWindow(driver);
				Thread.sleep(8000);
//Enter password			
				cf.element(driver,"//input[@id='i0118']").sendKeys("Dag02587");
				cf.clickOnElement(driver,"//input[@id='idSIButton9']");
//Select Yes to Stay Signed In window
//Call GetNewWindow method
				sc.GetNewWindow(driver);
				Thread.sleep(8000);	
				cf.clickOnElement(driver,"//input[@id='idSIButton9']");
				Thread.sleep(10000);	
//Switch to iframe
				driver.findElement(By.id("adalRenewFramehttps://service.powerapps.com/"));
			    driver.switchTo().frame(0);
//Click Create a new review button
			    cf.clickOnElementJS(driver, "//div[@data-container-name='cmp_LeftMenu_7-container']|//div[@data-control-id='12']");
			    cf.clickOnElement(driver, "//div[@data-container-name='cmp_LeftMenu_7-container']|//div[@data-control-id='12']");
//Select Hospital
				cf.clickOnElementByID(driver,"react-combobox-view-0");
				cf.clickOnElement(driver,"//li[@data-index='0']");
//Select Consultant
				//Find Text element
				cf.element(driver, "(.//*[@class[contains(.,'react-combobox-view container')]])[2]/div[1]").click();
				Thread.sleep(5000);
				cf.element(driver,"(.//*[@placeholder='Select a consultant'])").clear();
				cf.element(driver,"(.//*[@placeholder='Select a consultant'])").sendKeys("john");	
//Click John Aspland in the Search List	
				cf.element(driver, ".//span[text()='John Aspland']").click();
				Thread.sleep(5000);
//Click Begin button
				try {
					cf.clickOnElementJS(driver, "//div[text()='Begin']");
				} catch (ElementClickInterceptedException ignore) {
				
				}
			    
			    //
//Enter Contact Number
				cf.element(driver, "(.//*[text()[contains(.,'Contact number')]]//following::*[@type='text'])[1]").sendKeys("123456789000");	    
//Select Current PP Status
				cf.clickOnElementByID(driver,"react-combobox-view-2");
				driver.findElement(By.xpath("//li[@data-index='0']")).click();	
//Select Prof Reg Body
				cf.clickOnElementByID(driver, "react-combobox-view-3");
				cf.clickOnElement(driver,"//li[@data-index='0']");
//Enter GMC Number
				cf.element(driver, "(.//*[text()[contains(.,'GMC number')]]//following::*[@type='text'])[1]").sendKeys("7777777");
//Select Designated body
				cf.clickOnElementByID(driver,"react-combobox-view-4");
				cf.clickOnElement(driver,"//li[@data-index='0']");
//Enter Responsible officer
				cf.element(driver,"(.//*[text()[contains(.,'Responsible officer:')]]//following::*[@type='text'])[1]").sendKeys("Jack Responsible");								
//Click Standard data check compliance
				cf.clickOnElement(driver,"//div[@data-control-name='ico_StandardData']");
//Select Last medical appraisal date
				
				cf.clickOnElement(driver, "//div[@data-control-name='date_LastAppraisalDate']");
				cf.clickOnElementJS(driver, "(.//button[@class='pika-button pika-day'])[3]");
				cf.clickOnElementJS(driver,"(.//button[@class='appmagic-datepicker-ok-button'])");
//Check PDP
				cf.clickOnElement(driver, "(.//div[@class='appmagic-checkbox-placeholder'])[2]");
//Enter Notes
				cf.element(driver,"(.//*[@class[contains(.,'appmagic-textarea mousetrap')]])[2]").sendKeys("This is an automation test note");
//Select Date of last biennial review
				cf.clickOnElement(driver, "//div[@data-control-name='date_LastReviewDate']");
				cf.clickOnElementJS(driver, "(.//button[@class='pika-button pika-day'])[34]");
				cf.clickOnElementJS(driver,"(.//button[@class='appmagic-datepicker-ok-button'])[2]");
//Check Prof.body.reg
				cf.clickOnElement(driver, "(.//div[@class='appmagic-checkbox-placeholder'])[2]");
//Enter Submission to national registries
				cf.element(driver,"(.//*[@class[contains(.,'appmagic-textarea mousetrap')]])[2]").sendKeys("This is an automated Submission to national registries");
//Click Scope of practice
				cf.clickOnElement(driver,"//div[@data-control-name='ico_ScopeOfPractice']");
//Enter Scope of Practice
				cf.element(driver,"(.//*[@class[contains(.,'appmagic-textarea mousetrap')]])[4]").sendKeys("This scope of practice is an automated message");
				
//Choose Yes Is any part of the scope of practice only undertaken in the private sector?
				cf.clickOnElement(driver, "(.//div[@class='appmagic-checkbox-placeholder'])[8]");
//Enter Private sector details
				cf.element(driver, "(.//*[@class[contains(.,'appmagic-textarea mousetrap')]])[5]").sendKeys("This Private sector is an automated message");
//Enter  Please specify details of how competence is maintained
				cf.element(driver, "(.//*[@class[contains(.,'appmagic-textarea mousetrap')]])[6]").sendKeys("This maintenance instruction is an automated message");
//Enter Number of complaints
				cf.element(driver, "(.//*[@class[contains(.,'appmagic-text mousetrap')]])[7]").sendKeys("1");
//Enter Infection rate
				cf.element(driver, "(.//*[@class[contains(.,'appmagic-text mousetrap')]])[8]").sendKeys("2");
//Enter Unexpected deaths
				cf.element(driver, "(.//*[@class[contains(.,'appmagic-text mousetrap')]])[9]").sendKeys("3");
//Enter Unplanned transfers		
				cf.element(driver, "(.//*[@class[contains(.,'appmagic-text mousetrap')]])[10]").sendKeys("4");
//Enter VTE incidents % of patients
				cf.element(driver, "(.//*[@class[contains(.,'appmagic-text mousetrap')]])[11]").sendKeys("5");
//Enter Returns to theatre
				cf.element(driver, "(.//*[@class[contains(.,'appmagic-text mousetrap')]])[12]").sendKeys("6");
//Enter Readmission
				cf.element(driver, "(.//*[@class[contains(.,'appmagic-text mousetrap')]])[13]").sendKeys("7");
//Enter Never events
				cf.element(driver, "(.//*[@class[contains(.,'appmagic-text mousetrap')]])[14]").sendKeys("8");
//Choose Yes Is all mandatory training completed?
				cf.clickOnElement(driver, "(.//div[@class='appmagic-checkbox-placeholder'])[11]");
//Choose Yes New procedures
				cf.clickOnElement(driver, "(.//div[@class='appmagic-checkbox-placeholder'])[13]");
//Enter Please provide details below
				cf.element(driver, "(.//*[@class[contains(.,'appmagic-textarea mousetrap')]])[8]").sendKeys("This procedure is automated");
//Click Summary and Discussion
				cf.clickOnElement(driver, "//div[@data-control-name='ico_Summary']");
//Enter More Details
				cf.element(driver, "(.//*[@class[contains(.,'appmagic-textarea mousetrap')]])[9]").sendKeys("This is an automated message");
//Click Incidents, events, and complaints
				cf.clickOnElement(driver, "//div[@data-control-name='ico_Incidents']");
//Enter any review
				cf.element(driver, "(.//*[@class[contains(.,'appmagic-textarea mousetrap')]])[10]").sendKeys("This is an automated message");
//Click Concerns or changes
				cf.clickOnElement(driver, "//div[@data-control-name='ico_Concerns']");
//Choose Yes Are there any concerns  or changes to practice in other hospitals where the doctor works?
				cf.clickOnElement(driver, "(.//div[@class='appmagic-checkbox-placeholder'])[15]");
//Enter Please Provide details
				cf.element(driver, "(.//*[@class[contains(.,'appmagic-textarea mousetrap')]])[11]").sendKeys("This is an automated message");
//Choose Yes  Are there any concerns or changes to recognition from an insurer or commissioner?
				cf.clickOnElement(driver, "(.//div[@class='appmagic-checkbox-placeholder'])[17]");
//Enter Please Provide details
				cf.element(driver, "(.//*[@class[contains(.,'appmagic-textarea mousetrap')]])[12]").sendKeys("This is an automated message");
//Choose Yes Other concerns relating to the doctor's work; including those related to non-technical/soft skills such as situational awareness, coping with stress etc?
				cf.clickOnElement(driver, "(.//div[@class='appmagic-checkbox-placeholder'])[19]");
//Enter Please Provide details
				cf.element(driver, "(.//*[@class[contains(.,'appmagic-textarea mousetrap')]])[17]").sendKeys("This is an automated message");
//Click Behavior
				cf.clickOnElement(driver, "//div[@data-control-name='ico_Behaviour']");
//Choose Yes Are there any incidents or events relating to conduct or behaviour?
				cf.clickOnElement(driver, "(.//div[@class='appmagic-checkbox-placeholder'])[21]");
//Enter Please Provide details
				cf.element(driver, "(.//*[@class[contains(.,'appmagic-textarea mousetrap')]])[16]").sendKeys("This is an automated message");
//Click Feedback from the Practitioner
				cf.clickOnElement(driver, "//div[@data-control-name='ico_Feedback']");
//Enter Feedback
				cf.element(driver, "(.//*[@class[contains(.,'appmagic-textarea mousetrap')]])[13]").sendKeys("This is an automated message");
//Click BMI values
				cf.clickOnElement(driver, "//div[@data-control-name='ico_BMIValues']");
//Choose Yes The Practitioner is aware of the BMI Values
				cf.clickOnElement(driver, "(.//div[@class='appmagic-checkbox-placeholder'])[23]");
//Choose Yes The Practitioner has been provided with the latest PP policy and has access to all policies and procedures	
				cf.clickOnElement(driver, "(.//div[@class='appmagic-checkbox-placeholder'])[25]");
//Click Service development or commercial opportunities
				cf.clickOnElement(driver, "//div[@data-control-name='ico_ServiceDev']");
//Enter service details
				cf.element(driver, "(.//*[@class[contains(.,'appmagic-textarea mousetrap')]])[14]").sendKeys("This is an automated message");
//Click Sign off
				cf.clickOnElement(driver, "//div[@data-control-name='ico_SignOff']");
//Choose Yes Renewal of practicing privileges	
				cf.clickOnElement(driver, "(.//div[@class='appmagic-checkbox-placeholder'])[27]");

//Choose Yes Are there any elements of the Biennial review which require escalation to the Corporate Team?
				cf.clickOnElement(driver, "(.//div[@class='appmagic-checkbox-placeholder'])[29]");
//Enter Please provide details of the elements which require escalation
		cf.element(driver, "(.//*[@class[contains(.,'appmagic-textarea mousetrap')]])[15]").sendKeys("This automated message should display in the Escalation Email sent to an Admin email");		
//Click Submit
		cf.clickOnElement(driver, "//div[text()='Submit']");
//Click Completed dashboard list
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		cf.ActionOnElement(driver, "//div[text()='Completed']");
//Validate submitted review is displayed in Completed Dashboard
		String consultant = cf.element(driver, "(.//*[@class[contains(.,'appmagic-label-text')]])[21]").getText();
		String expected = "John Aspland";
		Assert.assertEquals(consultant, expected);
		String hospital =cf.element(driver, "(.//*[@class[contains(.,'appmagic-label-text')]])[23]").getText();
		String expected2 = "Circle Reading Hospital";
		Assert.assertEquals(hospital, expected2);
		System.out.println("Consultant is"+consultant);
		System.out.println("Hospital is"+hospital);
		driver.quit();
}
}

