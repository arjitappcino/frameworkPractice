package Scratch.AutomationProject;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageFactory.RegisterElements;
import utility.dataFetch;
import utility.utils;

//@Listeners(utility.TestListener.class)
public class TC01_Registration {

	WebDriver driver;
	RegisterElements objRegister;
	utils objUtility;
	String driverpath = ".\\driver\\msedgedriver.exe";
	static String file_location = ".\\user.xlsx";
	public static XSSFWorkbook workbook;
	public static XSSFSheet worksheet;
	public static DataFormatter formatter = new DataFormatter();
	// public static String file_location = System.getProperty("user.dir") +
	// "/Akeneo_product";
	static String SheetName = "Sheet1";
	public String mainwindow;
	

	@BeforeMethod
	public void beforeMethod() throws IOException {

		System.setProperty("webdriver.edge.driver", driverpath);
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://dev.automationtesting.in/form");
	}

	@Test(dataProvider = "registerData")
	public void registerTest(String testCaseName, String firstName, String lastName, String address, String email, String phone,
			String gender, String interests, String languages,String skill,String country, String password) throws FileNotFoundException, InterruptedException {
		objRegister = new RegisterElements(driver);
		objRegister.setFirstName(firstName);
		objRegister.setLastName(lastName);
		objRegister.setAddress(address);
		objRegister.setEmail(email);
		objRegister.setPhone(phone);
		objRegister.setGender(gender);
		objRegister.setInterests(interests);
		objRegister.setLanguages(languages);
		objRegister.setSkill(skill);
		objRegister.setCountry(country);
		objRegister.setPassword(password);
		objRegister.setConfirmPassword(password);
		objRegister.clickSubmitBtn();
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

	@DataProvider
	public Object[][] registerData() throws Exception {
		
		Object[][] testObjArray = dataFetch.readExcel(file_location, SheetName);

		return (testObjArray);

	}
}
