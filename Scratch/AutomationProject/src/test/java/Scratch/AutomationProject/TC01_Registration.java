package Scratch.AutomationProject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
	public void setup() throws IOException{
		
		System.setProperty("webdriver.chrome.driver", driverpath);
		driver = new ChromeDriver();
		driver.get("https://dev.automationtesting.in/form");
	
		FileInputStream inputStream = new FileInputStream("D:\\github\\AppcinoPractice\\frameworkPractice\\Scratch\\AutomationProject\\UserData.xlsx");
		 
		XSSFWorkbook UserDataWB = new XSSFWorkbook(inputStream);
		
		XSSFSheet sheet = UserDataWB.getSheetAt(0);
		
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		
		
	}
	
	@Test
	public void registerTest() throws FileNotFoundException{
		objRegister = new RegisterElements(driver);
		
		objRegister.setFirstName("abc");
		objRegister.setLastName("xyz");
		
		
		
	}
	
}