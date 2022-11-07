package Scratch.AutomationProject;


import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageFactory.RegisterElements;
import utils.utility;

public class TC01_Registration {
	
	WebDriver driver;
	RegisterElements objRegister;
	utility objUtility;
	String driverpath = "C:\\driver\\chromedriver.exe";
	
	@BeforeTest
	public void setup() throws IOException{
		
		System.setProperty("webdriver.chrome.driver", driverpath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://dev.automationtesting.in/form");
	
		/*FileInputStream inputStream = new FileInputStream("D:\\github\\AppcinoPractice\\frameworkPractice\\Scratch\\AutomationProject\\UserData.xlsx");
		 
		XSSFWorkbook UserDataWB = new XSSFWorkbook(inputStream);
		
		XSSFSheet sheet = UserDataWB.getSheetAt(0);
		
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);*/
		
		
	}
	
	@Test
	public void registerTest() throws FileNotFoundException, InterruptedException{
		objRegister = new RegisterElements(driver);
		objUtility = new utility(driver);
		
		objRegister.setFirstName("abc");
		objRegister.setLastName("xyz");
		objRegister.setAddress("address abcxyz");
		objRegister.setEmail("abcxyz@gmail.com");
		objRegister.setPhone("1234567890");
		objRegister.setGender("Male");
		String[] selectInterests = {"Automation Testing","Development"};
		objRegister.setInterests(selectInterests);
		WebElement clrBtn = driver.findElement(By.xpath("//button[contains(text(),'Clear')]"));
		//objUtility.scrollTillElementFound(conBtn);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", clrBtn);
		Thread.sleep(2000);
		String[] selectLanguages = {"Arabic","Filipino"};
		objRegister.setLanguages(selectLanguages);
		objRegister.setSkill("APIs");
		
		
		
		
		
		
		
	}
	
}
