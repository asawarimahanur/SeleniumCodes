package com.crm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Admin {
	public  Admin(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
		@FindBy(xpath = "//span[text()='Admin']")
		private WebElement admin;
		
		public void admin() {
			admin.click();
	}

}
