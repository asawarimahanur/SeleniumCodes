package com.crm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PimPage {
     public PimPage(WebDriver driver) {
    	 PageFactory.initElements(driver,this);
     }
     @FindBy(xpath = "(//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'])[2]")
     private WebElement pim_Module;
     public void getpim_Module() {
    	 pim_Module.click();
     }
     
     @FindBy(xpath = "//input[@placeholder='Type for hints...']")
     private WebElement emp_Name;
     public void getemp_Name(String data) {
    	 emp_Name.sendKeys(data);
     }
     
     @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
     private WebElement emp_Id;
     public void getemp_Id(String data) {
    	 emp_Id.sendKeys(data);
     }
     
     @FindBy(xpath = "(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]")
     private WebElement select_Drop;
     public void getselect_Drop() {
    	 select_Drop.click();
     }
     
//     @FindBy(xpath = "//div[text()='Full-Time Contract']]")
//     private WebElement emp_Status;
//     public void getemp_Status() {
//    	 emp_Status.click();
//     }
     
     @FindBy(xpath = "(//input[@placeholder='Type for hints...'])[2]")
     private WebElement Sup_Name;
     public void getSup_Name(String data) {
    	 Sup_Name.sendKeys(data);
     }
     
     @FindBy(xpath = "(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[3]")
     private WebElement job_Title;
     public void getjob_Title() {
    	 job_Title.click();
     }
     
     @FindBy(xpath = "//button[@type='submit']")
     private WebElement search_Button;
     public void getsearch_Button() {
    	 search_Button.click();
     }
     
     @FindBy(xpath = "//button[@type='reset']")
     private WebElement reset_Button;
     public void getreset_Button() {
    	 reset_Button.click();
     }
     
     @FindBy(xpath = "//i[@class='oxd-icon bi-plus oxd-button-icon']")
     private WebElement add_Button;
     public void getadd_Button() {
    	 add_Button.click();
     }
     
}

