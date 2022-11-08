package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class utils {
	
	public WebDriver driver;
	public utils(WebDriver driver) {
		this.driver = driver;
	}
	public void scrollTillElementFound(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();
	}
	
}
