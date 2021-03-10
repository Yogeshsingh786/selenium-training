package automation.stepDefinitions;

import org.junit.Assert;
import org.junit.runner.RunWith;
import automation.cucumberOptions.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class AdditionCalculator {

	@Given("User is on Propine Addition Calculator")
	public void user_is_on_Propine_Addition_Calculator() throws Exception {
		TestRunner.frm.getTestActions().launchApplication();
	}

	@When("User enters First Number as {string} and Second Number as {string}")
	public void user_enters_First_Number_as_and_Second_Number_as(String firstNumber, String secondNumber) {
		try {
			TestRunner.frm.getTestActions().enterFirstNumber(firstNumber);
			TestRunner.frm.getTestActions().enterSecondNumber(secondNumber);
			TestRunner.frm.getTestActions().clickOnSubmit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("User should get addition result as {string}")
	public void user_should_get_addition_result_as(String expectedResult) {
		String actualResult = TestRunner.frm.getTestActions().getAdditionResult();
		System.out.println("Expected : "+expectedResult+", Actual : "+actualResult);
		Assert.assertEquals(actualResult, expectedResult);
	}

}