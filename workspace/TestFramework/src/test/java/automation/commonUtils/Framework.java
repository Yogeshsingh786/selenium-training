package automation.commonUtils;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automation.constants.FrameworkConstants;
import automation.pageActons.PropinePageActions;
import automation.seleniumUtils.DriverProfile;
import automation.seleniumUtils.SeleniumWaits;
import automation.seleniumUtils.SeleniumWebDriver;

/**
 * 
 * @author YSingh
 *
 */
public class Framework {
	
	public static ObjectRepoReader objectRepo;
	public static Properties envProperties, frameworkProperties;
	public static WebDriver driver ;
	private static PropinePageActions testActions;	
	
	protected static WebDriverWait webDriverWaitObj;

	protected static Actions builder ;
	public static Integer waitTime ;
	public static SeleniumWaits toolsWaitObj ;
	
	public PropinePageActions getTestActions() {
		return testActions;
	}

	public void setTestActions(PropinePageActions testActions) {
		Framework.testActions = testActions;
	}

	public void initTestExecuter() throws Exception {

		try {
			frameworkProperties = PropertiesUtils
					.getPropertiesFromFile(FrameworkConstants.FRAMEWORK_PROPERTIES_FILEPATH);

			frameworkProperties = PropertiesUtils
					.getPropertiesFromFile("./src/test/java/resources/properties/framework.properties");
			System.out.println(frameworkProperties.getProperty(FrameworkConstants.ENV_PROPERTIES_FILEPATH));
			envProperties = PropertiesUtils
					.getPropertiesFromFile(frameworkProperties.getProperty(FrameworkConstants.ENV_PROPERTIES_FILEPATH));
			if(System.getProperty("browserName")!=null)
				envProperties.setProperty("browserName", System.getProperty("browserName"));
			waitTime = Integer.parseInt(frameworkProperties.getProperty(FrameworkConstants.WAIT));
			objectRepo = new ObjectRepoReader(
					frameworkProperties.getProperty(FrameworkConstants.OBJECT_REPOSITORY_PATH));
			driver= new SeleniumWebDriver();
			toolsWaitObj = new SeleniumWaits();
			setWebDriverWaitObj(new WebDriverWait(driver, waitTime));
			testActions = new PropinePageActions(driver);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public DriverProfile getDriverProfile() {
		DriverProfile driverProfile = new DriverProfile();
		driverProfile.driverType = envProperties.getProperty("driver");
		driverProfile.browserType = envProperties.getProperty("browserName");
		driverProfile.hubURL = envProperties.getProperty("HubURL");
		driverProfile.webDriverWait = Integer.parseInt(envProperties.getProperty("webDriverWait"));
		driverProfile.waitTime = Integer.parseInt(envProperties.getProperty("waitTime"));
		return driverProfile;
	}

	public static WebDriver getDriverInstance() {
		return driver;
	}
	
	public static SeleniumWebDriver getSeleniumWebDriver() {
		return (SeleniumWebDriver) driver;
	}

	public static WebDriverWait getWebDriverWaitInstance() {
		return webDriverWaitObj;
	}

	/**
	 * @return waitTime - global wait time to wait after every Selenium actions.
	 */
	public static synchronized Integer getWaitTime() {
		return waitTime;
	}

	public SeleniumWaits getToolsWaitObj() {
		return toolsWaitObj;
	}

	public static void setToolsWaitObj(SeleniumWaits toolsWaitObj) {
		Framework.toolsWaitObj = toolsWaitObj;
	}

	public static WebDriverWait getWebDriverWaitObj() {
		return webDriverWaitObj;
	}

	public static void setWebDriverWaitObj(WebDriverWait webDriverWaitObj) {
		Framework.webDriverWaitObj = webDriverWaitObj;
	}
	
	public void waitForPageLoad() {
		getToolsWaitObj().waitForPageLoad();
	}

}
