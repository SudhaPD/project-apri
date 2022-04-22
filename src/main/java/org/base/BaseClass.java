package org.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	
	public static WebDriver launchBrowser(String browsername) {
		
		if (browsername.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browsername.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		return driver;
	}
	
	public static void urlLaunch(String url) {
		driver.get(url);
	}
	
	public static void navigateTo(String url) {
		driver.navigate().to(url);
	}
	
	public static void maximize() {
		driver.manage().window().maximize();
	}

	public static void implicitWait(long secs) {
		driver.manage().timeouts().implicitlyWait(secs, TimeUnit.SECONDS);
	}
	
	public static String getUrl() {
		String url = driver.getCurrentUrl();
		return url;		
	}
	
	public static String getTitle() {
		String title = driver.getTitle();
		return title;
	}
	
	public static void browserQuit() {
		driver.quit();
	}
	
	public static WebElement findElement(String locator) {
		WebElement e=null;
		if(locator.equals("id")) {
			e=driver.findElement(By.name(locator));
		}
		else if(locator.equals("name")) {
			e=driver.findElement(By.name(locator));
		}
		else if(locator.equals("xpath")) {
			e=driver.findElement(By.name(locator));
		}
		else if(locator.equals("className")) {
			e=driver.findElement(By.name(locator));
		}
		return e;	
	}
	
	public static void sendkeys(WebElement e,String value) {
		e.sendKeys(value);		
	}
	
	public static void click(WebElement e) {
		e.click();
	}
	
	public static 	String	getText(WebElement e) {
		String text = e.getText();
		return text;	
	}
	
	public static String getAttribute(WebElement e) {
		String attribute = e.getAttribute("value");
		return attribute;
	}
	
	public static void selectByIndex(WebElement e,int index) {
		Select s=new Select(e);
		s.selectByIndex(index);
	}
	
	public static void selectByValue(WebElement e,String value) {
		Select s=new Select(e);
		s.selectByValue(value);
	}
	
	public static void jsClick(WebElement e) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", e);
	}
	
	public static void jsscrollBy() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,250)","");
	}
	public static void actionMoveToElement(WebElement e) {
		Actions a=new Actions(driver);
		a.moveToElement(e).click().build().perform();
	}
	
	public static void dragAndDrop(WebElement from,WebElement to ) {
		Actions a =new Actions(driver);
		a.dragAndDrop(from,to).perform();
	}
	
	public static void clickAndHold(WebElement from,WebElement to ) {
		Actions a =new Actions(driver);
		a.clickAndHold(from).release(to).build().perform();
	}
	
//	public static void keyBoardPress(String key) throws AWTException {
//		Robot r=new Robot();
//		r.keyPress("KeyEvent."+ key);	
//	}
//	public static void keyBoard(String key) throws AWTException {
//		 key1="KeyEvent."+ key;
//	    Robot r=new Robot();
//		r.keyRelease(key1);	
//	}
}


