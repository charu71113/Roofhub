package com.roofhub.qa.TestCases;
import static org.testng.Assert.assertEquals;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.roofhub.qa.base.BaseClass;
import com.roofhub.qa.pages.HomePage;
import com.roofhub.qa.pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public class LoginPageTest extends BaseClass {
	
LoginPage loginpage;
HomePage homepage;

ExtentReports extent;
ExtentTest logger;

public LoginPageTest()
{
	super();
	
}

@BeforeMethod
public void setUp(){
	initialization();
	loginpage = new LoginPage();
	homepage= new HomePage();
	
}



@Test
public void verifyloginwithvalidcredentials()
{
	String expected="CharuRAS Rastogi";
	homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	WebDriverWait wait= new WebDriverWait(driver,30);
	wait.until(ExpectedConditions.visibilityOf(homepage.username_side_panel));
	
String welcome=driver.findElement(By.xpath("//div[@id='dashboard-side-panel']/div[1]/div[2]//div[@class='row']/div[1]/div/span[2]")).getText();
try
{
	Assert.assertEquals(welcome, expected);
} catch(AssertionError e)
{
	System.out.println("User not able to login with valid credentials");
	throw e;
}
System.out.println("User logged in successfully with valid credentials");
	
	
}


@Test(alwaysRun=true)
public void verifyloginwithinvalidcredentials()
{
	String actual=loginpage.incorrectdetails.getAttribute("innerHTML");
 String expected="The username or password is incorrect.";
	homepage=loginpage.login(prop.getProperty("username"), "test");
	WebDriverWait wait1= new WebDriverWait(driver,30);
	wait1.until(ExpectedConditions.visibilityOf(loginpage.incorrectdetails));
	System.out.println(actual);
	
	
	
     
	
}

@Test(alwaysRun=true)
public void verifylogout()
{
	

	homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	WebDriverWait wait= new WebDriverWait(driver,30);
	wait.until(ExpectedConditions.visibilityOf(homepage.username_side_panel));
	
	homepage.clickProfilemenu();
	homepage.clicklogout();
	
	
}

@AfterMethod
public void tearDown(){
	driver.quit();
}
	

    }


