package com.OrangeHRM.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMAdminPage {
	WebDriver driver;
	public OrangeHRMAdminPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1[text()='Dashboard']")
	public WebElement titleDashboard;
	
	@FindBy(xpath="//*[@id='menu_admin_viewAdminModule']")
	public WebElement linkAdmin;
	
	@FindBy(xpath="//*[text()='User Management']")
	public WebElement txtUserManagement;
	
	@FindBy(xpath="//*[text()='Job']")
	public WebElement txtJob;
	
	@FindBy(xpath="//*[text()='Organization']")
	public WebElement txtOrganization;
	
	@FindBy(xpath="//*[text()='Qualifications']")
	public WebElement txtQualifications;
	
	@FindBy(xpath="//div[@class='head']/h1")
	public WebElement txtMenuHeader;
}
