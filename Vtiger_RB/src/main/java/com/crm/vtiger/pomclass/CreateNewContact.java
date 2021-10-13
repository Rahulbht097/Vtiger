package com.crm.vtiger.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class CreateNewContact extends WebDriverUtility {
	WebDriver driver;
	public CreateNewContact(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy (name= "lastname")
	private WebElement lastNameEdt;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement orgNameLookUpIcon;
	
	@FindBy(xpath = "//input[@title='Save[Alt+S]']")
	private WebElement saveBtn;
	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getOrgNameLookUpIcon() {
		return orgNameLookUpIcon;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void CreateNewContactWithOrg(String contactName,String orgName) {
		 lastNameEdt.sendKeys(contactName);
		 orgNameLookUpIcon.click();
		 switchToWindow(driver,  "Accounts&action");
		 Organizations op = new Organizations(driver);
		 op.getSearchEdt().sendKeys(orgName);
		 op.getSearchBtn().click();
	}
}
