package Automation.BookMyShow;

import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.ScreenshotException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

//implementation of login using google
public class loginFunctionalityTest {
	String userDIR = System.getProperty("user.dir");
	String mainPageHandle;
	JavascriptExecutor js;
	  //Initializing the driver
	    WebDriver driver;
	    Properties prop = new Properties();
	    ExtentReports report = ExtentReportManager.getReportInstance();
	    
	   @Parameters({"browser","Path0"})
	    @BeforeTest
	    public void setup(String browser, String Path0) throws Exception{
 
	    driver = WebDriverFactory.setDriver(browser);
         
	   driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
	   driver.manage().window().maximize();
	   
	   
	   try{ScreenShotFunctionality.takeSnapShot(driver, userDIR + Path0 );} //Take Screenshot
		catch(ScreenshotException e) {System.out.println("Unable to take Screen Shot");}

	    }
	    
	 
	   //test method to open the browser
	    @Parameters({"URL","Path1"})
	    @Test(priority = 0)
	    public void openBrowser(String URL, String Path1) throws Exception{
	    	
	    	//addition of extent report
	    	ExtentTest logger = report.createTest("openBrowser");
	    	
	    	//opening the page 
	    	logger.log(Status.INFO, "Initializing the Browser ");
	    	
	    	driver.get(URL);
	    	//getting the page title
	    	String title = driver.getTitle(); 
	    	
	    	String expectedTitle =  "Movie Tickets, Plays, Sports, Events & Cinemas nearby - BookMyShow";
	    	
	    	//Checking if the right page opened
	    	Assert.assertEquals(title, expectedTitle); //Checking expected and actual result
	    	//Waiting 
	    	 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	    	 
	    	 //screenshot taken
	    	 try{ScreenShotFunctionality.takeSnapShot(driver, userDIR + Path1 );} //Take Screenshot
	 		catch(ScreenshotException e) {System.out.println("Unable to take Screen Shot");}
	    }
	    
	    
	    //select the city as NCR 
	    @Parameters({"Path2","Path3"})
	    @Test(priority = 1)
	    public void signUpNCR(String Path2, String Path3) throws Exception{
	    	
	    	
	    	//get the main page handle
	        mainPageHandle = driver.getWindowHandle();
	        
	        //extent report
           ExtentTest logger = report.createTest("select city");
	    	
	        try{ScreenShotFunctionality.takeSnapShot(driver, userDIR + Path2 );} //Take Screenshot
	 		catch(ScreenshotException e) {System.out.println("Unable to take Screen Shot");}
	                
	        
            driver.findElement(By.xpath("//button[@class='Sign me Up!']")).click();
	    	
    
            //select the city as 'NCR'
            logger.log(Status.INFO, "select city");
          driver.findElement(By.xpath("//img[@alt='NCR']")).click();
   
          try{ScreenShotFunctionality.takeSnapShot(driver, userDIR + Path3 );} //Take Screenshot
	 		catch(ScreenshotException e) {System.out.println("Unable to take Screen Shot");}
            
	    }
	    
	    
	    //signup button
	    @Parameters("Path4")
	    @Test(priority = 2)
	    public void signUp(String Path4) throws Exception{
	    	ExtentTest logger = report.createTest("signin");
	    	logger.log(Status.INFO, "signin initializing");
	    	 driver.findElement(By.xpath("//div[text()='Sign in']")).click();
	    	 
	    	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    	 
	    	 try{ScreenShotFunctionality.takeSnapShot(driver, userDIR + Path4 );} //Take Screenshot
		 		catch(ScreenshotException e) {System.out.println("Unable to take Screen Shot");}
             
	    }
	    
	    @Parameters("Path5")
	    @Test(priority = 3)
	    public void signUpUsingGoogle(String Path5) throws Exception{
	    	//click on google link
	    	ExtentTest logger = report.createTest("signUpUsingGoogle");
	    	logger.log(Status.INFO, "google link clicked");
            driver.findElement(By.xpath("//*[@id=\"modal-root\"]/div/div/div/div/div[2]/div/div[1]/div/div[2]/div/div")).click();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            
            try{ScreenShotFunctionality.takeSnapShot(driver, userDIR + Path5 );} //Take Screenshot
	 		catch(ScreenshotException e) {System.out.println("Unable to take Screen Shot");
	 		}
	    }
	    
	    @Parameters("Path6")
	    @Test(priority = 4)
	    public void switchWindow(String Path6) throws Exception{
	    	 //get all the window links
	    	ExtentTest logger = report.createTest("switchWindow");
	    	logger.log(Status.INFO, "window switched");
            Set<String> windowIDs = driver.getWindowHandles();
            
            //get the title of sign in window
            String title = "Sign in – Google accounts";
            String currentWindow = driver.getWindowHandle();
            driver.switchTo().window(currentWindow);
           // System.out.println(windowIDs);
            
            for(String winHandle : windowIDs){
    			
      		  //checking the title of window is equal to "Visit Us" or not 
      		     if (driver.switchTo().window(winHandle).getTitle().equals(title)) {
      		    	 
      		    	 driver.findElement(By.xpath("//*[@id='identifierId']")).sendKeys("srao9152@hds.com");
      		    	 
      		    	 //click on next button
      		    	 driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span")).click(); 
      		    	 
      		    	 //get the error message
      		    	 String errmsg = driver.findElement(By.xpath("//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div/div[2]/div[2]/div")).getText();
      		    	 System.out.println(errmsg);
      		    	 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
      			 	 //System.out.println(winHandle);
      			 	 //System.out.println(mainPageHandle);
      			 	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      			 	 driver.switchTo().window(mainPageHandle); //navigate to the main page window
      		     } 
      		     else {
      		        driver.switchTo().window(currentWindow);
      		     } 
      		  }
            
          
	    }
	    
	    @AfterTest
		// function to close the driver
		public void closeDriver() {
	    	report.flush();
			driver.quit();
		}

}
