package automation.pageActons;

import org.openqa.selenium.WebDriver;

import automation.pageActons.impl.AdditionCalculatorPageActions;
import automation.pageActons.interfaces.IAdditionCalculatorPageActions;
import automation.seleniumUtils.SeleniumActions;

public class PropinePageActions extends SeleniumActions implements IAdditionCalculatorPageActions{

	private AdditionCalculatorPageActions additionCalculatorActObj;
	
	public PropinePageActions(WebDriver driver) {
		super(driver);
		additionCalculatorActObj = new AdditionCalculatorPageActions(driver);
	}


	@Override
	public String getAdditionResult() {
		return additionCalculatorActObj.getAdditionResult();
	}

	@Override
	public void enterFirstNumber(String firstNumber) throws Exception {
		additionCalculatorActObj.enterFirstNumber(firstNumber);
		
	}

	@Override
	public void enterSecondNumber(String secondNumber) throws Exception {
		additionCalculatorActObj.enterSecondNumber(secondNumber);
	}

	@Override
	public void clickOnSubmit() {
		additionCalculatorActObj.clickOnSubmit();
	}
}
