package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class utility {
	
	public WebDriver driver;
	public utility(WebDriver driver) {
		this.driver = driver;
	}
	public void scrollTillElementFound(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();
	}
	
}
