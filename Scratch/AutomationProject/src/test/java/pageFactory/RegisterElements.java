package pageFactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterElements {
	WebDriver driver;
	
	@FindBy(xpath="//input[@placeholder='First Name']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@placeholder='Last Name']")
	WebElement lastName;
	
	@FindBy(name="address")
	WebElement address;
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="phone")
	WebElement phone;
	
	@FindAll({@FindBy(xpath = "//label[text()='Gender']/parent::div//input")})
	public List<WebElement> gender;
	
	@FindAll({@FindBy(xpath = "//legend[contains(text(),'Interested')]/parent::fieldset//label")})
	public List<WebElement> interests;
	
	@FindBy(xpath="//label[text()='Languages']/parent::div//li")
	public List<WebElement> languages;
	
	@FindBy(xpath="//label[text()='Skills']/parent::div//div/select")
	WebElement skills;
	
	@FindBy(xpath="//label[contains(text(),'Select Country')]/parent::div//div/select")
	WebElement selectCountry;
	
	public RegisterElements(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	public void setFirstName(String strFirstName){
		firstName.sendKeys(strFirstName);
	}
	
	public void setLastName(String strLastName){
		lastName.sendKeys(strLastName);
	}
	
	public void setAddress(String strAddress){
		address.sendKeys(strAddress);
	}
	
	public void setEmail(String strEmail){
		email.sendKeys(strEmail);
	}
	
	public void setPhone(String strPhone){
		phone.sendKeys(strPhone);
	}
	
}
