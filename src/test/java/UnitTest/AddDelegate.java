package UnitTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddDelegate {
	//DEV Environment
	public String baseUrl = "https://apps.powerapps.com/play/e7913a8e-0481-4d5d-ba5c-39d42c620097?tenantId=62551275-fac1-4caf-a2b6-2d9c7efcafba&source=portal&screenColor=rgba(1%2C%20131%2C%20134%2C%201)";
	String driverPath = "C:/Program Files/selenium/chromedriver_win32_new/chromedriver.exe";
	public static WebDriver driver;

	@BeforeTest
	public void openBrowser() {
			System.setProperty("webdriver.chrome.driver", driverPath);
		
			ChromeOptions opt = new ChromeOptions();
			 WebDriverManager.chromedriver().setup();	
			driver = new ChromeDriver(opt);
			driver.get(baseUrl);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	} 
		
	@Test(priority=1)
	  public void TestAddDelegate() throws InterruptedException {
		
		CommonFunctions cf = new CommonFunctions();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
//Call GetNewWindow method
			cf.GetNewWindow(driver);
			Thread.sleep(8000);
			
	//Call GetNewWindow method
				cf.GetNewWindow(driver);
				Thread.sleep(8000);
//Enter email
				cf.SendKeys(driver, "//input[@id='i0116']","testuser1@ccbmidev.onmicrosoft.com");
				cf.clickOnElement(driver, "//input[@id='idSIButton9']");

//Call GetNewWindow method
				cf.GetNewWindow(driver);
				Thread.sleep(8000);
//Enter password			
				cf.SendKeys(driver, "//input[@id='i0118']","Dag02587");
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
//Click Manage Delegate on the menu
			   cf.clickOnElementJS(driver, "//div[@data-container-name='cmp_LeftMenu'] | //div[@data-control-id='19']");
			    cf.clickOnElement(driver, "//div[@data-container-name='cmp_LeftMenu'] | //div[@data-control-id='19']");
	 
//Select Hospital
				cf.clickOnElementByID(driver, "react-combobox-view-0");
				cf.clickOnElement(driver, "//li[@data-index='0']");
				
//Select Delegate
				//Find Text element
				cf.element(driver, "(.//*[@class[contains(.,'react-combobox-view container')]])[2]/div[1]").click();
				Thread.sleep(5000);
				cf.element(driver, "(.//*[@placeholder='Type a name'])").clear();
				cf.SendKeys(driver, "(.//*[@placeholder='Type a name'])", "akash");
				//cf.element(driver, "(.//*[@placeholder='Type a name'])").sendKeys("akash");
		
		//Click Akash Jadhav in the Search List	
				
				cf.element(driver, ".//span[text()='Akash Jadhav']").click();
//Click Save button
				cf.clickOnElement(driver, "//div[text()='Save']");
//Click OK pop up message
				cf.clickOnElement(driver, "//div[text()='Ok']");
//Validate selected delegate is displayed in the Delegates panel
	String message = driver.findElement(By.xpath("//div[@data-control-name='Title1']//descendant::div[5]")).getText();
			String expected ="Circle Reading Hospital | Tina Usman | Akash Jadhav";
			Assert.assertEquals(message, expected);
			System.out.println(message);
				
	driver.quit();
	}}
