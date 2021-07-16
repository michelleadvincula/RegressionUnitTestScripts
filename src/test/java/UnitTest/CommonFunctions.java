package UnitTest;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonFunctions {
	public String baseUrl = "https://apps.powerapps.com/play/e7913a8e-0481-4d5d-ba5c-39d42c620097?tenantId=62551275-fac1-4caf-a2b6-2d9c7efcafba&source=portal&screenColor=rgba(1%2C%20131%2C%20134%2C%201)";
	String driverPath ="C:\\Program Files\\selenium\\chromedriver_win32\\chromedriver.exe";
	public static WebDriver driver;
	public Properties obj;
	
	public void invokeChromeBrowser(String browsername) throws IOException,InterruptedException
	 {
	//Invoke browser
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\driver\\chromedriver");
	ChromeOptions opt = new ChromeOptions();
	opt.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
	opt.addArguments("--no-sandbox");
	opt.addArguments("start-maximized");
	
	opt.addArguments("--disable-web-security");
	opt.addArguments("--no-proxy-server");

	Map<String, Object> prefs = new HashMap<String, Object>();
	prefs.put("credentials_enable_service", false);
	prefs.put("profile.password_manager_enabled", false);

	opt.setExperimentalOption("prefs", prefs);
	
	opt.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
	opt.setExperimentalOption("useAutomationExtension", false);
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver(opt);
	driver.manage().deleteAllCookies();
	driver.get(baseUrl);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	// Specify the file location
		
	File src=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\ObjectRepository\\projectConfig.properties");
	
	// Create Properties class object to read properties file
	if (obj == null) {
	obj=new Properties();
	// Create FileInputStream object
	FileInputStream objfile=new FileInputStream(src);
	// Load file so we can use into our script
	obj.load(objfile);

	System.out.println("Property class loaded");
	 }}
	
	public void OpenApp(String websiteURLKey) {
		driver.get(websiteURLKey);
	}

	public WebElement element(String xpathKey) {
		WebElement element = driver.findElement(By.xpath(obj.getProperty(xpathKey)));
		return element;
		}
	
	public void clickOnElement(String xpathKey) {
		WebDriverWait wait = new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(obj.getProperty(xpathKey))));
		driver.findElement(By.xpath(obj.getProperty(xpathKey))).click();
	}
	
	public void clickOnElementByID(String idKey) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(obj.getProperty(idKey))));
		driver.findElement(By.id(obj.getProperty(idKey))).click();
	}
	
	public void clickOnElementJS(String xpathKey) {
		WebDriverWait wait = new WebDriverWait(driver,90);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(obj.getProperty(xpathKey))));
		executor.executeScript("arguments[0].click()", driver.findElement(By.xpath(obj.getProperty(xpathKey))));
	}
	
	public void ActionOnElement(String xpathKey) {
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath(obj.getProperty(xpathKey)))).click().build().perform();
	}
	
		public void ScrollDown(String xpathKey) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(obj.getProperty(xpathKey))));
			
		}
		public void GetNewWindow(WebDriver driver) {
			
			for (String windowName : driver.getWindowHandles()) {
				   driver.switchTo().window(windowName);
			   		} 
		}
		
public void SendKeys(String xpathKey, String data) {
			
	driver.findElement(By.xpath(obj.getProperty(xpathKey))).sendKeys(data);
		}

public void clickOnElementJS2(String xpath) {
	WebDriverWait wait = new WebDriverWait(driver,90);
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(obj.getProperty(xpath))));
	executor.executeScript("arguments[0].click()", driver.findElement(By.xpath(obj.getProperty(xpath))));
}

public WebElement element2(String xpath) {
	WebElement element = driver.findElement(By.xpath(obj.getProperty(xpath)));
	return element;
	}

public void clickOnElement2(String xpath) {
	WebDriverWait wait = new WebDriverWait(driver,50);
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(obj.getProperty(xpath))));
	driver.findElement(By.xpath(obj.getProperty(xpath))).click();
}

}
