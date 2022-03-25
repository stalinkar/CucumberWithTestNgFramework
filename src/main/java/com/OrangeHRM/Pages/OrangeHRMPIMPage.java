package com.OrangeHRM.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMPIMPage {
	WebDriver driver;
	public OrangeHRMPIMPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='menu_pim_viewPimModule']")
	public WebElement linkPIM;
	
	@FindBy(xpath="//h1[text()='Employee Information']")
	public WebElement pageTitle;
	
	@FindBy(xpath="//*[@id='empsearch_employee_name_empName']")
	public WebElement txtEmployeeName;
	
	@FindBy(xpath="//*[@id='empsearch_id']")
	public WebElement txtId;
	
	@FindBy(xpath="//*[@id='empsearch_employee_status']")
	public WebElement dropDownEmployeeStatus;
	
	@FindBy(xpath="//*[@id='empsearch_termination']")
	public WebElement dropDownInclude;
	
	@FindBy(xpath="//*[@id='empsearch_supervisor_name']")
	public WebElement txtSupervisorName;
	
	@FindBy(xpath="//*[@id='empsearch_employee_status']")
	public WebElement dropDownJobTitle;
	
	@FindBy(xpath="//*[@id='empsearch_termination']")
	public WebElement dropDownSubUnit;
	
	@FindBy(xpath="//*[@id='searchBtn']")
	public WebElement btnSearch;
	
	@FindBy(xpath="//*[@id='resultTable']/tbody/tr/td")
	public List<WebElement> tblRowData;

}
