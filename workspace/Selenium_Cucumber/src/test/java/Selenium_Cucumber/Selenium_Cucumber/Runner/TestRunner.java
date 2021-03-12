package Selenium_Cucumber.Selenium_Cucumber.Runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class) 
@CucumberOptions(
features = "src/test/java/Features"
,glue= {"Selenium_Cucumber/Selenium_Cucumber/stepdefinitions"}
)

public class TestRunner {

}
