package automation.pageActons.interfaces;

public interface IAdditionCalculatorPageActions {

	public void enterFirstNumber(String firstNumber) throws Exception ;
	public void enterSecondNumber(String secondNumber) throws Exception;
	public void clickOnSubmit();
	public String getAdditionResult();
}
