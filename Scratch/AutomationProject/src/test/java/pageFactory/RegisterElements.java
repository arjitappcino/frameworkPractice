package pageFactory;

import java.util.List;

import org.openqa.selenium.By;
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
	
	@FindAll({@FindBy(xpath = "//legend[contains(text(),'Interested')]/parent::fieldset//label//input")})
	public List<WebElement> interests;
	
	@FindBy(xpath="//label[text()='Languages']/parent::div/div")
	public WebElement languagesLabel;
	
	@FindBy(xpath="//label[text()='Skills']")
	WebElement skillsLabel;
	
	@FindBy(xpath="//label[text()='Country']")
	WebElement countryLabel;
	
	@FindBy(name="confirmPassword")
	WebElement confirmPassword;
	
	@FindBy(name="password")
	WebElement password;
	
	

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
	
	public void setGender(String strGender){
		switch(strGender){
			case "Male": 
				gender.get(1).click();
				break;
			case "Female":
				gender.get(0).click();
			case "Other":
				gender.get(2).click();
		}
	}
	
	public void setInterests(String[] selectedInterest) {
		for(int i=0;i<selectedInterest.length;i++) {
			switch(selectedInterest[i]) {
				case "Automation Testing":
					interests.get(0).click();
					break;
				
				case "Manual Testing":
					interests.get(1).click();
					break;
					
				case "Development":
					interests.get(2).click();
					break;
					
				case "Management":
					interests.get(3).click();
					break;
			}
		}
	}
	
	public void setLanguages(String[] selectedLanguages) throws InterruptedException {
		languagesLabel.click();
		for(int i = 0;i<selectedLanguages.length;i++) {
			WebElement select = driver.findElement(By.xpath("//span[text()='"+selectedLanguages[i]+"']"));
			select.click();
		}
		Thread.sleep(2000);
		confirmPassword.click();
	}
	
	public void setSkill(String strSkill) {
		skillsLabel.click();
		driver.findElement(By.xpath("//li[text()='"+strSkill+"']")).click();
		confirmPassword.click();
	}
	
}
