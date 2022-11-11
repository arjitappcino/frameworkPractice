package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TableElements {
	
	WebDriver driver;
	
	@FindBy(css="svg[data-testid='LastPageIcon']")
	WebElement lastPageBtn;

	public TableElements(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);
	}
	
	public void clickLastPageBtn() {
		lastPageBtn.click();
	}
	
	public String getFirstName(String strName) {
		return driver.findElement(By.xpath("//tbody//th[text()='"+strName+"']")).getText();
	}
}
