package utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class takeScreenshots {
	
	WebDriver driver;
	
	public takeScreenshots(WebDriver driver) {
		this.driver = driver;
	}
	public void takeSnapShot(String fileWithPath) throws Exception {

		// Convert web driver object to TakeScreenshot

		TakesScreenshot scrShot = ((TakesScreenshot) driver);

		// Call getScreenshotAs method to create image file

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		// Move image file to new destination

		File DestFile = new File(".\\");

		// Copy file at destination

		FileUtils.copyFile(SrcFile, DestFile);

	}
}
