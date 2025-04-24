package com.crm.pom;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class Login {
	public 	Login(WebDriver driver) {
			PageFactory.initElements(driver, this);
			
	}
	
		@FindBy(name="username")
	    public WebElement username;
		@FindBy(name="password")
		public WebElement password;
		@FindBy(xpath="//button[text()=' Login ']")
		public WebElement login_button;
		
	}

