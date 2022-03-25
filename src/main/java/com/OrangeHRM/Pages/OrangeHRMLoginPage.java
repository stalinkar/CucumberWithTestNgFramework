package com.OrangeHRM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Ans-3: 
 * Write Xpath and CssSelector of login page for following web objects - All Text box’s, All - Hyperlinks, All Images
 *
 */
public class OrangeHRMLoginPage {
	WebDriver driver;
	public OrangeHRMLoginPage(WebDriver driver) {
		this.driver=driver;
	}
	//Textbox
	By userName = By.xpath("//*[@id='txtUsername']");
	By password = By.xpath("//*[@id='txtPassword']");
//	By userName = By.cssSelector("#txtUsername"); 
//	By password = By.cssSelector("#txtPassword");
	
	//button
	By btnLogin = By.xpath("//*[@id='btnLogin']");
//	By btnLogin = By.cssSelector("#btnLogin");
	
	//Image
	By imgHeaderLogo = By.xpath("//*[@id='divLogo']/img");
	By imgForm = By.xpath("(//*[@overflow='visible'])[2]");
//	By imgHeaderLogo = By.cssSelector("#divLogo img");
//	By imgForm = By.cssSelector("image[overflow='visible']");
	
	//hyperlinks
	By linkForgotPasswoed = By.xpath("//a[contains(text(),'Forgot your password')]");
	By linkOrganization = By.xpath("//a[contains(text(),'OrangeHRM, Inc')]");
	By linkLinkedIn = By.xpath("//*[contains(@alt,'LinkedIn OrangeHRM group')]/parent::a");
	By linkFacebook = By.xpath("//*[contains(@alt,'OrangeHRM on Facebook')]/parent::a");
	By linkTwitter = By.xpath("//*[contains(@alt,'OrangeHRM on twitter')]/parent::a");
	By linkYoutube = By.xpath("//*[contains(@alt,'OrangeHRM on youtube')]/parent::a");
//	By linkForgotPasswoed = By.cssSelector("#forgotPasswordLink a");
//	By linkOrganization = By.cssSelector("#footer > div:nth-child(1) > a");
//	By linkLinkedIn = By.cssSelector("#social-icons > a:nth-child(1)");
//	By linkFacebook = By.cssSelector("#social-icons > a:nth-child(2)");
//	By linkTwitter = By.cssSelector("#social-icons > a:nth-child(3)");
//	By linkYoutube = By.cssSelector("#social-icons > a:nth-child(4)");
	
	public WebElement UserName() {
		return driver.findElement(userName);
	}
	public WebElement Password() {
		return driver.findElement(password);
	}
	public WebElement LoginButton() {
		return driver.findElement(btnLogin);
	}
}
