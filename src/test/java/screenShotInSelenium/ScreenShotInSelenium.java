package screenShotInSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import library.Reusability;

public class ScreenShotInSelenium {
	
	WebDriver driver;
	@Test
	public  void SSinSelenium() {
		System.setProperty("webdriver.chrome.driver"
				,"D:\\ECLIPSE dxc phase 2\\ScreenShotInSelenium\\BrowserJars\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword123")).sendKeys("admin123");
	}

	@AfterMethod
	public void teardown(ITestResult result) {
		
		if (ITestResult.FAILURE==result.getStatus()) {
			Reusability.CaptureScreenShot(driver, result.getName());
		}
		driver.quit();
	}
}



