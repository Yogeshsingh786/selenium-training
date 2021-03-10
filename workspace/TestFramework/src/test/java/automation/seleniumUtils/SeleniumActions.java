package automation.seleniumUtils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import automation.commonUtils.Framework;
import automation.constants.EnvPropAttributesConstants;

/**
 * 
 * @author YSingh
 *
 */
public class SeleniumActions {

	private WebDriver driver;
	private WebElement tempElement;
	public SeleniumActions() {
		driver = null;
	}

	public SeleniumActions(WebDriver driver) {
		this.driver = driver;
	}

	public void setText(String pageName, String elementName, String value) throws Exception {
		tempElement = ElementManager.getElement(driver, pageName, elementName);
		if (tempElement != null) {
			setFocus(tempElement);
			tempElement.clear();
			tempElement.sendKeys(value);
		} else
			throw new Exception("Element not found at Page : " + pageName + ", Element : " + elementName);
	}

	public String getText(String pageName, String elementName) {
		tempElement = ElementManager.getElement(driver, pageName, elementName);
		if (tempElement != null)
			return tempElement.getText();
		return null;
	}
	
	public String getText(SearchContext searchContext,String pageName, String elementName) {
		tempElement = ElementManager.getElement(searchContext, pageName, elementName);
		if (tempElement != null)
			return tempElement.getText();
//		else
////			Assert.assertTrue(false, "Element not found at Page : " + pageName + ", Element : " + elementName);
		return null;
	}

	public String getText(String pageName, String elementName, int index) {
		Framework.toolsWaitObj.waitForPageLoad();
		tempElement = ElementManager.getElement(driver, pageName, elementName, index);
		if (tempElement != null) {
			setFocus(tempElement);
			return tempElement.getText();
		}
//		else
//			Assert.assertTrue(false, "Element not found at Page : " + pageName + ", Element : " + elementName);
		return null;
	}

	public void setFocus(WebElement element) {

		if (element != null) {
			if (element.isDisplayed())
				;
			else {
				SeleniumWebDriver swd = (SeleniumWebDriver) driver;
				((JavascriptExecutor) swd.getDriver()).executeScript("arguments[0].scrollIntoView();", element);
			}
		}
//		else
//			Assert.assertTrue(false, "Element not found at Page : " + pageName + ", Element : " + elementName);
	}

	public void mouseHover(String pageName, String elementName) {
		tempElement = ElementManager.getElement(driver, pageName, elementName);
		if (tempElement != null) {
			Actions action = new Actions(driver);
			action.moveToElement(tempElement).build().perform();
		}
	}

	public void click(String pageName, String elementName) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			tempElement = ElementManager.getElement(driver, pageName, elementName);
			if (tempElement != null) {
				tempElement = null;
				tempElement = wait.until(ExpectedConditions
						.elementToBeClickable(Framework.objectRepo.getObjectLocator(pageName, elementName)));
				if (tempElement != null)
					tempElement.click();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void click(SearchContext searchContext, String pageName, String elementName) {
		try {
			tempElement = ElementManager.getElement(searchContext, pageName, elementName);
			if (tempElement != null) {
				if (tempElement.isDisplayed())
					tempElement.click();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void click(String pageName, String elementName, String textValue) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			tempElement = ElementManager.getElement(driver, pageName, elementName, textValue);
			if (tempElement != null) {
				tempElement = null;
				tempElement = wait.until(ExpectedConditions.elementToBeClickable(
						Framework.objectRepo.getObjectLocatorWithTextValue(pageName, elementName, textValue)));
				if (tempElement != null)
					tempElement.click();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void click(SearchContext searchContext, String pageName, String elementName, String textValue) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			tempElement = ElementManager.getElement(searchContext, pageName, elementName, textValue);
			if (tempElement != null) {
				tempElement = null;
				tempElement = wait.until(ExpectedConditions.elementToBeClickable(
						Framework.objectRepo.getObjectLocatorWithTextValue(pageName, elementName, textValue)));
				if (tempElement != null)
					tempElement.click();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean isElementCLickable(String pageName, String elementName, String textValue) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			tempElement = ElementManager.getElement(driver, pageName, elementName, textValue);
			if (tempElement != null) {
				tempElement = null;
				tempElement = wait.until(ExpectedConditions.elementToBeClickable(
						Framework.objectRepo.getObjectLocatorWithTextValue(pageName, elementName, textValue)));
				if (tempElement != null)
					return true;
				else
					return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	public void clear(String pageName, String elementName) {
		tempElement = ElementManager.getElement(driver, pageName, elementName);
		if (tempElement != null)
			tempElement.clear();
	}

	public void submit(String pageName, String elementName) {
		tempElement = ElementManager.getElement(driver, pageName, elementName);
		if (tempElement != null)
			tempElement.submit();
	}

	public String getAttibute(String pageName, String elementName, String attributeName) {
		tempElement = ElementManager.getElement(driver, pageName, elementName);
		if (tempElement != null)
			tempElement.getAttribute(attributeName);
		return null;
	}

	public boolean isDisplayed(String pageName, String elementName) {

		tempElement = ElementManager.getElement(driver, pageName, elementName);
		if (tempElement != null)
			if (tempElement.isEnabled())
				return tempElement.isDisplayed();
			else
				return false;

		return false;
	}

	public boolean isDisplayed(SearchContext searchContext, String pageName, String elementName) {

		tempElement = ElementManager.getElement(searchContext, pageName, elementName);
		if (tempElement != null)
			if (tempElement.isEnabled())
				return tempElement.isDisplayed();
			else
				return false;

		return false;
	}

	public boolean isSelected(String pageName, String elementName) {

		tempElement = ElementManager.getElement(driver, pageName, elementName);
		if (tempElement != null)
			if (tempElement.isEnabled())
				return tempElement.isSelected();
			else
				return false;
		return false;
	}

	public void navigateBack() {
		driver.navigate().back();
	}

	public void refresh() {
		driver.navigate().refresh();
	}

	public void navigateForward() {
		driver.navigate().forward();
	}

	/**
	 * 
	 * This function will take screenshot
	 * 
	 * @param webdriver
	 * 
	 * @param fileWithPath
	 * 
	 * @throws Exception
	 * 
	 */

	public void takeSnapShot(String fileWithPath) throws Exception {

		// Convert web driver object to TakeScreenshot

		TakesScreenshot scrShot = ((TakesScreenshot) driver);

		// Call getScreenshotAs method to create image file

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		// Move image file to new destination

		File DestFile = new File(fileWithPath);

		// Copy file at destination

		FileUtils.copyFile(SrcFile, DestFile);

	}

	public void quit() {
		driver.quit();
	}

	public void close() {
		driver.close();
	}

	public boolean isPresent(String pageName, String elementName) {
		try {
			tempElement = ElementManager.getElement(driver, pageName, elementName);
			if (tempElement != null)
				return true;
			else
				return false;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean isPresent(SearchContext searchContext, String pageName, String elementName) {
		try {
			tempElement = ElementManager.getElement(searchContext, pageName, elementName);
			if (tempElement != null)
				return true;
			else
				return false;
		} catch (Exception e) {
			return false;
		}
	}

	protected static ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
		public Boolean apply(WebDriver driver) {
			SeleniumWebDriver swd = (SeleniumWebDriver) driver;
			boolean flag = ((JavascriptExecutor) swd.getDriver()).executeScript("return document.readyState")
					.equals("complete");
			return flag;
		}

	};
	
	public void launchWithURL(String url) {
		driver.get(url);
	}
	
	public void launchApplication() {
		launchWithURL(Framework.envProperties.getProperty(EnvPropAttributesConstants.APPLICATION_URL));
	}

}
