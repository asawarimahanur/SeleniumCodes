package TestCase1;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.BaseClass.BaseOrangeHRM;
import com.crm.FileUtility.ReadFromExcell;
import com.crm.SeleniumUtility.MouseAndKeyboradMethods;
import com.crm.javaUtility.GenerateNumber;
import com.crm.pom.AdminPOM;
import com.crm.pom.HomePage;

public class AdminModule extends BaseOrangeHRM {
	@Test
	public void tc_001() throws InterruptedException, EncryptedDocumentException, IOException {
		String homePageUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		Thread.sleep(2000);
		
		String actual_homeUrl = driver.getCurrentUrl();
		assertEquals(actual_homeUrl, homePageUrl, "I am not in homepage");
		Reporter.log("I am in home page", true);
	
		HomePage home = new HomePage(driver);
		home.admin();
		
		AdminPOM admin = new AdminPOM(driver);
		admin.add();
		admin.user_role();
		
		MouseAndKeyboradMethods.arrowDown(driver, 1);
		admin.status();
		
		MouseAndKeyboradMethods.arrowDown(driver, 1);
		String password = ReadFromExcell.readExcell("Admin", 1, 1);
		admin.password(password);
		
		String emp_name = ReadFromExcell.readExcell("Admin", 1, 2);
		admin.employee_name(emp_name);
		Thread.sleep(3000);
		
		MouseAndKeyboradMethods.arrowDown(driver, 1);
		String name = ReadFromExcell.readExcell("Admin", 1, 3);
		String username = GenerateNumber.createUserName(name , 10000);
		admin.user_name(username);
		admin.confirm_password(password);
		Thread.sleep(3000);
		admin.submit();
		
		WebElement new_user = driver.findElement(By.xpath("//div[text()='"+username+"']"));
		assertTrue(new_user.isDisplayed(),"user is not added");
		Reporter.log("user is added successfully",true);
		Thread.sleep(10000);
		driver.close();
		//in pom file we cannot store dynamic element only store static element
	}	
}

