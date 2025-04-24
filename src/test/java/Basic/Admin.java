package Basic;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.Desktop.Action;
import java.time.Duration;
import java.util.Random;

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
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Admin {
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
		
		//Click admin moduale
		driver.findElement(By.xpath("//span[text()='Admin']")).click();
		Thread.sleep(3000);
		
		//click on add button
		driver.findElement(By.xpath("//button[text()=' Add ']")).click();
		Thread.sleep(2000);
		
		//fill add user form
		driver.findElement(By.xpath("//div[@class='oxd-select-wrapper']")).click();
		Thread.sleep(1000);
		Actions act = new Actions(driver);
		//for select option we use action class
		act.keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='oxd-select-wrapper'])[2]")).click();
		act.keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[3]")).sendKeys("admin123");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")).sendKeys("peter");
		Thread.sleep(3000);
		act.keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).perform();
		//To give any string + num value thats why we provide random and int
		Random r = new Random();
		int num = r.nextInt(1000);
		String name = "AnandRao" + num;
		driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys(name);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys("admin123");		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		System.out.println(name);
		WebElement new_user = driver.findElement(By.xpath("//div[text()='"+name+"']"));
		assertTrue(new_user.isDisplayed(),"user is not added");
		Reporter.log("user is added successfully",true);

		Thread.sleep(3000);
		driver.close();		
		
	}
  
}
