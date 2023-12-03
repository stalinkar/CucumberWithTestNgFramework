package com.OrangeHRM.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMPage {

	WebDriver Driver;
	
	@FindBy(id="menu_admin_viewAdminModule")
	WebElement AdminLink;
	
	public void ClickOnAdminLink() {
		AdminLink.click();
	}
	
	
	@FindBy(id="txtUsername")
	WebElement userName;
	
	public void EnterUserName(String strUserName) {
		userName.clear();
		userName.sendKeys(strUserName);
	}
	
	public boolean CheckLoginDisplayed() {	
		return userName.isDisplayed();
	}
	
	
	@FindBy(id="txtPassword")
	WebElement password;
	
	public void EnterPassword(String strPassword) {
		password.clear();
		password.sendKeys(strPassword);
	}
	
	@FindBy(id="btnLogin")
	WebElement LogIn;
	
	public void ClickOnLogInButton() {
		LogIn.click();
	}
	
	
	@FindBy(xpath="//b[contains(text(),'Dashboard')]")
    WebElement DashBoard;
    public String GetDashBoardConfirmation()
    {
        return DashBoard.getText();   
    }
    
    @FindBy(xpath="//*[@id=\"pdMainContainer\"]/div[1]/h1")
    WebElement MyInfo;
    public String GetMyInfoPageHeadertext()
    {
        return MyInfo.getText();   
    }
    
    @FindBy(xpath="//*[@id='content']/div[1]/div[1]/h1")
    WebElement SelectEmplyee;
    public String GetTimePageHeadertext()
    {
        return SelectEmplyee.getText();   
    }
    
    @FindBy(id="menu_admin_Job")
    WebElement JobLink;
    
    public void clickOnJobLink() {
    	JobLink.click();
    }
    
    @FindBy(id="menu_time_viewTimeModule")
    WebElement LinkTime;
    
    public void clickOnTimeLink() {
    	LinkTime.click();
    }
    
    @FindBy(id="menu_pim_viewMyDetails")
    WebElement LinkMyInfo;
    
    public void clickOnMyInfoLink() {
    	LinkMyInfo.click();
    }
    
    
    @FindBy(id="menu_admin_viewJobTitleList")
    WebElement JobTitle;
    
    public String GetJobTitleText() {
    	return JobTitle.getText(); 
    }
    

	public OrangeHRMPage(WebDriver Driver) {
		this.Driver = Driver;
		PageFactory.initElements(Driver, this);
	}
	
	
}
