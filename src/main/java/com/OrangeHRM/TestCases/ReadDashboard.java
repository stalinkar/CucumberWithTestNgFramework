package com.OrangeHRM.TestCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.OrangeHRM.Pages.OrangeHRMAdminPage;
import com.OrangeHRM.Pages.OrangeHRMLoginPage;
import com.OrangeHRM.Pages.OrangeHRMPageTitle;
import com.OrangeHRM.Utils.Log;
import com.OrangeHRM.Utils.TestBase;

public class ReadDashboard extends TestBase {
	public static WebDriver driver;
	OrangeHRMLoginPage orangeORLogin;
	OrangeHRMAdminPage orangeORAdmin;
	OrangeHRMPageTitle orangeORPageTitle;
	public static FileInputStream fileLoc;
	public static Properties prop;
	Log logger;

	@BeforeSuite
	public void Initialize() throws IOException {
		logger = new Log();
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\com\\OrangeHRM\\resources\\config.properties");
		prop.load(fis);
		driver = InitializeDriver();
		driver.get(prop.getProperty("Url"));
		logger.info(">>URL Opened");

		orangeORLogin = new OrangeHRMLoginPage(driver);
		orangeORPageTitle = new OrangeHRMPageTitle(driver);
		orangeORAdmin = new OrangeHRMAdminPage(driver);
		logger.info(">>Page objects created");
	}

	@Test(priority = 1)
	public void LogInApp() throws InterruptedException {
		orangeORLogin.UserName().clear();
		logger.info(">>UserName field cleared");
		orangeORLogin.UserName().sendKeys(prop.getProperty("username"));
		logger.info(">>UserName field set to" + prop.getProperty("username"));
		orangeORLogin.Password().clear();
		logger.info(">>Password field cleared");
		orangeORLogin.Password().sendKeys(prop.getProperty("passwd"));
		logger.info(">>Password field set to" + prop.getProperty("passwd"));
		orangeORLogin.LoginButton().click();
		logger.info(">>Login Button clicked");
		Thread.sleep(1000);
	}

	@Test(priority = 3)
	public void VerifyPageTitle() throws Exception {
		// String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		orangeORPageTitle.linkAdmin.click();
		Assert.assertTrue(orangeORPageTitle.txtMenuHeader.getText().contains("System Users"),
				"Admin page title is not displayed");
		captureScreenshot(driver, orangeORPageTitle.linkAdmin, "Admin");
		orangeORPageTitle.linkPIM.click();
		Assert.assertTrue(orangeORPageTitle.txtMenuHeader.getText().contains("Employee Information"),
				"PIM page title is not displayed");
		captureScreenshot(driver, orangeORPageTitle.linkPIM, "PIM");
		orangeORPageTitle.linkLeave.click();
		Assert.assertTrue(orangeORPageTitle.txtMenuHeader.getText().contains("Leave List"),
				"Leave page title is not displayed");
		captureScreenshot(driver, orangeORPageTitle.linkLeave, "Leave");
		orangeORPageTitle.linkDashboard.click();
		Assert.assertTrue(orangeORPageTitle.txtMenuHeader.getText().contains("Dashboard"),
				"Dashboard page title is not displayed");
		captureScreenshot(driver, orangeORPageTitle.linkDashboard, "Dashboard");
		orangeORPageTitle.linkDirectory.click();
		Assert.assertTrue(orangeORPageTitle.txtMenuHeader.getText().contains("Search Directory"),
				"Directory page title is not displayed");
		captureScreenshot(driver, orangeORPageTitle.linkDirectory, "Directory");
		orangeORPageTitle.linkMaintenance.click();
		Assert.assertTrue(orangeORPageTitle.txtMenuHeader.getText().contains("Purge Employee Records"),
				"Maintenance page title is not displayed");
		captureScreenshot(driver, orangeORPageTitle.linkMaintenance, "Maintenance");
	}

	@Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
	public void VerifyDashboard() throws Exception {
		this.MinimizeWindow();// TestCase-9
		Assert.assertTrue(orangeORPageTitle.txtMenuHeader.getText().equalsIgnoreCase("Dashboard"),
				"DashBoard not displayed");
		driver.manage().window().maximize();
	}

	public void MinimizeWindow() throws InterruptedException {
		// this.driver=driver;
		driver.manage().window().minimize();
		Thread.sleep(1000);
		Dimension d = new Dimension(300, 1080);
		driver.manage().window().setSize(d);
		Thread.sleep(1000);
	}

	@AfterSuite
	public void Close() {
		driver.quit();
	}
}
