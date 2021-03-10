package automation.seleniumUtils;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automation.commonUtils.Framework;


/**
 * This class is used to set Driver Profile details.
 * @author MGosar
 */
public class DriverProfile extends Framework
{
	public static int counter=0;
	public String driverType,browserType,browserVersion,platform,hubURL;
	public int webDriverWait,waitTime;
	
	/**
	 * This method is used to set various global driver profile variables.
	 * @param driverProfile
	 */
	public static synchronized void setDriverProfile(DriverProfile driverProfile)
	{
		setDriverInstance(driverProfile);
		setActionsInstance();
		setWebDriverWaitInstance(driverProfile.webDriverWait);
		setWaitTime(driverProfile.waitTime);
	}
	
	/**
	 * This method is used to set the global driver instance based on the driverProfile.
	 * @param driverProfile
	 */
	private static synchronized void setDriverInstance(DriverProfile driverProfile)
	{
		SeleniumWebDriver.setBrowser(driverProfile);
		//getDriverInstance().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
	/**
	 * This method is used to set the global actions instance to the driver instance.
	 */
	private static synchronized void setActionsInstance()
	{
		Actions act=new Actions(getDriverInstance());
		builder = act;
	}
	
	/**
	 * This method is used to set the web driver wait time parameter.
	 * @param webDriverWaitObj the wait to set
	 */
	private static synchronized void setWebDriverWaitInstance(int webDriverWait) 
	{
		WebDriverWait webWait=new WebDriverWait(getDriverInstance(), webDriverWait);
		webDriverWaitObj = webWait;
	}
	
	/**
	 * This method will set the global waitTime variable, used for waiting after every actions performed on UI.
	 * @param waitTime - usage Thread.Sleep(waitTime)
	 */
	private static synchronized void setWaitTime(int waitTimeInMilliSec)
	{
		Framework.waitTime= waitTimeInMilliSec;
	}
}