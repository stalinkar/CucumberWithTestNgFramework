package com.OrangeHRM.StepDefinition;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.OrangeHRM.Pages.OrangeHRMPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrangeHRMStepDefinition {

	WebDriver driver;
	OrangeHRMPage OrangeOR; 
	String strWebDriverPath = System.getProperty("user.dir")+"\\src\\main\\java\\com\\OrangeHRM\\resources\\chromedriver.exe";
	
	@Given("^the user opens the browser$")
	public void the_user_opens_the_browser() {
		System.setProperty("webdriver.chrome.driver",strWebDriverPath);
		driver = new ChromeDriver();
		OrangeOR=new OrangeHRMPage(driver);
		driver.manage().deleteAllCookies();
	}

	@Then("^the user navigates the URL$")
	public void the_user_navigates_the_URL() {
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
	}

	@Given("^I am in OrangeHRP Application$")
	public void i_am_in_OrangeHRP_Application() {
		Assert.assertTrue(OrangeOR.CheckLoginDisplayed());
	}

	@Then("^Click on Job$")
	public void click_on_Job() {
		OrangeOR.clickOnJobLink();
	}

	@Then("^validate text – Job Title$")
	public void validate_text_Job_Title() {
	   String strText = OrangeOR.GetJobTitleText();
	   Assert.assertEquals("Job Titles",strText); 
	}

	@Then("^Login to Application$")
	public void login_to_Application() {
		OrangeOR.EnterUserName("Admin");
		OrangeOR.EnterPassword("admin123");
		OrangeOR.ClickOnLogInButton();
	}

	@When("^Dashboard page is available$")
	public void dashboard_page_is_available(){
		String CheckDahBoard;
		CheckDahBoard=OrangeOR.GetDashBoardConfirmation();
		Assert.assertEquals("Dashboard", CheckDahBoard);
	}

	@When("^click on Admin menu$")
	public void click_on_Admin_menu()  {
		OrangeOR.ClickOnAdminLink();
	}
	@When("^click on My Info menu$")
	public void click_on_My_Info_menu(){
		OrangeOR.clickOnMyInfoLink();
	}

	@Then("^validate My Info is loaded$")
	public void validate_My_Info_is_loaded() {
		String headerText = OrangeOR.GetMyInfoPageHeadertext();
		Assert.assertEquals(headerText,"Personal Details");
	}

	@When("^click on Time Link$")
	public void click_on_Time_Link(){
		OrangeOR.clickOnTimeLink();
	}

	@Then("^validate Time Page is loaded$")
	public void validate_Time_Page_is_loaded() {
		String headerTextTimePage = OrangeOR.GetTimePageHeadertext();
		Assert.assertEquals(headerTextTimePage,"Select Employee");
	}

	@Then("^close the browser$")
	public void close_the_browser() throws Throwable {
	    driver.quit();
	}

	@Given("^When I am in OrangeHRP Application$")
	public void when_the_user_opens_the_browser() {
		System.setProperty("webdriver.chrome.driver",strWebDriverPath);
		driver = new ChromeDriver();
		OrangeOR=new OrangeHRMPage(driver);
		driver.manage().deleteAllCookies();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
	}
}
