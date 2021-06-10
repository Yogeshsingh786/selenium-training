package Selenium_Cucumber.Selenium_Cucumber.stepdefinitions;

import java.io.File;
import java.util.concurrent.TimeUnit;


import org.junit.Assert;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.common.io.Files;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RedBus {

	public static WebDriver driver;

	@Given("^user is  on homepage$")
	public void user_is_on_homepage() throws Throwable {
//		System.setProperty("webdriver.gecko.driver", "./src/test/java/resources/driver/geckodriver.exe");
//		driver = new FirefoxDriver();
		
		System.setProperty("webdriver.chrome.driver", "./src/test/java/resources/driver/chromedriver.exe");
		driver = new ChromeDriver();
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
	}

	@When("^user enters source as \"([^\"]*)\"$")
	public void user_enters_source_as(String arg1) throws Throwable {
		driver.findElement(By.id("src")).sendKeys(arg1);
		driver.findElement(By.cssSelector("#src +ul li")).click();
	}

	@When("^user enters destination as \"([^\"]*)\"$")
	public void user_enters_destination_as(String arg1) throws Throwable {
		driver.findElement(By.id("dest")).sendKeys(arg1);
		driver.findElement(By.cssSelector("#dest +ul li")).click();
	}

	@When("^user selects travel date as \"([^\"]*)\"$")
	public void user_selects_travel_date_as(String arg1) throws Throwable {
		driver.findElement(By.id("onward_cal")).click();
		driver.findElement(By.xpath("//div[@id=\"rb-calendar_onward_cal\"]//td[.='" + arg1 + "']")).click();
	}

	@When("^user submits search details$")
	public void user_submits_search_details() throws Throwable {
		driver.findElement(By.id("search_btn")).click();
	}

	@Then("^success message is displayed$")
	public void success_message_is_displayed() throws Throwable {
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		String exp_message = "Buses";

		String actual = driver.findElement(By.cssSelector(".busFound")).getText();
		System.out.println("###### Actual is : " + actual);
		Assert.assertTrue(actual.contains(exp_message));

	}

	@Rule
	public TestRule watcher = new TestWatcher() {
	    
	    @Override
	    public void failed(Throwable e, Description description) {
	        try {
	            File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

	            String filePathRoot = ".\\target\\surefire-reports\\";
	            String fullFilePath = filePathRoot + description.getClassName() + "\\" + description.getMethodName() + ".jpg";

	            Files.copy(screenshot, new File(fullFilePath));
	        } catch(Exception ex) {
	            System.out.println(ex.toString());
	            System.out.println(ex.getMessage());
	        }
	        finally {
	        	driver.quit();
			}
	        
	    }
	};

}
