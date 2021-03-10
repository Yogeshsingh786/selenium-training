package automation.seleniumUtils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;


import automation.commonUtils.Framework;

/**
 * 
 * @author YSingh
 *
 */
public class ElementManager extends Framework {

	static long DEFAULT_TIMEOUT = Framework.waitTime;
	static long DEFAULT_SLEEP_TIME = 5;
	public SeleniumWaits waits;
	public static WebElement getElement(SearchContext searchContext, String pageName, String elementName) {
		try {
			
			return findElement(Framework.objectRepo.getObjectLocator(pageName, elementName), DEFAULT_TIMEOUT,
					DEFAULT_SLEEP_TIME);
		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}
	}
	
	public static WebElement getElement(SearchContext searchContext, String pageName, String elementName,int index) {
		try {
			return findElement(Framework.objectRepo.getObjectLocatorWithIndex(pageName, elementName,index), DEFAULT_TIMEOUT,
					DEFAULT_SLEEP_TIME);
		} catch (Exception e) {
			
			return null;

		}
	}
	
	public static WebElement getElement(SearchContext searchContext, String pageName, String elementName,String textValue) {
		try {
			return findElement(Framework.objectRepo.getObjectLocatorWithTextValue(pageName, elementName,textValue), DEFAULT_TIMEOUT,
					DEFAULT_SLEEP_TIME);
		} catch (Exception e) {
			
			return null;

		}
	}
	
	public static WebElement getElement(SearchContext searchContext, String pageName, String elementName,String textValue,int index) {
		try {
			return findElement(Framework.objectRepo.getObjectLocatorWithTextAndIndex(pageName, elementName,textValue,index), DEFAULT_TIMEOUT,
					DEFAULT_SLEEP_TIME);
		} catch (Exception e) {
			
			return null;

		}
	}
	
	
	
	public static WebElement getElementFromElement(SearchContext searchContext, String pageName, String elementName) {
		try {
			return findElementFromElement(searchContext,Framework.objectRepo.getObjectLocator(pageName, elementName));
		} catch (Exception e) {
			
			return null;

		}
	}
	
	public static WebElement getElementFromElement(SearchContext searchContext, String pageName, String elementName,int index) {
		try {
			return findElementFromElement(searchContext,Framework.objectRepo.getObjectLocatorWithIndex(pageName, elementName,index));
		} catch (Exception e) {
			
			return null;

		}
	}

	public static List<WebElement> getAllElements(SearchContext searchContext, String pageName, String elementName) {
		try {
			return findElements(Framework.objectRepo.getObjectLocator(pageName, elementName), DEFAULT_TIMEOUT,
					DEFAULT_SLEEP_TIME);

		} catch (Exception e) {
			
			return null;
		}

	}
	
	public static List<WebElement> getAllElements(SearchContext searchContext, String pageName, String elementName, String value) {
		try {
			return findElements(Framework.objectRepo.getObjectLocatorWithTextValue(pageName, elementName,value), DEFAULT_TIMEOUT,
					DEFAULT_SLEEP_TIME);

		} catch (Exception e) {
			
			return null;
		}

	}
	public static WebElement findElement(final By locator) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriverInstance())
				.withTimeout(Duration.ofSeconds(DEFAULT_TIMEOUT)).pollingEvery(Duration.ofSeconds(DEFAULT_SLEEP_TIME))
				.ignoring(NoSuchElementException.class);

		return wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				WebElement element = driver.findElement(locator);
				if (element != null)
					System.out.println("Element found by " + locator + ". Hence returning element.");
				return element;
			}
		});
	}
	
	private static WebElement findElement(final By locator, long timeoutSeconds, long sleepMilliSeconds) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriverInstance())
				.withTimeout(Duration.ofSeconds(DEFAULT_TIMEOUT)).pollingEvery(Duration.ofSeconds(DEFAULT_SLEEP_TIME))
				.ignoring(NoSuchElementException.class);

		return wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				WebElement element = driver.findElement(locator);
				if (element != null)
					System.out.println("Element found by " + locator + ". Hence returning element.");
				return element;
			}
		});
	}

	public static ArrayList<WebElement> findElements(final By locator, long timeoutSeconds, long sleepMilliSeconds) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriverInstance())
				.withTimeout(Duration.ofSeconds(DEFAULT_TIMEOUT)).pollingEvery(Duration.ofSeconds(DEFAULT_SLEEP_TIME))
				.ignoring(NoSuchElementException.class);

		List<WebElement> element = wait.until(new Function<WebDriver, List<WebElement>>() {
			public List<WebElement> apply(WebDriver driver) {
				List<WebElement> elements = driver.findElements(locator);
				if (elements != null && !elements.isEmpty())
					System.out
							.println(elements.size() + " Elements found by " + locator + ". Hence returning elements.");
				else if (elements.isEmpty())
					throw new NoSuchElementException("Elements not found by " + locator);
				return elements;
			}
		});
		return (ArrayList<WebElement>) element;
	}

	public ArrayList<WebElement> findElements(By locator) {
		try {
			return findElements(locator, DEFAULT_TIMEOUT, DEFAULT_SLEEP_TIME);
		} catch (TimeoutException e) {
			System.out.println("Exception : Elements not found.\n Cause : Elements not found by " + locator
					+ ". Returning empty Array List of WebElement.");
			return new ArrayList<WebElement>();
		}
	}

	public static WebElement findElementFromElement(SearchContext contextElement, final By locator, long timeoutSeconds,
			long sleepSeconds) {
		Wait<SearchContext> wait = new FluentWait<SearchContext>(contextElement)
				.withTimeout(Duration.ofSeconds(DEFAULT_TIMEOUT)).pollingEvery(Duration.ofSeconds(DEFAULT_SLEEP_TIME))
				.ignoring(NoSuchElementException.class);
		WebElement element = wait.until(new Function<SearchContext, WebElement>() {
			public WebElement apply(SearchContext context) {
				if (context != null)
					System.out.println("Locating element by " + locator + " in the search context.");
				else {
					return null;
				}
				WebElement element = context.findElement(locator);
				if (element != null)
					System.out.println(
							"Element found by " + locator + " in the search context. Hence returning element.");
				return element;
			}
		});
		return element;
	}

	public static WebElement findElementFromElement(SearchContext contextElement, By locator) {
		try {
			return findElementFromElement(contextElement, locator, DEFAULT_TIMEOUT, DEFAULT_SLEEP_TIME);
		} catch (TimeoutException e) {
			System.out
					.println("Exception : Element not found inside the search context.\n Cause : Element not found by "
							+ locator + ". Hence returning null element.");
			return null;
		}
	}

	public ArrayList<WebElement> findElementsFromElement(SearchContext contextElement, final By locator,
			long timeoutSeconds, long sleepSeconds) {
		Wait<SearchContext> wait = new FluentWait<SearchContext>(contextElement)
				.withTimeout(Duration.ofSeconds(DEFAULT_TIMEOUT)).pollingEvery(Duration.ofSeconds(DEFAULT_SLEEP_TIME))
				.ignoring(NoSuchElementException.class);
		List<WebElement> element = wait.until(new Function<SearchContext, List<WebElement>>() {
			public List<WebElement> apply(SearchContext context) {
				if (context != null)
					System.out.println("Locating elements by " + locator + " in the search context.");
				else {
					return new ArrayList<>();
				}
				List<WebElement> elements = context.findElements(locator);
				if (elements != null && !elements.isEmpty())
					System.out.println(elements.size() + " Elements found by " + locator
							+ " in the search context. Hence returning element.");
				else if (elements.isEmpty())
					throw new NoSuchElementException("Elements not found by " + locator);
				return elements;
			}
		});
		return (ArrayList<WebElement>) element;
	}

	public ArrayList<WebElement> findElementsFromElement(SearchContext contextElement, By locator) {
		try {
			return findElementsFromElement(contextElement, locator, DEFAULT_TIMEOUT, DEFAULT_SLEEP_TIME);
		} catch (TimeoutException e) {
			System.out
					.println("Exception : Elements not found inside the search context.\n Cause : Element not found by "
							+ locator + ". Returning empty Array List of WebElement.");
			return new ArrayList<>();
		}
	}

}
