package Scratch.AutomationProject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageFactory.RegisterElements;

public class TC01_Registration {
	
	WebDriver driver;
	RegisterElements objRegister;
	String driverpath = "C:\\drivers\\chromedriver.exe";
	
	@BeforeTest
	public void setup(){
		
		System.setProperty("webdriver.chrome.driver", driverpath);
		driver = new ChromeDriver();
		driver.get("https://dev.automationtesting.in/form");
		
	}
	
	@Test
	public void registerTest() throws FileNotFoundException{
		objRegister = new RegisterElements(driver);
		FileInputStream fs = new FileInputStream("D:\\UserData.xlsx");
		
	}
	
}
