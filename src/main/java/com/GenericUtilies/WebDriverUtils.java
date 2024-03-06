package com.GenericUtilies;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtils {
	

	
	public void waitForPageLoad(WebDriver driver, int sec)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}
	
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
			 
	public WebDriverWait  webdriverWaitObj(WebDriver driver, int sec) 
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(sec));	
		return wait;
	}
		
	public void waitUntilEleToBeVisible(WebDriver driver, int sec, WebElement element)
	{
		webdriverWaitObj(driver, sec).until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waituntilEleToBeClickable(WebDriver driver, int sec, WebElement element)
	{
		webdriverWaitObj(driver,sec).until(ExpectedConditions.alertIsPresent());
	}
	
	public Select dropdownObj(WebElement element)
	{
		Select sobj = new Select(element);
		return sobj;
	}
	 public void handleDropDown(WebElement element, int index)
	 {
		 dropdownObj(element).selectByIndex(index);
	 }
	 
	 public void handleDropDownbyValue(WebElement element, String value )
	 {
		 dropdownObj(element).selectByValue(value);
	 }
	 
	 public void handleDropDownbyVisbleText(WebElement element, String text)
	 {
		 dropdownObj(element).selectByVisibleText(text);
	 }
	 
	 public Actions actionObj(WebDriver driver)
	 {
		 Actions act = new Actions(driver);
		 return act;
	 }
	 
	 
	 public void dragAndDrop(WebDriver driver, WebElement src, WebElement dest)
	 {
		 actionObj(driver).dragAndDrop(src, dest).perform();
	 }
	 
	 public void doubleClickAction(WebDriver driver, WebElement element)
	 {
		 actionObj(driver).doubleClick(element);
	 }
	 
	 public void doubleClickAction(WebDriver driver)
	 {
		 actionObj(driver).doubleClick().perform();
	 }
	 
	 public void rightClick(WebDriver driver, WebElement element)
	 {
		 actionObj(driver).contextClick(element).perform();
	 }
	 
	 public void rightClick(WebDriver driver)
	 {
		 actionObj(driver).contextClick().perform();
	 }
	 
	 public void mouseHoverOnEle(WebDriver driver, WebElement element)
	 {
		 actionObj(driver).click(element).perform();
	 }
	 
	 public void mouseHoverOnEle(WebDriver driver)
	 {
		 actionObj(driver).click().perform();
	 }
	 
	 public void enterKeyPress(WebDriver driver)
	 {
		 actionObj(driver).sendKeys(Keys.ENTER).perform();
	 }
	 
	 public void enterKey() throws Throwable 
	 {
		 Robot rb = new Robot();
		 rb.keyPress(KeyEvent.VK_ENTER); 
	 }
	 
	 public void enterRelease() throws Throwable 
	 {
		 Robot rb = new Robot();
		 rb.keyRelease(KeyEvent.VK_ENTER); 
	 }	 
	 
	 public void swithToFrame(WebDriver driver, int index)
	 {
		 driver.switchTo().frame(index);
	 }
	 
	 public void switchToFrame(WebDriver driver, String nameOrld)
	 {
		 driver.switchTo().frame(nameOrld);
	 }
	 
	 public void switchToFrame(WebDriver driver, WebElement address)
	 {
		 driver.switchTo().frame(address);
	 }
	 
	 public void switchToWindow(WebDriver driver, String expWind)
	 {
		Set<String> window = driver.getWindowHandles();
		  Iterator<String> it = window.iterator();
		  while(it.hasNext())
		  {
			  String win = it.next();
			 String currentTitle
			 = driver.switchTo().window(win).getTitle();
			 
			 if(currentTitle.contains(expWind))
			 {
				 break;
			 }
		  }
	 }
		public void Alert(WebDriver driver)
		{
			driver.switchTo().alert().accept();
		}
		
		public void cancelAlert(WebDriver driver)
		{
			driver.switchTo().alert().dismiss();
		}
		 
		public static String getScreenShot(WebDriver driver, String screenShotName) throws IOException
		{
			JavaUtils jlib = new JavaUtils();
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			String path = ".\\screenshot\\"+screenShotName+" "+jlib.getSystemDateInFormate()+".png";
			File dst = new File(path);
			FileUtils.copyFile(src,dst);
			return dst.getAbsolutePath();
		}
			
		public void scrollAction(WebDriver driver)
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,2000)","");	
		}
		
		public void scroolAction(WebDriver driver, WebElement element)
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			int y = element.getLocation().getY();
			js.executeScript("window.scroolBy(0,"+y+")", element);
			//js.executeScript("argument[0].scrollIntoView()", element);
			 
		}
		}
		  
//String path = ".\\screenshot\\"+screenShotName+" "+jlib.getSystemDateInFormate()+".png";
	 
		 
		 
		 

