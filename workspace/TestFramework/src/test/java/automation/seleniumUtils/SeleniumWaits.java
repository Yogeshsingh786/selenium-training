package automation.seleniumUtils;

import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import automation.commonUtils.Framework;

/**
 * This class holds all the methods that help selenium to wait for condition.
 * @author YSingh
 *
 */
public class SeleniumWaits extends Framework
{
	public SeleniumWaits() {
	}
	//Waiting for DOM source to load.
	static ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() 
    {
        public Boolean apply(WebDriver driver) 
        {
            boolean flag=((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
        	return flag;
        }

    };
	
    /**
     * This method will wait for the specified in webDriverWait object until the DOM readyState is in complete state.
     */
	public void waitForDomReadiness()
	{
		getWebDriverWaitInstance().until(pageLoadCondition);
	}
	/**
	 * This method will wait for time specified in the webDriverWait object until Loading element is gone out of the page.
	 */
	public void waitForPageLoad()
	{
		try
		{
			waitForDomReadiness();
			getWebDriverWaitInstance().until(ExpectedConditions.invisibilityOfElementLocated(By.id("loadinggif")));
			waitForDomReadiness();
			Thread.sleep(getWaitTime());
		}
		catch(TimeoutException | InterruptedException e)
		{
			System.out.println("Exception : "+e);
		}
	}
}
