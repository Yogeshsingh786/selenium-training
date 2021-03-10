package automation.seleniumUtils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import automation.commonUtils.Framework;
import automation.constants.EnvPropAttributesConstants;
import automation.constants.FrameworkConstants;
import automation.cucumberOptions.TestRunner;

/**
 * @author YSingh
 *
 */
public class SeleniumWebDriver extends TestRunner implements WebDriver {

	private WebDriver driver;

	public SeleniumWebDriver() throws Exception {
		String browserName = Framework.envProperties.getProperty(EnvPropAttributesConstants.BROWSER_NAME)
				.toLowerCase();
		String driverPath;
		switch (browserName) {
		case "chrome":
			driverPath = Framework.frameworkProperties.getProperty(FrameworkConstants.DRIVERS_FOLDER_PATH)
					+ System.getProperty("file.separator") + "chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", driverPath);
			driver = new ChromeDriver();

			break;
		case "ie":
			driverPath = Framework.frameworkProperties.getProperty(FrameworkConstants.DRIVERS_FOLDER_PATH)
					+ System.getProperty("file.separator") + "IEDriverServer.exe";
			System.setProperty("webdriver.ie.driver", driverPath);
			driver = new InternetExplorerDriver();
			break;
		case "firefox":
			driverPath = Framework.frameworkProperties.getProperty(FrameworkConstants.DRIVERS_FOLDER_PATH)
					+ System.getProperty("file.separator") + "geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", driverPath);
			driver = new FirefoxDriver();
			break;
		case "safari":
			driverPath = Framework.frameworkProperties.getProperty(FrameworkConstants.DRIVERS_FOLDER_PATH)
					+ System.getProperty("file.separator") + "safaridriver";
			System.setProperty("webdriver.safari.driver", driverPath);
			driver = new SafariDriver();
			break;

		default:
			throw new Exception("Browser name :" + browserName + " is not supported.");
		}
	}

	static String webDriver = "WebDriver";
	static String remoteWebDriver = "RemoteWebDriver";
	static String firefox = "FireFox";
	static String internetExplorer = "InternetExplorer";
	static String chrome = "Chrome";
	static DesiredCapabilities capabilities;
	static WebDriver browser;

	public enum Navigate {
		BACK, FORWARD, REFRESH;
	}

	/**
	 * This method will set the driver to FireFox.
	 */
	@SuppressWarnings("deprecation")
	private static synchronized void webDriver(DriverProfile driverProfile) {
		String driverPath;
		// Going ahead we can implement DesiredCapabilities from the driverProfile
		// passed.
		if (driverProfile.browserType.equalsIgnoreCase(firefox)) {
			FirefoxOptions fxOptions = new FirefoxOptions();
			fxOptions.addPreference("browser.download.folderList", 2);
			fxOptions.addPreference("browser.download.manager.showWhenStarting", false);
			fxOptions.addPreference("browser.download.dir",
					"C:\\Users\\" + System.getProperty("user.name") + "\\AppData\\Local\\Temp\\MyDownloads");
			fxOptions.addPreference("browser.helperApps.neverAsk.saveToDisk",
					"text/csv,text/comma-separated-values,application/octet-stream,application/csv,application/vnd.ms-excel,text/plain");
			browser = new FirefoxDriver(fxOptions);
			Framework.driver= browser;
		} else if (driverProfile.browserType.equalsIgnoreCase(internetExplorer)) {
			driverPath = Framework.frameworkProperties.getProperty(FrameworkConstants.DRIVERS_FOLDER_PATH)
					+ System.getProperty("file.separator") + "iexploredriver.exe";
			File IEDriver = new File(driverPath);
			// File IEDriver=new
			// File(".."+File.separator+"BrowserDrivers"+File.separator+"IEDriverServer.exe");
			System.setProperty("webdriver.ie.driver", IEDriver.getAbsolutePath());
			DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
			cap.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
			cap.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
			browser = new InternetExplorerDriver(cap);
			// browser=new InternetExplorerDriver();
			Framework.driver= browser;
		} else if (driverProfile.browserType.equalsIgnoreCase(chrome)) {
			driverPath = Framework.frameworkProperties.getProperty(FrameworkConstants.DRIVERS_FOLDER_PATH)
					+ System.getProperty("file.separator") + "chromedriver.exe";
			File IEDriver = new File(driverPath);
			// File IEDriver=new
			// File(".."+File.separator+"BrowserDrivers"+File.separator+"IEDriverServer.exe");
			System.setProperty("webdriver.ie.driver", IEDriver.getAbsolutePath());
			DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
			cap.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
			cap.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
			browser = new InternetExplorerDriver(cap);
			// browser=new InternetExplorerDriver();
			Framework.driver= browser;
		} else {
			browser = new FirefoxDriver();
			Framework.driver= browser;
		}
	}

	/**
	 * This method will set the driver to InternetExplorer.
	 */
	private static synchronized void remoteWebDriver(DriverProfile driverProfile)
	{
		//Going ahead we can implement DesiredCapabilities from the driverProfile passed.
		if(driverProfile.hubURL.equals("") || driverProfile.hubURL==null)
		{
			System.exit(0);
		}
		if(driverProfile.browserType.equalsIgnoreCase(firefox))
		{
			capabilities=DesiredCapabilities.firefox();
			try 
			{
				browser=new RemoteWebDriver(new URL(driverProfile.hubURL), capabilities);
				Framework.driver= browser;
			} 
			catch (MalformedURLException e) 
			{
				e.printStackTrace();
				System.exit(0);
			}
		}
		else if(driverProfile.browserType.equalsIgnoreCase(internetExplorer))
		{
			capabilities=DesiredCapabilities.internetExplorer();
			
			File IEDriver=new File(Framework.frameworkProperties.getProperty(FrameworkConstants.DRIVERS_FOLDER_PATH)
					+ System.getProperty("file.separator") + "iexploredriver.exe");
			//File IEDriver=new File(".."+File.separator+"BrowserDrivers"+File.separator+"IEDriverServer.exe");
			System.setProperty("webdriver.ie.driver", IEDriver.getAbsolutePath());
			capabilities=DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
			capabilities.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
			try 
			{
				browser=new RemoteWebDriver(new URL(driverProfile.hubURL),capabilities);
				Framework.driver= browser;
			} 
			catch (MalformedURLException e) 
			{
				e.printStackTrace();
				System.exit(0);
			}
		}
		else
		{
			capabilities=DesiredCapabilities.firefox();
			try 
			{
				browser=new RemoteWebDriver(new URL(driverProfile.hubURL), capabilities);
				Framework.driver= browser;
			} 
			catch (MalformedURLException e) 
			{
				e.printStackTrace();
				System.exit(0);
			}
		}
	}

	/**
	 * This method will set the driver to the browser value set in the UI.properties
	 * file inside properties folder. If browser property is not set then it will
	 * set the driver to default FireFox.
	 */
	public static synchronized void setBrowser(DriverProfile driverProfile) {
		if (driverProfile.driverType.equalsIgnoreCase(webDriver))
			webDriver(driverProfile);
		else if (driverProfile.driverType.equalsIgnoreCase(remoteWebDriver))
			remoteWebDriver(driverProfile);
		else {
			webDriver(driverProfile);
		}
	}

	@Override
	public void close() {
		driver.close();
	}

	@Override
	public WebElement findElement(By locator) {

		return driver.findElement(locator);
	}

	@Override
	public List<WebElement> findElements(By locator) {
		return driver.findElements(locator);
	}

	@Override
	public void get(String url) {
		driver.get(url);
	}

	@Override
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	@Override
	public String getPageSource() {
		return driver.getPageSource();
	}

	@Override
	public String getTitle() {
		return driver.getTitle();
	}

	@Override
	public String getWindowHandle() {
		return driver.getWindowHandle();
	}

	@Override
	public Set<String> getWindowHandles() {
		return driver.getWindowHandles();
	}

	@Override
	public Options manage() {
		return driver.manage();
	}

	@Override
	public Navigation navigate() {
		return driver.navigate();
	}

	@Override
	public void quit() {
		driver.quit();
	}

	@Override
	public TargetLocator switchTo() {
		return driver.switchTo();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

}
