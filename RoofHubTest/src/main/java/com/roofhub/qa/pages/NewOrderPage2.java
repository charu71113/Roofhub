package com.roofhub.qa.pages;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.roofhub.qa.base.*;
import com.roofhub.qa.pages.HomePage;

public class NewOrderPage2 extends BaseClass {
	
	Actions action=new Actions(driver);
	
@FindBy(xpath="/html//button[@id='dropdownMenuButton']")
public WebElement Branch;

@FindBy(xpath="//div[@id='order-wizard']/div/div[8]/div/div[@class='col-12 col-lg-8 mb-3 order-1']"
		+ "/div/div[6]/div[@class='col-12']/div/select[@class='form-control select-no-margin']")
public WebElement JobAccount;

@FindBy(xpath="//div[@id='order-wizard']/div/div[8]/div/div[@class='col-12 col-lg-8 mb-3 order-1']/div/div[7]/div[@class='col-12 col-lg-6']//div[@class='vdp-datepicker']//input[@name='requested-ship-date']")
public WebElement PickupDate;

@FindBy(xpath="//div[@id='order-wizard']/div/div[8]/div/"
		+ "div[@class='col-12 col-lg-8 mb-3 order-1']/div//div[@class='col-12 col-lg-6']/div[4]/div[@class='col-12']/select[@class='form-control select-no-margin']")
public WebElement ArrivalTime;

@FindBy(xpath="//div[@id='templates-list']/div[1]//button[@type='button']")
public WebElement MyOrderTemplate;

@FindBy(xpath="//div[@id='templates-list']/div[1]/div[4]/div[@class='col-12']/div[@class='card mb-4']/div[2]/div/div[3]/p[@class='my-2 text-center']/a[@href='#step2']")
public WebElement SelectTemplate;

@FindBy(xpath="//div[@id='order-wizard']/div/div[8]/div/div[@class='col-12 col-lg-4 mb-3 order-3 order-lg-1']/div//button")
public WebElement ReviewOrderBtn;

//@FindBy(xpath="//div[@class='col-12 col-lg-4 mb-3 order-3 order-lg-1']/div/div/div[2]/div[7]/div/a[2]")
@FindBy(css=".col-12.text-center > a:nth-of-type(2)")
public WebElement Cancel;

@FindBy(xpath="//div[@id='order-wizard']/div/div[8]/div/div[@class='col-12 col-lg-4 mb-3 order-3 order-lg-1']/div/div[@class='row']//span[.='Save Draft']")
public WebElement DraftOrder;


@FindBy(xpath="//div[@id='modalItemsNotAdded']/div[@class='modal-content-event']/div[@id='MyModalHtml']//button[@class='btn primary pull-right']")
public WebElement PlaceOrderBtn;

@FindBy(xpath="//div[@id='order-wizard']/div/div[11]//h1[.='Order Successful']")
public WebElement OrderSuccess;

public NewOrderPage2()

	{
		PageFactory.initElements(driver, this);	
		
	
	}

//actions

public void selectBranch()
{
	Select s2= new Select(Branch);
	s2.selectByIndex(1);
	
}

public void selectJobAccount()
{
	Select s1=new Select(JobAccount);
	s1.selectByVisibleText("2: Main Account");
	
}

public void PickupDates() throws InterruptedException
{
	/*PickupDate.click();
	JavascriptExecutor js=((JavascriptExecutor)driver);
	js.executeScript ("arguments[0].removeAttribute('readonly')",PickupDate);
	PickupDate.sendKeys("03/31/2021");*/

	  String month="Apr 2021";
		String day="28";
		PickupDate.click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	
	
	while(true)
	

	{
		WebElement m1= driver.findElement(By.xpath("//div[@id='order-wizard']/div/div[8]/div/div[@class='col-12 col-lg-8 mb-3 order-1']/div/div[7]//div[@class='vdp-datepicker']"
				+ "/div[2]//span[@class='day__month_btn up']"));
		String c1= m1.getText();
		if(c1.equalsIgnoreCase(month))
		{
			break;
		}
		else 
		{
			driver.findElement(By.xpath("//div[@id='order-wizard']/div/div[8]/div/div[@class='col-12 col-lg-8 mb-3 order-1']/div/div[7]//div[@class='vdp-datepicker']/div[2]//span[@class='next']")).click();
		}
		
		
	}
	
	driver.findElement(By.xpath("//div[@id='order-wizard']/div/div[8]/div/div[@class='col-12 col-lg-8 mb-3 order-1']/div/div[7]//div[@class='vdp-datepicker']/div[2]/div/span[contains(text(),"+day+")]")).click();
}


	



public void selectArrivaltime()
{

	Select s1=new Select(ArrivalTime);
	s1.selectByIndex(4);

}

public void clickOrderTemplate()
{
	MyOrderTemplate.click();
	
}

public void selectTemplate()
{
	SelectTemplate.click();
}

public void ReviewOrderClick()
{
	ReviewOrderBtn.click();
}

public void CancelOrder()
{
	//Cancel.click();
	action.moveToElement(Cancel).click().build().perform();	
}

public void DraftOrder()
{
	DraftOrder.click();
}

public void PlaceOrderClick()
{
	PlaceOrderBtn.click();
}

}



