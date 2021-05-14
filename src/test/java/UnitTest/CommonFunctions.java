package UnitTest;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonFunctions {
	public Properties prop;
	 public void readFile(String args[]) throws IOException
	 {
		if(prop==null) {
			prop= new Properties();
	 
			FileInputStream inputStream=null;
	 
	  try {
	   // Getting ClassLoader obj
	   ClassLoader classLoader = this.getClass().getClassLoader();
	   // Getting resource(File) from class loader
	   File configFile=new File(classLoader.getResource("projectConfig.properties").getFile());
	  
	   inputStream = new FileInputStream(configFile);
	   BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
	prop.load(reader);
	 
	  } catch (FileNotFoundException e) {
	 
	   e.printStackTrace();
	  }catch (IOException e) {
	 
	   e.printStackTrace();
	  }
	  finally {
	   inputStream.close();
	  }
	 
		}	 }
		
	public WebElement element(WebDriver driver, String xpathKey) {
		WebElement element = driver.findElement(By.xpath(prop.getProperty(xpathKey)));
		return element;
		}
	
	public void clickOnElement(WebDriver driver,String xpathKey) {
		WebDriverWait wait = new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty(xpathKey))));
		driver.findElement(By.xpath(prop.getProperty(xpathKey))).click();
	}
	
	public void clickOnElementByID(WebDriver driver,String idKey) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(prop.getProperty(idKey))));
		driver.findElement(By.id(prop.getProperty(idKey))).click();
	}
	
	public void clickOnElementJS(WebDriver driver,String xpathKey) {
		WebDriverWait wait = new WebDriverWait(driver,90);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty(xpathKey))));
		executor.executeScript("arguments[0].click()", driver.findElement(By.xpath(prop.getProperty(xpathKey))));
	}
	
	public void ActionOnElement(WebDriver driver,String xpathKey) {
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath(prop.getProperty(xpathKey)))).click().build().perform();
	}
	
		public void ScrollDown(WebDriver driver,String xpathKey) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(prop.getProperty(xpathKey))));
			
		}
		public void GetNewWindow(WebDriver driver) {
			
			for (String windowName : driver.getWindowHandles()) {
				   driver.switchTo().window(windowName);
			   		} 
		}
		
public void SendKeys(WebDriver driver, String xpathKey, String data) {
			
	driver.findElement(By.xpath(prop.getProperty(xpathKey))).sendKeys(data);
		}
}
