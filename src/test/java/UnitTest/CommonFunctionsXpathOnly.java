package UnitTest;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
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

public class CommonFunctionsXpathOnly {
	
	public String baseUrl = "https://apps.powerapps.com/play/9939cda7-297a-42f9-b377-c619470b315f?tenantId=c9fe3281-a294-4d7b-a1fc-86392b61c883&source=portal&screenColor=rgba(129%2C%2042%2C%20141%2C%201)";
	String driverPath ="C:\\Program Files\\selenium\\chromedriver_win32\\chromedriver.exe";
	public static WebDriver driver;
	
	public void invokeChromeBrowser(String browsername) throws IOException,InterruptedException
	 {
	//Invoke browser
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\driver\\chromedriver");
	ChromeOptions opt = new ChromeOptions();
	opt.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
	opt.addArguments("--no-sandbox");
	opt.addArguments("--start-maximized");
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
	 }
	
	public WebElement element(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		return element;
	}
	
	public void clickOnElement(String xpath) {
		WebDriverWait wait = new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		driver.findElement(By.xpath(xpath)).click();
	}
	
	public void clickOnElementByID(String id) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
		driver.findElement(By.id(id)).click();
	}
	
	public void clickOnElementJS(String xpath) {
		WebDriverWait wait = new WebDriverWait(driver,90);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		executor.executeScript("arguments[0].click()", driver.findElement(By.xpath(xpath)));
	}
	
	public void ActionOnElement(String xpath) {
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath(xpath))).click().build().perform();
	}
	
		public void ScrollDown(String xpath) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(xpath)));
			
		}
		public void GetNewWindow(WebDriver driver) {
			
			for (String windowName : driver.getWindowHandles()) {
				   driver.switchTo().window(windowName);
			   		} 
		}
		
public void SendKeys(String xpath, String data) {
			
	driver.findElement(By.xpath(xpath)).sendKeys(data);
		}
}
