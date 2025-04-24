package Basic;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.BaseClass.BaseOrangeHRM;
import com.crm.pom.AssingmentAdminPage;
import com.crm.pom.PimPage;

public class Test1 extends BaseOrangeHRM{
@Test
	public void main1() throws InterruptedException { //always run @Test class
		
	    Reporter.log("Page Object Model...." , true );
//	    AdminPage admin = new AdminPage(driver);
//	    admin.getadminModule();
	    //Thread.sleep(2000);
//	    admin.getusernameFild("Admin");
//	    Thread.sleep(2000);
//	    
//		admin.getuserRoledropDown();
//		Thread.sleep(2000);
//		
//		admin.getadminOption();
//		Thread.sleep(2000);
//		
//		admin.getessOption();
//		Thread.sleep(2000);
//		
//		admin.getresetButton();
//		Thread.sleep(2000);
//		
//		admin.getsrcButton();
//		Thread.sleep(2000);
//	
//		admin.getadButton();
//		Thread.sleep(2000);
//		
        //for pim module
	    PimPage pim = new PimPage(driver);
	    pim.getpim_Module();
	    Thread.sleep(2000);
		
	    pim.getemp_Name("Admin123");
	    Thread.sleep(2000);
	    
	    pim.getemp_Id("2345");
	    Thread.sleep(2000);
	    
	    pim.getselect_Drop();
	    Thread.sleep(2000);

//	    pim.getemp_Status();
//	    Thread.sleep(2000);
	    
	   pim.getSup_Name("Admin");
	   Thread.sleep(2000);
		
	   pim.getsearch_Button();
	   Thread.sleep(2000);
	   
	   pim.getreset_Button();
	   Thread.sleep(2000);
	   
	   pim.getadd_Button();
	   Thread.sleep(2000);
	   
	}	
}