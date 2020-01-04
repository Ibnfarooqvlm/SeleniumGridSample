package con.seleniumGrid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SeleniumGridSample {

	WebDriver driver = null;
	@Test
	@Parameters("browser")
	public void launchBrowser(String browserName) throws MalformedURLException {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		switch(browserName) {
		case "CHROME":
			cap.setBrowserName(BrowserType.CHROME);
			cap.setPlatform(Platform.ANY);
			
			ChromeOptions options = new ChromeOptions();
			options.merge(cap);
			
			System.setProperty("webdriver.chrome.driver", "/Users/ahamedabdulrahman/Ahamed/Selenium/chromedriver");
			//driver = new ChromeDriver();
			break;
		case "FIREFOX":
			cap.setBrowserName(BrowserType.FIREFOX);
			cap.setPlatform(Platform.ANY);
			
			FirefoxOptions fOptions = new FirefoxOptions();
			fOptions.merge(cap);
			
			System.setProperty("webdriver.gecko.driver", "/Users/ahamedabdulrahman/Ahamed/Selenium/firefoxdriver");
			//driver = new FirefoxDriver();
			break;
		case "SAFARI":
			cap.setBrowserName(BrowserType.SAFARI);
			cap.setPlatform(Platform.ANY);
			
			SafariOptions sOptions = new SafariOptions();
			sOptions.merge(cap);
			
			//driver = new SafariDriver();
			break;
		}
		
		driver = new RemoteWebDriver(new URL("http://localhost:4444/"), cap);
		
		driver.get("https://api.tekion.xyz/vi/vehicles");
		driver.manage().window().maximize();
		
		driver.quit();
	}
}
