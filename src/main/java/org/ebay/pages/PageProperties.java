package org.ebay.pages;

import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageProperties {
	
	static WebDriver driver = null;
	static WebDriverWait wait = null;
	ResourceBundle config = ResourceBundle.getBundle("configuration");
	
	public PageProperties() {

		if (driver == null){
			
			String URL = config.getString("URL");
			String waittime = config.getString("waittime");
			String browser = config.getString("browser");
			if(browser.equalsIgnoreCase("chrome"))
			{
			driver = new ChromeDriver();	
			}
			else if (browser.equalsIgnoreCase("firefox"))
			{
				System.setProperty("webdriver.gecko.driver", config.getString("browserdriver"));	
				driver = new FirefoxDriver();
			}
			else 
			{
				System.setProperty("webdriver.gecko.driver", config.getString("browserdriver"));
				driver = new FirefoxDriver();
				System.out.println("No other browser selected, firefox initiated");	
			}
			
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(waittime), TimeUnit.SECONDS);
			//wait = new WebDriverWait(driver, Integer.parseInt(waittime));
			driver.get(URL);
			}
	}
		public void txtField(String xpath, String text)
		{
			WebElement element = driver.findElement(By.xpath(xpath));
			element.sendKeys(text);
			
		}

		public void clickButton (String xpath)
		{
			WebElement element = driver.findElement(By.xpath(xpath));
			//WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
			element.click();
			
			}
		
		public void mouseOver(String xpath)
		{
			//WebElement searchBtn = driver.findElement(By.id(xpath));
			WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
			Actions action = new Actions(driver);
			action.moveToElement(searchBtn).perform();

		}

		public void clickJsButton (String stringId)
		{
			//WebElement element = driver.findElement(By.xpath(xpath));
			JavascriptExecutor exec = (JavascriptExecutor)driver;
			exec.executeScript("arguments[0].click();", driver.findElement(By.id(stringId)));
			
			}
			
		public void radioButton (String xpath)

		{
			
			WebElement element = driver.findElement(By.xpath(xpath));
			element.click();
		}


		public void dropdown (String xpath, String value)
		{
			
			Select ddm = new Select (driver.findElement(By.xpath(xpath)));
			ddm.selectByValue(value);
		}

		public void checkboxselect (String xpath)

		{
			WebElement element = driver.findElement(By.xpath(xpath));
			element.click();
		}

		
}

