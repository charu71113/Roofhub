package com.roofhub.qa.pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.roofhub.qa.base.*;
import com.roofhub.qa.pages.HomePage;

public class NewOrderPage extends BaseClass {

@FindBy(xpath="//button[@id='btnDelivery']")
WebElement Delivery;

@FindBy(id="btnWillCall")
WebElement pickup;

@FindBy(xpath="//div[@id='modalAutoSavedOrder']/div[@role='document']//a[@class='btn secondary']")
public WebElement Discard;

@FindBy(xpath="//div[@id='order-wizard']/div/div[7]/div/div/div[2]/div[@class='col-12']//div[@class='col-12 col-md-6 mb-4 mb-md-0']/div[5]/div[@class='col-12']/input[@type='text']")
WebElement PO;

@FindBy(xpath="//div[@id='order-wizard']/div/div[7]/div/div/div[2]/div[@class='col-12']//div[@class='col-12 col-md-6 mb-4 mb-md-0']/div[7]/div[@class='col-12']/input[@type='text']")
WebElement JobName;

@FindBy(xpath="//div[@id='order-wizard']/div/div[7]/div/div/div[2]//div[@class='col-12 col-md-6']/div[1]/div[2]")
WebElement AddressNotFound;

@FindBy(xpath="//div[@id='order-wizard']/div/div[7]/div/div/div[2]/div[@class='col-12']//div[@class='col-12 col-md-6']/div[4]/div[2]/div[@class='col-12']/input[@type='text']")
WebElement Address1;

@FindBy(xpath="//div[@id='order-wizard']/div/div[7]/div/div/div[2]/div[@class='col-12']//div[@class='col-12 col-md-6']/div[4]/div[4]/div[@class='col-12']/input[@type='text']")
WebElement Address2;

@FindBy(xpath="//div[@id='order-wizard']/div/div[7]/div/div/div[2]/div[@class='col-12']//div[@class='col-12 col-md-6']/div[4]/div[6]/div[@class='col-12']/input[@type='text']")
WebElement City;

@FindBy(xpath="//div[@id='order-wizard']/div/div[7]/div/div/div[2]/div[@class='col-12']//select[@class='form-control']")
WebElement Country;

@FindBy(xpath="//div[@id='order-wizard']/div/div[7]/div/div/div[2]/div[@class='col-12']//div[@class='col-12 col-md-6']/div[4]/div[10]/div[@class='col-12']/input[@type='text']")
WebElement ZipCode;

@FindBy(id="continueToStep2Button")
WebElement NextButton;



public NewOrderPage()
{
PageFactory.initElements(driver, this);	
}

//Actions

public void discardautosaveOrder()
{
	Discard.click();
}
public void  DeliveryClick()
{
	Delivery.click();
}

public void pickUpClick()
{
	pickup.click();
}

public void POEnter()
{
	PO.sendKeys("123");
	
}

public void JobNameEnter()
{
	JobName.sendKeys("123");
}

public void Address()
{
	AddressNotFound.click();
	Address1.sendKeys("test");
	Address2.sendKeys("test");
	City.sendKeys("test");
	Select s1=new Select(Country);
	s1.deselectByIndex(2);
	ZipCode.sendKeys("12484");
	
}

public void NextClick()
{
	NextButton.click();
	
}


}
