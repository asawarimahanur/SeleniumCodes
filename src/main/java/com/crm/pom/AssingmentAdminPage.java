package com.crm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AssingmentAdminPage {
	
	public AssingmentAdminPage(WebDriver driver) {
     PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//span[text()='Admin']")
	private WebElement adminModule;
	public void getadminModule() {
		adminModule.click();
	}
	
	@FindBy(xpath ="(//input[@class='oxd-input oxd-input--active'])[2]")
	private WebElement usernameFild;
	public void getusernameFild(String data) {
		usernameFild.sendKeys(data);
	}

	@FindBy(xpath = "(//div[text()='-- Select --'])[1]")
    private WebElement userRoledropDown;
	public void getuserRoledropDown() {
		userRoledropDown.click();
	}
	
	@FindBy(xpath = "(//div[text()='Admin'])[1]")
	private WebElement adminOption;
	public void getadminOption() {
		adminOption.click();
	}
	
	@FindBy(xpath = "(//div[text()='ESS'])[1]")
	private WebElement essOption;
	public void  getessOption() {
		essOption.click();
	}
	
	@FindBy(xpath = "(//button[@type='button'])[5]")
	private WebElement resetButton;
	public void getresetButton() {
		resetButton.click();
	}
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement srcButton;
	public void getsrcButton() {
		srcButton.click();
	}
	
   @FindBy(xpath = "//i[@class='oxd-icon bi-plus oxd-button-icon']")	
   private WebElement adButton;
   public void getadButton() {
	   adButton.click();
   }
   
}