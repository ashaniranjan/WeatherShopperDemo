package Project.E2EProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {
	public static WebDriver driver; 

	
	/*public void beforeTest(String browser) {

		  // If the browser is Firefox, then do this
    	System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
    	System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
    	//System.setProperty("webdriver.ie.driver", "C:\\Selenium\\IEDriverServer.exe");
    	
		  if(browser.equalsIgnoreCase("firefox")) {
			 
		//Initializing the firefox driver (Gecko)
			  driver = new FirefoxDriver();	  

		  }else if (browser.equalsIgnoreCase("chrome")) { 

			  //Initialize the chrome driver

			  driver = new ChromeDriver();

		  }
	
		driver.get("https://weathershopper.pythonanywhere.com/");
	}*/

}
