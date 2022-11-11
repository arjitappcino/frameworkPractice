package Scratch.AutomationProject;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageFactory.RegisterElements;
import pageFactory.TableElements;
import utility.dataFetch;
import utility.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


//@Listeners(utility.TestListener.class)
public class TC01_Registration {

	WebDriver driver;
	RegisterElements objRegister;
	utils objUtility;
	TableElements objTable;
	String driverpath = ".\\driver\\msedgedriver.exe";
	static String file_location = ".\\user.xlsx";
	public static XSSFWorkbook workbook;
	public static XSSFSheet worksheet;
	public static DataFormatter formatter = new DataFormatter();
	// public static String file_location = System.getProperty("user.dir") +
	// "/Akeneo_product";
	static String SheetName = "Sheet1";
	public String mainwindow;
	ExtentSparkReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;

	@BeforeMethod
	public void beforeMethod() throws IOException {
		
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter(".\\extentReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		System.setProperty("webdriver.edge.driver", driverpath);
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://dev.automationtesting.in/form");

	}

	@Test(dataProvider = "registerData")
	public void registerTest(String testCaseName, String firstName, String lastName, String address, String email,
			String phone, String gender, String interests, String languages, String skill, String country,
			String password) throws FileNotFoundException, InterruptedException {

		objRegister = new RegisterElements(driver);
		
		test = extent.createTest("Test 1", "test to register a user");
		test.log(Status.INFO, "Starting test case");

		objRegister.setFirstName(firstName);
		test.pass("First Name set to "+firstName);
		
		objRegister.setLastName(lastName);
		test.pass("Last Name set to "+lastName);
		
		objRegister.setAddress(address);
		test.pass("Address set to "+address);
		
		objRegister.uploadImage();
		test.pass("Image set");
		
		objRegister.setEmail(email);
		test.pass("Email set");
		
		objRegister.setPhone(phone);
		test.pass("Phone set");
		
		objRegister.setGender(gender);
		objRegister.setInterests(interests);
		objRegister.setSkill(skill);
		objRegister.setCountry(country);
		objRegister.setLanguages(languages);
		objRegister.setPassword(password);
		objRegister.setConfirmPassword(password);
		objRegister.clickSubmitBtn();

		objTable = new TableElements(driver);
		objTable.clickLastPageBtn();
		Assert.assertEquals(firstName, objTable.getFirstName(firstName));
		test.pass("firstName validation complete");
	}

	@AfterMethod
	public void afterMethod() {
		extent.flush();
		driver.close();
	}

	@DataProvider
	public Object[][] registerData() throws Exception {

		Object[][] testObjArray = dataFetch.readExcel(file_location, SheetName);

		return (testObjArray);

	}
}
