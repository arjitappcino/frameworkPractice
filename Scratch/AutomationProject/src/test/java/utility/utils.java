package utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class utils {
	
	public static WebDriver driver;
	public utils(WebDriver driver) {
		utils.driver = driver;
	}
	public void scrollTillElementFound(WebElement element) throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(3000);
	}
	
}
