package Scratch.AutomationProject;

import java.io.File;
import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageFactory.RegisterElements;

public class TC01_Registration {
	
	WebDriver driver;
	RegisterElements objRegister;
	String driverpath = "C:\\driver\\chromedriver.exe";
	
	@BeforeTest
	public void setup(){
		
		System.setProperty("webdriver.chrome.driver", driverpath);
		driver = new ChromeDriver();
		driver.get("https://dev.automationtesting.in/form");
		
		 File file =    new File(".//UserData.xlss");
		 
		 
		
	}
	
	@Test
	public void registerTest() throws FileNotFoundException{
		objRegister = new RegisterElements(driver);
		
		objRegister.setFirstName("abc");
		objRegister.setLastName("xyz");
		
		
		
	}
	
}
