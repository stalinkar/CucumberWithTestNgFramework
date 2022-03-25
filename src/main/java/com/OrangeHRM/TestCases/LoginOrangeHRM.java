package com.OrangeHRM.TestCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.OrangeHRM.Pages.OrangeHRMAdminPage;
import com.OrangeHRM.Pages.OrangeHRMLoginPage;

import junit.framework.Assert;


public class LoginOrangeHRM {

	public static WebDriver driver;
	public static OrangeHRMLoginPage orangeORLogin;
	public static OrangeHRMAdminPage orangeORAdmin;
	public static FileInputStream fileLoc;
	public static Properties prop;

	public static void main(String[] args) {

		try {
			fileLoc = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\SDETSelenium\\resources\\config.properties");
			prop = new Properties();
			prop.load(fileLoc);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\com\\SDETSelenium\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get(prop.getProperty("Url"));
		
		String expectedUrl= driver.getCurrentUrl();
	    Assert.assertEquals("Currect loaded url is not correct.", expectedUrl,prop.getProperty("Url"));
		
		System.out.println("Page Title: "+ driver.getTitle());
		
		orangeORLogin = new OrangeHRMLoginPage(driver);
		orangeORLogin.UserName().clear();
		orangeORLogin.UserName().sendKeys(prop.getProperty("username"));
		orangeORLogin.Password().clear();
		orangeORLogin.Password().sendKeys(prop.getProperty("passwd"));
		orangeORLogin.LoginButton().click();
		
		orangeORAdmin = new OrangeHRMAdminPage(driver);
		Assert.assertTrue("The Dashboard page is not displayed", orangeORAdmin.titleDashboard.isDisplayed());
		
		orangeORAdmin.linkAdmin.click();
		Assert.assertTrue("The User Management text is not displayed", orangeORAdmin.txtUserManagement.isDisplayed());
		Assert.assertTrue("The Job text is not displayed", orangeORAdmin.txtJob.isDisplayed());
		Assert.assertTrue("The Organization text is not displayed", orangeORAdmin.txtOrganization.isDisplayed());
		Assert.assertTrue("The Qualifications text is not displayed", orangeORAdmin.txtQualifications.isDisplayed());
	
		driver.close();
	}

}
