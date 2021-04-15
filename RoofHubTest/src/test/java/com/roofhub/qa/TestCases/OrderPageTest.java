package com.roofhub.qa.TestCases;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.roofhub.qa.base.BaseClass;
import com.roofhub.qa.pages.HomePage;
import com.roofhub.qa.pages.LoginPage;
import com.roofhub.qa.pages.*;

public class OrderPageTest extends BaseClass{

	LoginPage loginpage;
	HomePage homepage;
	NewOrderPage order1;
	NewOrderPage2 order2;
	LoginPageTest loginpagetest;
	
public OrderPageTest()
{
	super();
	
}

@BeforeMethod
public void setUp(){
	initialization();
	loginpage = new LoginPage();

	order1= new NewOrderPage();
	order2 =new NewOrderPage2();
}

@Test(priority=1,alwaysRun=true)
public void verifyplaceorder() throws InterruptedException
{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	WebDriverWait wait= new WebDriverWait(driver,30);
	WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='dashboard-side-panel']/div[1]/div[2]//div[@class='row']/div[1]/div/span[2]")));
	homepage= new HomePage();
	homepage.NewOrder();
	Thread.sleep(8000);
	if(order1.Discard.isDisplayed())
	{
	order1.discardautosaveOrder();
	}
	
	order1.pickUpClick();
	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("continueToStep2Button"))));
	order1.NextClick();
	Thread.sleep(2000);
	//order2.selectBranch();
	order2.selectJobAccount();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	js.executeScript("window.scrollBy(0,400)");
	order2.PickupDates();
	order2.selectArrivaltime();
	order2.clickOrderTemplate();
	order2.selectTemplate();
	wait.until(ExpectedConditions.elementToBeClickable(order2.ReviewOrderBtn));
	order2.ReviewOrderClick();
	order2.PlaceOrderClick();
	
	String o1=order2.OrderSuccess.getText();
	String expected="Order Successful";
	
	try
	{
		Assert.assertEquals(o1,expected);
	} catch(AssertionError e)
	{
		System.out.println("Order not placed");
		throw e;
	}
	System.out.println("Order placed successfully");
	
	

	
}

@Test(priority = 2,alwaysRun=true)
public void verifyCancelOrder() throws InterruptedException
{JavascriptExecutor js = (JavascriptExecutor) driver;

	homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	WebDriverWait wait= new WebDriverWait(driver,30);
	WebElement username_panel= driver.findElement(By.xpath("//div[@id='dashboard-side-panel']/div[1]/div[2]//div[@class='row']/div[1]/div/span[2]"));
	wait.until(ExpectedConditions.visibilityOf(username_panel));
	homepage= new HomePage();
	homepage.NewOrder();
	Thread.sleep(8000);
	if(order1.Discard.isDisplayed())
	{
	order1.discardautosaveOrder();
	}
	order1.pickUpClick();
	
	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("continueToStep2Button"))));
	order1.NextClick();
	Thread.sleep(2000);
	//order2.selectBranch();
	order2.selectJobAccount();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	js.executeScript("window.scrollBy(0,400)");
	order2.PickupDates();
	order2.selectArrivaltime();
	order2.clickOrderTemplate();
	order2.selectTemplate();
js.executeScript("arguments[0].scrollIntoView(true);", order2.Cancel);


Thread.sleep(10000);
	order2.CancelOrder();
	Thread.sleep(4000);
	WebElement logo=driver.findElement(By.xpath("//div[@id='contentArea']/div[2]/div[@class='row']/div[2]/div[1]/div[@class='col-12 right-container']/div//"
			+ "img[@src='https://media.srsdistribution.com/Uploads/BrandsByID/19.png']"));
if(logo.isDisplayed())
{
	System.out.println("Order Cancelled successfully");
}

else 
{
	System.out.println("Test Fail: Order not cancelled");
}

}

@Test(enabled=false)
public void verifyDraftOrder() throws InterruptedException
{JavascriptExecutor js = (JavascriptExecutor) driver;

	homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	WebDriverWait wait= new WebDriverWait(driver,30);
	WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='dashboard-side-panel']/div[1]/div[2]//div[@class='row']/div[1]/div/span[2]")));
	homepage= new HomePage();
	homepage.NewOrder();
	order1.pickUpClick();
	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("continueToStep2Button"))));
	order1.NextClick();
	Thread.sleep(2000);
	//order2.selectBranch();
	order2.selectJobAccount();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	js.executeScript("window.scrollBy(0,400)");
	order2.PickupDates();
	order2.selectArrivaltime();
	order2.clickOrderTemplate();
	order2.selectTemplate();
js.executeScript("arguments[0].scrollIntoView(true);", order2.DraftOrder);

order2.DraftOrder();
	
}

@AfterMethod
public void tearDown(){
	driver.quit();
}


	
}
