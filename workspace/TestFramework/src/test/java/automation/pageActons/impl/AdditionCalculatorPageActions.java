package automation.pageActons.impl;

import org.openqa.selenium.WebDriver;

import automation.pageActons.interfaces.IAdditionCalculatorPageActions;
import automation.seleniumUtils.SeleniumActions;

public class AdditionCalculatorPageActions extends SeleniumActions implements IAdditionCalculatorPageActions {

	public AdditionCalculatorPageActions(WebDriver driver) {
		super(driver);
	}

	@Override
	public void enterFirstNumber(String firstNumber) throws Exception {

		setText("AdditionCalculator", "FirstNumber", firstNumber);
	}

	@Override
	public void enterSecondNumber(String secondNumber) throws Exception {

		setText("AdditionCalculator", "SecondNumber", secondNumber);
		click("AdditionCalculator", "Submit");
	}

	@Override
	public void clickOnSubmit() {
		click("AdditionCalculator", "Submit");
	}

	@Override
	public String getAdditionResult() {
		return getText("AdditionCalculator", "AdditionResult").trim();
	}

}
