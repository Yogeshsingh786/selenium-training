import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonSearch {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./resources/driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		try {
			ElementFinder ef = new ElementFinder();
			
			Properties envDetails = new Properties();
			envDetails.load(new FileReader(new File("./resources/env.properties")));
			Properties objRepo = new Properties();
			objRepo.load(new FileReader(new File("./resources/objectRepo.properties")));
			
			
			driver.get(envDetails.getProperty("url"));
			
			Thread.sleep(5000);
			
			WebElement searchBox = ef.findElement(driver, objRepo.getProperty("searchBox"+"_TYPE"), objRepo.getProperty("searchBox"+"_VALUE"));
			searchBox.sendKeys(envDetails.getProperty("searchProduct"));
			
			WebElement searchButton = ef.findElement(driver, objRepo.getProperty("searchButton"+"_TYPE"), objRepo.getProperty("searchButton"+"_VALUE"));
			searchButton.click();
			
			Thread.sleep(5000);
			
			WebElement searchResult = ef.findElement(driver, objRepo.getProperty("searchResult"+"_TYPE"), objRepo.getProperty("searchResult"+"_VALUE"));
			
			if(searchResult.getText().equals("\""+envDetails.getProperty("searchProduct")+"\"")) {
				System.out.println("Search Feature is OK.");
			}
			else
				throw new Exception("Search Result does not match. Actual :"+searchResult.getText()+" ,Expected :"+envDetails.getProperty("searchProduct"));
			
			
			List<WebElement> resultList = ef.findElements(driver, objRepo.getProperty("listOfResults_TYPE"), objRepo.getProperty("listOfResults_VALUE"));
			
			for(WebElement e : resultList) {
				WebElement title = ef.findElement(e, objRepo.getProperty("productTitle_TYPE"), objRepo.getProperty("productTitle_VALUE"));
				WebElement price = ef.findElement(e, objRepo.getProperty("productPrice_TYPE"), objRepo.getProperty("productPrice_VALUE"));
				System.out.println("Title : "+title.getText()+" ###### "+price.getText());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			driver.quit();
		}
	}

}
