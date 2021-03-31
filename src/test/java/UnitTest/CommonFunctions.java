package UnitTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonFunctions {
	
	public WebElement element(WebDriver driver, String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		return element;
	}
	
	public void clickOnElement(WebDriver driver,String xpath) {
		WebDriverWait wait = new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		driver.findElement(By.xpath(xpath)).click();
	}
	
	public void clickOnElementByID(WebDriver driver,String id) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
		driver.findElement(By.id(id)).click();
	}
	
	public void clickOnElementJS(WebDriver driver,String xpath) {
		WebDriverWait wait = new WebDriverWait(driver,90);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		executor.executeScript("arguments[0].click()", driver.findElement(By.xpath(xpath)));
	}
	
	public void ActionOnElement(WebDriver driver,String xpath) {
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath(xpath))).click().build().perform();
	}
}
