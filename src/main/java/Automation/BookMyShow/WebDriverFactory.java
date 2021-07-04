package Automation.BookMyShow;

import java.net.MalformedURLException;

//IMPORTS
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
//import org.testng.annotations.Parameters;


//Class to handle different browsers
public class WebDriverFactory {
	
	 private static WebDriver driver;
	 private static String userDIR;
	 
	//Getter 
	public  static WebDriver getDriver() {
		return driver;
	}
	
	//Setter
	public static WebDriver setDriver(String browser) throws Exception {
		userDIR = System.getProperty("user.dir");
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", userDIR+"\\WebDrivers\\chromedriver.exe"); //Setting Property
			driver  = new ChromeDriver();																//creating driver object
		    //driver = DriverSetup.getRemoteWebDriver("chrome");
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", userDIR+"\\WebDrivers\\geckodriver.exe");  //Setting Property
			driver  = new FirefoxDriver();																//creating driver object
			//driver = DriverSetup.getRemoteWebDriver("firefox");
		}
		else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.msedge.driver", "userDIR+\\WebDrivers\\msedgedriver.exe");  //Setting Property
			driver  = new EdgeDriver();																			//creating driver object
		}
		else if (browser.equalsIgnoreCase("opera")) {
			System.setProperty("webdriver.opera.driver", "\\\\WebDrivers\\operadriver.exe");  //Setting Property
			driver  = new OperaDriver();														//creating driver object
		}
		return driver;
	}
	
	

}

