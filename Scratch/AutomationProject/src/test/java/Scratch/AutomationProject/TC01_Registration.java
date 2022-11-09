package Scratch.AutomationProject;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageFactory.RegisterElements;
import utility.dataFetch;
import utility.utils;

public class TC01_Registration {

	WebDriver driver;
	RegisterElements objRegister;
	utils objUtility;
	String driverpath = "C:\\driver\\chromedriver.exe";
	static String file_location = "D:\\GIT Automation Practice\\frameworkPractice\\Scratch\\AutomationProject\\userData.xlsx";
	public static XSSFWorkbook workbook;
	public static XSSFSheet worksheet;
	public static DataFormatter formatter = new DataFormatter();
	// public static String file_location = System.getProperty("user.dir") +
	// "/Akeneo_product";
	static String SheetName = "Sheet1";

	@BeforeMethod
	public void beforeMethod() throws IOException {

		System.setProperty("webdriver.chrome.driver", driverpath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://dev.automationtesting.in/form");
	}

//	  public static Object[][] registerData() {
//
//	        // The number of times data is repeated, test will be executed the same no. of times
//
//	        // Here it will execute two times
//
//	        return new Object[][] {
//	        	{ "abc", "xyz", "address ABCXYZ", "abc@gmail.com", "9876543210", "Male" },
//	        	{ "abc1", "xyz1", "address ABC1XYZ1", "abc1@gmail.com", "8765490322", "Female" },
//	        	{ "abc2", "xyz2", "address ABC2XYZ2", "abc2@gmail.com", "8727183288", "Other" }
//	        										
//	        };
//
//	  }

	@Test(dataProvider = "registerData")
	public void registerTest(String testCaseName, String firstName, String lastName, String address, String email, String phone,
			String gender) throws FileNotFoundException, InterruptedException {
		objRegister = new RegisterElements(driver);
		objUtility = new utils(driver);
		System.out.println(testCaseName);
		objRegister.setFirstName(firstName);
		objRegister.setLastName(lastName);
		objRegister.setAddress(address);
		objRegister.setEmail(email);
		objRegister.setPhone(phone);
		objRegister.setGender(gender);
//		String[] selectInterests = { "Automation Testing", "Development" };
//		objRegister.setInterests(selectInterests);

//		WebElement clrBtn = driver.findElement(By.name("password"));
//		// objUtility.scrollTillElementFound(conBtn);
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", clrBtn);
//		Thread.sleep(2000);
//		String[] selectLanguages = { "Arabic", "Filipino" };
//		objRegister.setLanguages(selectLanguages);
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
