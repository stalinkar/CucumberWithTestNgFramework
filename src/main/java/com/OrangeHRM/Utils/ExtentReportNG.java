package com.OrangeHRM.Utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {

	static ExtentReports extentReports;

	public static String strUser = System.getProperty("user.name");
	public static String userDir = System.getProperty("user.dir");
	public static String[] strPathArr = userDir.split("\\\\");
	public static String strProjectName = strPathArr[strPathArr.length - 1];

	public static ExtentReports getReportObject() {
		String path = userDir + "\\reports\\index.html";
		ExtentSparkReporter esReporter = new ExtentSparkReporter(path);
		try {
			esReporter.loadXMLConfig(new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\OrangeHRM\\resources\\extent-config.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		esReporter.config().setReportName(strProjectName);
		esReporter.config().setDocumentTitle("Test Result");

		extentReports = new ExtentReports();
		extentReports.attachReporter(esReporter);
		extentReports.setSystemInfo("Tester", strUser);
		extentReports.setSystemInfo("Logs",
				"<a href='" + userDir + "\\Logs\\prints.log'>Logs<a>");
		return extentReports;
	}
}
