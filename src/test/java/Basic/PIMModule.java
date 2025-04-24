package Basic;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class PIMModule {
	public static WebDriver driver = null;
	@Test
	public void TC_001() throws InterruptedException {
	String expected_url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	
	String homePageUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
	
	String browser = "chrome";
	if(browser.equalsIgnoreCase("chrome")) {
		driver=new ChromeDriver();
	}	
	else if(browser.equalsIgnoreCase("firefox")) {
		driver=new FirefoxDriver();
	}
	else if(browser.equalsIgnoreCase("edge")) {
		driver=new EdgeDriver();
	}
	else if(browser.equalsIgnoreCase("internetExplorer")) {
		driver=new InternetExplorerDriver();
		
	}
	else if(browser.equalsIgnoreCase("safari")) {
		driver=new SafariDriver();
	}
	else {
		driver=new ChromeDriver();
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	
	String actual_url = driver.getCurrentUrl();
	//compare two url by using assert equals method
	assertEquals(actual_url, expected_url, "I am not in orangeHRM");
	Reporter.log("I am in orangeHRM", true);
	driver.findElement(By.name("username")).sendKeys("Admin");
	driver.findElement(By.name("password")).sendKeys("admin123");
	driver.findElement(By.xpath("//button[text()=' Login ']")).click();
	Thread.sleep(2000);
	
	String actual_homeurl = driver.getCurrentUrl();
	assertEquals(actual_homeurl, homePageUrl,"I not in home page");
	Reporter.log("I am in homePage", true);
    Thread.sleep(2000);
   
    //click on pim module
    driver.findElement(By.xpath("(//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'])[2]")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")).click();
    Thread.sleep(1000);
    driver.findElement(By.name("firstName")).sendKeys("ABCD");
    Thread.sleep(1000);
    driver.findElement(By.name("middleName")).sendKeys("E");
    Thread.sleep(1000);
    driver.findElement(By.name("lastName")).sendKeys("XYZ");
    Thread.sleep(1000);
//    driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys("666");
//    Thread.sleep(1000);
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    Thread.sleep(2000);
    driver.findElement(By.linkText("Employee List")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("(//input[@placeholder='Type for hints...'])[1]")).sendKeys("ABCD");
    Thread.sleep(3000);
    Actions act = new Actions(driver);
    act.keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).perform();
    Thread.sleep(2000);
    
    //driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys("666");
    Thread.sleep(2000);
     WebElement emp_status = driver.findElement(By.xpath("(//div[@class='oxd-select-text--after'])[1]"));
     Select option = new Select(emp_status);
     option.selectByVisibleText("Full-Time Contract");
     driver.findElement(By.xpath("(//input[@placeholder='Type for hints...'])[2]")).sendKeys("PQRS");
     
    
   // act.keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).perform();
   
    driver.close();
    
	}
}
