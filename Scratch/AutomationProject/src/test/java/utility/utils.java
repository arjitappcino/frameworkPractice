package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class utils {
	
	public static WebDriver driver;
	public utils(WebDriver driver) {
		utils.driver = driver;
	}
	public void scrollTillElementFound(WebElement element) throws InterruptedException {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();;
		Thread.sleep(2000);
	}
	
}
