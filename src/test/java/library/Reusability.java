package library;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Reusability {
	public static void CaptureScreenShot(WebDriver driver, String screenShotName) {
		
		try {
			//Can't Create Instance of Interface. we can typecast
			TakesScreenshot ts = (TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			//where to store ScreenShot
			FileUtils.copyFile(src, new File("./Screenshots/"+ screenShotName + ".png"));
			System.out.println("Captured Screenshot- By Selenium Webdriver");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception While taking ScreenShot"+ e.getMessage());
		}
		
	}

}
