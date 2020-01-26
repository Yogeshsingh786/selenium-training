import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoogleSearch {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./resources/driver/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "./resources/driver/geckodriver.exe");
		WebDriver driver = new ChromeDriver();
//		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.amazon.in/");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		WebElement searchBox = driver.findElement(By.name("q"));
//		searchBox.sendKeys("batman");
//		driver.findElement(By.id("hplogo")).click();
//		driver.findElement(By.xpath("//input[@value='Google Search']")).submit();
//		
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		driver.close();
		driver.quit();
		
	}
}
