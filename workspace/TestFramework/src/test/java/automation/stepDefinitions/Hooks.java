package automation.stepDefinitions;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import automation.commonUtils.Framework;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;

public class Hooks {

	
	@After
    public void killBrowser(Scenario scenario){
		
        if (scenario.isFailed()) {
        WebDriver driver = Framework.getSeleniumWebDriver().getDriver();
         scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES), "image/png");
        }
    }
}
