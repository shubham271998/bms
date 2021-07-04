package Automation.BookMyShow;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


//class for remote driver using selenium grid
public class DriverSetup {
	
	public static WebDriver getRemoteWebDriver(String value) throws MalformedURLException {
		if(value == "chrome") {
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		String remoteHubURL = "http://localhost:4444/wd/hub";
		RemoteWebDriver driver = new RemoteWebDriver(new URL(remoteHubURL), caps);
		return driver;
		}
		else {
			DesiredCapabilities caps = DesiredCapabilities.firefox();
			String remoteHubURL = "http://localhost:4444/wd/hub";
			RemoteWebDriver driver = new RemoteWebDriver(new URL(remoteHubURL), caps);
			return driver;
		}
	}

}
