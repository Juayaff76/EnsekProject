package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import managers.WebDriverManager;

public class WrapperFunctions {
	
	//public static WebDriver driver=WebDriverManager.driver;
	public static WebDriver driver;
	WebDriverManager objDriver;
	public WrapperFunctions(){
		objDriver= new WebDriverManager();
		driver=objDriver.getDriver();
	}
	
	public void waitForElementPresence(By locator, int waitInSeconds) 
	{
		try 
		{
			WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, waitInSeconds).ignoring(StaleElementReferenceException.class);
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		} 
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
	} 
	
	public void waitForElementDisplayed(By locator, int waitInSeconds) 
	{
		try 
		{
			WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, waitInSeconds).ignoring(StaleElementReferenceException.class);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} 
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
	} 
	 public void selectDropdownByVisibleText(By locator , String visibleText)
	    {
	        WebElement element = driver.findElement(locator);
	        Select select = new Select(element);
	        select.selectByVisibleText(visibleText);
	    }
	
	public boolean click(By locator) 
	{
		waitForElementPresence(locator, 10);
		WebElement webElement = driver.findElement(locator);
		try
		{
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", webElement);
			return true;
		} 
		catch (Exception exception)
		{
			exception.printStackTrace();
			return false;
		}
	}
	
	public boolean doubleClick( By locator)
	{
		waitForElementPresence(locator, 10);
		WebElement webElement = driver.findElement(locator);
		try
		{
			Actions actionBuilder = new Actions(driver);
			actionBuilder.doubleClick(webElement).build().perform();
			return true;
		} 
		catch (Exception exception)
		{
			exception.printStackTrace();
			return false;
		}
	}
	
	
	public boolean setText(By locator, String fieldValue) 
	{
		waitForElementPresence(locator, 20);
		WebElement webElement = driver.findElement(locator);
		try
		{
			// replace the text
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", webElement);
			webElement.sendKeys(Keys.chord(Keys.CONTROL, "a"));
			webElement.sendKeys(Keys.DELETE);
			webElement.clear();
			webElement.sendKeys(fieldValue);
			//webElement.sendKeys(Keys.TAB);
			return true;
		} 
		catch (Exception exception)
		{
			exception.printStackTrace();
			return false;
		}
	}

	
	public String getText(By locator, String textBy) 
	{
		waitForElementPresence( locator, 10);
		WebElement webElement = driver.findElement(locator);
		try
		{
			String strText = "";
			if(textBy.equals("value"))
				strText = webElement.getAttribute("value");
			else if(textBy.equalsIgnoreCase("text"))
				strText = webElement.getText();
			return strText; 
		} 
		catch (Exception exception)
		{
			exception.printStackTrace();
			return null;
		}
	}
	
	
		
	public boolean selectCheckBox(By locator, boolean status) 
	{
		waitForElementPresence(locator, 10);
		WebElement webElement = driver.findElement(locator);
		try
		{
			if(webElement.getAttribute("type").equals("checkbox"))   
			{
				if((webElement.isSelected() && !status) || (!webElement.isSelected() && status))
					webElement.click();
				return true;
			}
			else
				return false;
		} 
		catch (Exception exception)
		{
			exception.printStackTrace();
			return false;
		}
	}
	
	public boolean isCheckBoxSelected(By locator, boolean status) 
	{
		waitForElementPresence(locator, 10);
		WebElement webElement = driver.findElement(locator);
		boolean state = false;
		try
		{
			if(webElement.getAttribute("type").equals("checkbox"))   
				state = webElement.isSelected();

			return state;
		} 
		catch (Exception exception)
		{
			exception.printStackTrace();
			return false;
		}
	}

	
	public boolean selectRadioButton(By locator, boolean status)
	{
		waitForElementPresence(locator, 10);
		WebElement webElement = driver.findElement(locator);
		try
		{
			if(webElement.getAttribute("type").equals("radio"))   
			{
				if((webElement.isSelected() && !status) || (!webElement.isSelected() && status))
					webElement.click();
				return true;
			}
			else
				return false;
		} 
		catch (Exception exception)
		{
			exception.printStackTrace();
			return false;
		}
	}

	
	
	public boolean mouseHover(By locator)
	{
		waitForElementPresence(locator, 10);
		WebElement webElement = driver.findElement(locator);
		try
		{
			Actions actionBuilder = new Actions(driver);
			actionBuilder.moveToElement(webElement).build().perform();
			return true;
		} 
		catch (Exception exception)
		{
			exception.printStackTrace();
			return false;
		}
	}
	
	
	public boolean switchToWindowUsingTitle(String windowTitle)
	{
		try
		{
			String mainWindowHandle = driver.getWindowHandle();
			Set<String> openWindows = driver.getWindowHandles();

			if (!openWindows.isEmpty()) 
			{
				for (String windows : openWindows) 
				{
					String window = driver.switchTo().window(windows).getTitle();
					if (windowTitle.equals(window)) 
						return true;
					else 
						driver.switchTo().window(mainWindowHandle);
				}
			}
			return false;
		} 
		catch (Exception exception)
		{
			exception.printStackTrace();
			return false;
		}
	}

	
	public boolean selectDropDownOption(By locator, String option, String... selectType) 
	{
		try
		{
			waitForElementPresence(locator, 10);
			WebElement webElement = driver.findElement(locator);
			Select sltDropDown = new Select(webElement);
			
			if(selectType.length > 0 && !selectType[0].equals(""))
			{
				if(selectType[0].equals("Value"))
					sltDropDown.selectByValue(option);
				else if(selectType[0].equals("Text"))
					sltDropDown.selectByVisibleText(option);
				else if(selectType[0].equals("Index"))
					sltDropDown.selectByIndex(Integer.parseInt(option));
				

				return true;
			}
			else
			{
				// Web elements from dropdown list 
				List<WebElement> options = sltDropDown.getOptions();
				boolean blnOptionAvailable = false;
				int iIndex = 0;
				for(WebElement weOptions : options)  
				{  
					if (weOptions.getText().trim().equals(option))
					{
						sltDropDown.selectByIndex(iIndex);
						blnOptionAvailable = true;
					}
					else
						iIndex++;
					if(blnOptionAvailable)
						break;
				}
				if(blnOptionAvailable)
					return true;
				else
					return false;
			}
		} 
		catch (Exception exception)
		{
			exception.printStackTrace();
			return false;
		}
	}
	
	
	public String getSelectedValueFormDropDown(WebDriver driver,By locator) 
	{
		try
		{
			waitForElementPresence(locator, 10);
			Select selectDorpDown = new Select(driver.findElement(locator));
			String selectedDorpDownValue = selectDorpDown.getFirstSelectedOption().getText();
			return selectedDorpDownValue;
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			return null;
		}

	}
	
	public void uploaFile(By locator) throws FileNotFoundException, IOException {
		Properties objConfig=new Properties();
		objConfig.load(new FileInputStream(System.getProperty("user.dir")+"/src/main/java/Core/Config.properties"));
		String filePath=objConfig.getProperty("filePath");
		WebElement uploadElement = driver.findElement(locator);
		System.out.println("****Started uploading");
		uploadElement.sendKeys(filePath);
		System.out.println("****Done uploading");
	}

	public boolean selectRadioButtonForSpecificColumn(By locator, String columnContent, int columnNumberForRadio) 
	{
		try
		{
			waitForElementPresence(locator, 10);
			List<WebElement> weResultTable = driver.findElements(locator);
			for(WebElement weRow : weResultTable)
			{
				List<WebElement> weColumns = weRow.findElements(By.xpath(".//td"));
				for(WebElement weColumn : weColumns)
				{
					if(weColumn.getText().trim().equals(columnContent))
					{
						WebElement webElement = weRow.findElement(By.xpath(".//td['" + columnNumberForRadio + "']/input[@type='radio']"));
						JavascriptExecutor executor = (JavascriptExecutor)driver;
						executor.executeScript("arguments[0].click();", webElement);
					}
				}
			}
			return true;
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			return false;
		}
	}
	
	
	public boolean selectCheckBoxForSpecificColumn(By locator, String columnContent, int columnNumberForRadio) 
	{
		try
		{
			waitForElementPresence(locator, 10);
			List<WebElement> weResultTable = driver.findElements(locator);
			for(WebElement weRow : weResultTable)
			{
				List<WebElement> weColumns = weRow.findElements(By.xpath(".//td"));
				for(WebElement weColumn : weColumns)
				{
					if(weColumn.getText().trim().equals(columnContent))
						weRow.findElement(By.xpath(".//td['" + columnNumberForRadio + "']/span/input[@type='checkbox']")).click();
				}
			}
			return true;
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			return false;
		}
	}
	
	public void scrollDown() throws InterruptedException  {
		Thread.sleep(2000);
		  JavascriptExecutor jse = (JavascriptExecutor)driver;
		  jse.executeScript("window.scrollBy(0,400)", "");
	}
	
	public boolean sendKeyBoardKeys(By locator, String key, int waitInSeconds) 
	{
		try
		{
			waitForElementPresence(locator, waitInSeconds);
			WebElement webElement = driver.findElement(locator);
			if(key.equalsIgnoreCase("enter"))
				webElement.sendKeys(Keys.ENTER);
			if(key.equalsIgnoreCase("shift"))
				webElement.sendKeys(Keys.SHIFT);
			if(key.equalsIgnoreCase("arrow_up"))
				webElement.sendKeys(Keys.ARROW_UP);
			if(key.equalsIgnoreCase("tab"))
				webElement.sendKeys(Keys.TAB);
			return true;
		} 
		catch (Exception exception)
		{
			exception.printStackTrace();
			return false;
		}
	}
	
	
	public void waitForMoment() throws InterruptedException{
		Thread.sleep(5000);
	}
	
	public void refreshPage() throws InterruptedException{
		driver.navigate().refresh();
		Thread.sleep(5000);
		}
//	public sta WebElement waitForClickability(WebElement element,int timeout) {
//		WebDriverWait wait =new WebDriverWait(Driver.get(),timeout);
//		return wait,until(ExpectedCondition.elementToBeClickable(element));
//	}
}
