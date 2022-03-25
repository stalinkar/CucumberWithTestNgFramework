package com.OrangeHRM.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMPageTitle {
	WebDriver driver;
	public OrangeHRMPageTitle(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='menu_admin_viewAdminModule']")
	public WebElement linkAdmin;
	
	@FindBy(xpath="//*[@id='menu_pim_viewPimModule']")
	public WebElement linkPIM;
	
	@FindBy(xpath="//*[@id='menu_dashboard_index']")
	public WebElement linkDashboard;
	
	@FindBy(xpath="//*[@id='menu_leave_viewLeaveModule']")
	public WebElement linkLeave;
	
	@FindBy(xpath="//*[@id='menu_directory_viewDirectory']")
	public WebElement linkDirectory;
	
	@FindBy(xpath="//*[@id='menu_maintenance_purgeEmployee']")
	public WebElement linkMaintenance;
	
	@FindBy(xpath="//div[@class='head']/h1")
	public WebElement txtMenuHeader;
	
//	By titleAdmin = By.xpath("//h1[text()='System Users']");
//	By titleDashboard = By.xpath("//h1[text()='Dashboard']");
//	By titlePIM = By.xpath("//h1[text()='Employee Information']");
//	By titleLeave = By.xpath("//h1[text()='Leave List']");
//	By titleDirectory = By.xpath("//h1[text()='Search Directory']");
//	By titleMaintenance = By.xpath("//h1[text()='Purge Employee Records']");
	
	//By linkAdmin = By.xpath("//*[@id='menu_admin_viewAdminModule']");
	//By linkDashboard = By.xpath("//*[@id='menu_dashboard_index']");
	//By linkPIM = By.xpath("//*[@id='menu_pim_viewPimModule']");
	//By linkLeave = By.xpath("//*[@id='menu_leave_viewLeaveModule']");
	//By linkDirectory = By.xpath("//*[@id='menu_directory_viewDirectory']");
	//By linkMaintenance = By.xpath("//*[@id='menu_maintenance_purgeEmployee']");
	
	
	
}
