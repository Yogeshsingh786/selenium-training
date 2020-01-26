import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

public class ElementFinder {

	public WebElement findElement(SearchContext searchContext, String locatorType, String locatorValue) throws Exception {
		switch (locatorType.trim().toLowerCase()) {

		case "id":
			return searchContext.findElement(By.id(locatorValue));
		case "name":
			return searchContext.findElement(By.name(locatorValue));
		case "xpath":
			return searchContext.findElement(By.xpath(locatorValue));
		case "css":
			return searchContext.findElement(By.cssSelector(locatorValue));
		case "className":
			return searchContext.findElement(By.className(locatorValue));
		case "linkText":
			return searchContext.findElement(By.linkText(locatorValue));
		case "partialLinkText":
			return searchContext.findElement(By.partialLinkText(locatorValue));
		case "tagName":
			return searchContext.findElement(By.tagName(locatorValue));
		default:
			throw new Exception("Invalid Locator Type : "+locatorType);
		}
	}
	
	public List<WebElement> findElements(SearchContext searchContext, String locatorType, String locatorValue) throws Exception {
		switch (locatorType.trim().toLowerCase()) {

		case "id":
			return searchContext.findElements(By.id(locatorValue));
		case "name":
			return searchContext.findElements(By.name(locatorValue));
		case "xpath":
			return searchContext.findElements(By.xpath(locatorValue));
		case "css":
			return searchContext.findElements(By.cssSelector(locatorValue));
		case "className":
			return searchContext.findElements(By.className(locatorValue));
		case "linkText":
			return searchContext.findElements(By.linkText(locatorValue));
		case "partialLinkText":
			return searchContext.findElements(By.partialLinkText(locatorValue));
		case "tagName":
			return searchContext.findElements(By.tagName(locatorValue));
		default:
			throw new Exception("Invalid Locator Type : "+locatorType);

		}
	}
}
