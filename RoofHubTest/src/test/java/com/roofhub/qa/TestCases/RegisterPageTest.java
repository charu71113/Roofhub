package com.roofhub.qa.TestCases;
import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.roofhub.qa.base.BaseClass;
import com.roofhub.qa.pages.HomePage;
import com.roofhub.qa.pages.LoginPage;
import com.roofhub.qa.pages.RegisterPage;

public class RegisterPageTest extends BaseClass {
	LoginPage loginpage;
	RegisterPage registerpage;

public RegisterPageTest()
{
	super();
	
}

@BeforeMethod
public void setUp(){
initialization();
loginpage = new LoginPage();
registerpage= new RegisterPage();


}

@Test(alwaysRun=true)
public void verifyRegistration() throws InterruptedException
{
	String random_email=""+(int)(Math.random()*Integer.MAX_VALUE);
	String email= "testautomation"+random_email+"@gmail.com";
	
	System.out.println(email);
	String password="Testing@123";
	
	
	JavascriptExecutor js=((JavascriptExecutor)driver);
	loginpage.registerclick();


//1st Page
	Thread.sleep(10000);
	registerpage.enterAccNo();
	registerpage.enterinvno1();
	registerpage.enterInvno2();
    registerpage.pickInvDate();
	
	
	WebDriverWait wait= new WebDriverWait(driver,30);
	wait.until(ExpectedConditions.elementToBeClickable(registerpage.NextBtn));
	
	registerpage.NextBtnClick();
	
	//2nd Page
	
	registerpage.enterfirstName();
	registerpage.enterlastName();
	registerpage.enterPhoneNo();
	registerpage.selectrole();
	wait.until(ExpectedConditions.elementToBeClickable(registerpage.NextBtnPage2));
	registerpage.clickNext2();
	
	registerpage.enteremail(email);
	registerpage.enterpassword(password);
	registerpage.enterconfirmpassword(password);
	wait.until(ExpectedConditions.elementToBeClickable(registerpage.finish));
	registerpage.clickfinish();
	
	String confirmregistration= registerpage.registersuccessfull.getText();
	String expected="Thank you! You have successfully registered.";
	
	try
	{
		Assert.assertEquals(confirmregistration,expected);
	} catch(AssertionError e)
	{
		System.out.println("User not registered successfully");
		throw e;
	}
	System.out.println("User registered successfully");
	
	

}

@AfterMethod
public void tearDown(){
	driver.quit();
}


}


