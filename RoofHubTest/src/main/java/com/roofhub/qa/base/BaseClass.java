package com.roofhub.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import com.aventstack.extentreports.reporter.configuration.Theme;




public class BaseClass {
	
	public static WebDriver driver;
	public static Properties prop;
	
	 public static ExtentHtmlReporter htmlReporter;
	    public static ExtentReports extent;
	    public static ExtentTest test;
	
	public BaseClass(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\RoofHubTest\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void initialization()
	{
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");	
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-geolocation");
			DesiredCapabilities capabilities=DesiredCapabilities.chrome();
			capabilities.setCapability(ChromeOptions.CAPABILITY,options);
			driver = new ChromeDriver(capabilities);
			
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			driver.get(prop.getProperty("url"));
			
			
			
		}
		else if(browserName.equals("FF"))
		 {
			System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");	
		FirefoxProfile geoDisabled= new FirefoxProfile();
		geoDisabled.setPreference("geo.enabled", false);
		geoDisabled.setPreference("geo.provider.use_corelocation",false);
		geoDisabled.setPreference("geo.prompt.testing",false);
		geoDisabled.setPreference("geo.prompt.testing.allow",false);
		DesiredCapabilities capablities=DesiredCapabilities.firefox();
		capablities.setCapability(FirefoxDriver.PROFILE, geoDisabled);
		
			driver = new FirefoxDriver(capablities); 
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			driver.get(prop.getProperty("url"));
		}
	}
	
	
/*@BeforeSuite
public void startReport(){
	
	 htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/MyOwnReport.html");
     extent = new ExtentReports();
     extent.attachReporter(htmlReporter);
      
     extent.setSystemInfo("OS", "Windows 10");
     extent.setSystemInfo("Host Name", "Charu");
     extent.setSystemInfo("Environment", "QA");
     extent.setSystemInfo("User Name", "Charu Rastogi");
      
     //htmlReporter.config().setChartVisibilityOnOpen(true);
     htmlReporter.config().setDocumentTitle("AutomationTesting.in Demo Report");
     htmlReporter.config().setReportName("My Own Report");
    // htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
     htmlReporter.config().setTheme(Theme.DARK);
}	



@AfterSuite
public void tearDown()
{
    extent.flush();
}*/
}

		

