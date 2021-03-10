package automation.cucumberOptions;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import automation.commonUtils.Framework;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/automation/features", glue = "automation/stepDefinitions", monochrome = true, plugin = {
		"pretty", "json:target/cucumber.json", "html:target/test-report" })
public class TestRunner {

	public static Framework frm;

	@BeforeClass
	public static void setup() throws Exception {
		frm = new Framework();
		frm.initTestExecuter();
	}

	@AfterClass
	public static void teardown() {
		frm.getTestActions().quit();
	}
}
