
 
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTesting {
    WebDriver driver;
	@BeforeClass
	@Parameters("browser")
	public void setup(String browser) throws Exception{
		//Check if parameter passed from TestNG is 'firefox'
		if(browser.equalsIgnoreCase("firefox")){
		System.out.println("1");
			//create firefox instance
			System.setProperty("webdriver.gecko.driver", "D:\\SeleniumSoftwares\\geckodriver.exe");
			//DesiredCapabilities capabilities=DesiredCapabilities.firefox();
			//capabilities.setCapability("marionette", true);
			 driver = new FirefoxDriver();
		}
		//Check if parameter passed as 'chrome'
		else if(browser.equalsIgnoreCase("chrome")){
			//set path to chromedriver.exe
			System.setProperty("webdriver.chrome.driver","D:\\SeleniumSoftwares\\chromedriver.exe");
			//create chrome instance
			driver = new ChromeDriver();
		}
		//Check if parameter passed as 'Edge'
				else if(browser.equalsIgnoreCase("Edge")){
					//set path to Edge.exe
					System.setProperty("webdriver.edge.driver","D:\\SeleniumSoftwares\\msedgedriver.exe");
					//create Edge instance
					driver = new EdgeDriver();
				}
else{
   //If no browser passed throw exception
   throw new Exception("Browser is not correct");
  }
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 }
@Test
	public void testParameterWithXML() throws InterruptedException{
		driver.get("https://www.facebook.com/");
		//Find user name
		WebElement userName = driver.findElement(By.id("email"));
		//Fill user name
		userName.sendKeys("entri@gmail.com");
		//Find password
		WebElement password = driver.findElement(By.id("pass"));
		//Fill password
		password.sendKeys("entri1234");
		driver.close();
	}
	
	
	
	
	
}
