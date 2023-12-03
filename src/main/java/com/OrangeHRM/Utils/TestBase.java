package com.OrangeHRM.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;


public class TestBase {

	public static WebDriver driver;
	public static FileInputStream fileLoc;
	public static Properties prop;
	public static String screenShotPath = System.getProperty("user.dir")+"\\ScreenShot\\";

	public WebDriver  InitializeDriver() throws IOException {
		TestBase bc = new TestBase();
		prop = new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\OrangeHRM\\resources\\config.properties");
		prop.load(fis);
		if (prop.getProperty("browser").contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\com\\OrangeHRM\\resources\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
		}else if(prop.getProperty("browser").contains("firefox")){
			driver=new FirefoxDriver();
		}else {
			driver=new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
	}


	public static void captureScreenshot(WebDriver webdriver,String fileWithPath) throws Exception{

//		//Convert web driver object to TakeScreenshot
//
//		TakesScreenshot scrShot =((TakesScreenshot)webdriver);
//
//		//Call getScreenshotAs method to create image file
//
//		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
//
//		//Move image file to new destination
//
//		File DestFile=new File(fileWithPath+".png");
//
//		//Copy file at destination
//
//		FileUtils.copyFile(SrcFile, DestFile);
		
		Shutterbug.shootPage(webdriver, ScrollStrategy.WHOLE_PAGE_CHROME).withName(fileWithPath).save(screenShotPath+"\\");
		
	}
	public static void captureScreenshot(WebDriver webdriver,WebElement webElm, String fileWithPath) {
		String callingFunction =Thread.currentThread().getStackTrace()[2].getMethodName();
		Shutterbug.shootPage(webdriver, ScrollStrategy.BOTH_DIRECTIONS,true).highlightWithText(webElm, fileWithPath).withName(fileWithPath).save(screenShotPath+callingFunction);
	}
	public String getScreenShotPath(String methodName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshotFile = ts.getScreenshotAs(OutputType.FILE);
		String destinationPath = System.getProperty("user.dir")+"\\reports\\"+methodName+".png";
		FileUtils.copyFile(screenshotFile,new File(destinationPath));   
		return destinationPath;
	}
}
