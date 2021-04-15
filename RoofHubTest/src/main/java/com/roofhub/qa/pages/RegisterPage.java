package com.roofhub.qa.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.roofhub.qa.base.*;
import com.roofhub.qa.pages.HomePage;

public class RegisterPage extends BaseClass {
	
@FindBy(xpath="//div[@id='register-container']/div/div[2]/form/div[4]//input[@name='account-number']")
public WebElement AccountNumber;

@FindBy(xpath="//div[@id='register-container']/div/div[2]/form/div[4]//input[@name='invoice-number']")
public WebElement InvoiceNumber;

@FindBy(xpath="//div[@id='register-container']/div/div[2]/form/div[4]//input[@name='invoice-number-part2']")
public WebElement Invoicepart2;

@FindBy(xpath="//div[@id='register-container']/div/div[2]/form/div[4]//input[@name='invoice-date']")
public WebElement invoiceDate;

@FindBy(xpath="//div[@id='register-container']/div/div[2]/form/div[4]/div[7]/div[2]/button[@type='button']")
public WebElement NextBtn;

@FindBy(xpath="//div[@id='register-container']/div/div[2]/form/div/div[3]/div[9]/div[2]/button[@type='button']")
public WebElement NextBtnPage2;

@FindBy(xpath="//input[@name='last-name']")
WebElement lastname;

@FindBy(xpath="//input[@name='first-name']")
WebElement firstname;

@FindBy(xpath="//input[@name='phone-number']")
WebElement phonenumber;

@FindBy(xpath="//select[@name='role']")
WebElement RoleAtCompany;

@FindBy(xpath="//input[@name='register-email-address']")
public WebElement email;

@FindBy(xpath="//input[@name='register-password']")
public WebElement password;

@FindBy(xpath="//input[@name='confirm-password']")
public WebElement confirmPassword;

@FindBy(xpath="//div[@id='register-container']/div/div[@class='create-account mt-4']/form/div/div[3]/div[7]/div[2]/button[@type='button']")
public WebElement finish;

@FindBy(xpath="//div[@id='login-content']/div/div/div[@class='card card-signin']//p[@class='text-center']")
public WebElement registersuccessfull;



public RegisterPage()
{
PageFactory.initElements(driver, this);	
}



public void enterAccNo()
{
	AccountNumber.sendKeys("COR206");
}

public void enterinvno1()
{
	InvoiceNumber.sendKeys("16657531");
	
}

public void enterInvno2()
{
	Invoicepart2.sendKeys("001");
}

public void NextBtnClick()
{
	
	NextBtn.click();
}


public void pickInvDate() throws InterruptedException
{
	//PickupDate.click();
	/*JavascriptExecutor js=((JavascriptExecutor)driver);
	js.executeScript ("arguments[0].removeAttribute('readonly')",invoiceDate);
	
	invoiceDate.clear();
	invoiceDate.sendKeys("01/31/2020");*/
	
	String month="Jan 2020";
	String day="31";
	invoiceDate.click();
	Thread.sleep(2000);
	
	
	
	while(true)
	{
		WebElement m1= driver.findElement(By.xpath("//div[@id='register-container']"
				+ "/div//form//div[@class='vdp-datepicker']/div[2]//span[@class='day__month_btn up']"));
		String c1= m1.getText();
		if(c1.equalsIgnoreCase(month))
		{
			break;
		}
		else 
		{
			driver.findElement(By.xpath("//div[@id='register-container']/div//form//div[@class='vdp-datepicker']/div[2]//span[@class='prev']")).click();
		}
		
		
	}
	
	driver.findElement(By.xpath("//div[@id='register-container']/div//form//div[@class='vdp-datepicker']/div[2]/div/span[contains(text(),"+day+")]")).click();
}

public void enterfirstName()
{
	firstname.sendKeys("Charu");
}
public void enterlastName()
{
	lastname.sendKeys("Charu1");
}

public void enterPhoneNo()
{
	phonenumber.sendKeys("7042106183");
}

public void selectrole()
{
	Select s1=new Select(RoleAtCompany);
	s1.selectByVisibleText("Back Office");
	
			
}

public void clickNext2()
{
	NextBtnPage2.click();
}


public void enteremail(String email1)
{
	email.sendKeys(email1);
}

public void enterpassword(String pass)
{
	password.sendKeys(pass);
}

public void enterconfirmpassword(String pass)
{
	confirmPassword.sendKeys(pass);
}

public void clickfinish()
{
	finish.click();
	
}

}
