package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import utility.utils;

public class RegisterElements {
	WebDriver driver;
	utils objUtility;
	Actions action;
	//static Logger log = Logger.getLogger(RegisterElements.class);
	
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
	
	@FindBy(xpath="//label[text()='Languages']/parent::div/div")
	public WebElement languagesLabel;
	
	@FindBy(xpath="//label[text()='Skill']/following::div/div")
	WebElement skillsLabel;
	
	@FindBy(xpath="//div[@id='country-select']")
	WebElement countryLabel;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(name="confirmPassword")
	WebElement confirmPassword;
	
	@FindBy(xpath="//button[contains(text(),'Submit')]")
	WebElement submitBtn;
	
	@FindBy(xpath="//input[@type='file']")
	WebElement uploadImg;

	public RegisterElements(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);
        objUtility = new utils(driver);
        action = new Actions(driver);
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
	
	public void setGender(String strGender) throws InterruptedException{
		driver.findElement(By.xpath("//span[text()='" + strGender + "']/parent::label//input")).click();
	}
	
	public void setInterests(String selectedInterest) throws InterruptedException {
		objUtility.scrollTillElementFound(phone);
		String[] arrSelectedInterest = selectedInterest.split(",");
		for(int i=0;i<arrSelectedInterest.length;i++) {
			driver.findElement(By.xpath("//span[text()='" + arrSelectedInterest[i] + "']/parent::label//input")).click();
		}
	}
	
	public void setLanguages(String selectedLanguages) throws InterruptedException {
		String[] arrSelectedLanguages = selectedLanguages.split(",");
		languagesLabel.click();
		for(int i = 0;i<arrSelectedLanguages.length;i++) {
			driver.findElement(By.xpath("//span[text()='"+arrSelectedLanguages[i]+"']")).click();
		}
		action.sendKeys(Keys.ESCAPE).perform();
		Thread.sleep(2000);
	}
	
	public void setSkill(String strSkill) throws InterruptedException {
		//objUtility.scrollTillElementFound(languagesLabel);
		skillsLabel.click();
		driver.findElement(By.xpath("//li[@data-value='"+strSkill+"']")).click();
		Thread.sleep(1000);
	}
	
	public void setCountry(String strCountry) {
		countryLabel.click();
		driver.findElement(By.xpath("//li[@data-value='"+strCountry+"']")).click();
	}
	
	public void setPassword(String strPassword) {
		password.sendKeys(strPassword);
	}
	
	public void setConfirmPassword(String strConfirmPassword) {
		confirmPassword.sendKeys(strConfirmPassword);
	}
	
	public void clickSubmitBtn() throws InterruptedException {
		submitBtn.click();
		Thread.sleep(2000);
	}
	
//	public void uploadImage() throws InterruptedException {
//		uploadImg.sendKeys("D:\\GIT Automation Practice\\frameworkPractice\\Scratch\\AutomationProject\\image.png");
//		Thread.sleep(2000);
//	}
	
	public void uploadImageSikuli() throws FindFailed, InterruptedException {
		Screen s = new Screen();
		Pattern fileInputTextBox = new Pattern("D:\\GIT Automation Practice\\frameworkPractice\\Scratch\\AutomationProject\\FileTextBox.png");
		Pattern openButton = new Pattern("D:\\GIT Automation Practice\\frameworkPractice\\Scratch\\AutomationProject\\OpenButton.png");
		
		uploadImg.click();
		
		s.wait(fileInputTextBox, 20);
		s.type(fileInputTextBox, "D:\\GIT Automation Practice\\frameworkPractice\\Scratch\\AutomationProject\\user.xlsx");
		Thread.sleep(2000);
		s.click(openButton);
		
	}
	
}
