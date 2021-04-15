package com.roofhub.qa.pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.roofhub.qa.base.*;
import com.roofhub.qa.pages.HomePage;

public class HomePage extends BaseClass {
	
@FindBy(xpath="//a[@href='new-order']")
WebElement CreateNewOrder;

@FindBy(xpath="//a[@href='ordertemplate?TemplateType=NewTemplate#manage-template']")
public WebElement NewOrderTemplate;

@FindBy(xpath="//div[@id='dashboard-side-panel']/div[1]/div[2]//div[@class='row']/div[1]/div/span[2]")
public WebElement username_side_panel;

@FindBy(xpath="//div[@id='header']/div[3]/div/div[2]/div[@id='accordion']//a[@href='#collapseTwo']/div")
public WebElement profiledropdown;

@FindBy(xpath="//div[@id='collapseTwo']/ul[@class='list-group']//a[@href='/logout']")
public WebElement logout;


public HomePage()
{
PageFactory.initElements(driver, this);	
}

//Action
public NewOrderPage NewOrder()
{
	CreateNewOrder.click();
	return new NewOrderPage();
}

public OrderTemplatePage newTemplate()
{
	NewOrderTemplate.click();
	return new OrderTemplatePage();
	
}

public void clickProfilemenu()
{
	profiledropdown.click();
}

public void clicklogout()
{
	logout.click();
}

}
