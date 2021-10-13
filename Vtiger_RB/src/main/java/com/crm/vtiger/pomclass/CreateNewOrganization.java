package com.crm.vtiger.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class CreateNewOrganization extends WebDriverUtility  {
	public CreateNewOrganization(WebDriver driver){
	PageFactory.initElements(driver, this);	
	}
	@FindBy(xpath = "//input[@name='accountname']")
	private WebElement orgNameEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name="industry")
	private WebElement industriesEdt;
	
	@FindBy(id="employees")
	private WebElement empEdt;
	
	@FindBy(name="email2")
	private WebElement emailedt;
	
	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getIndustriesEdt() {
		return industriesEdt;
	}

	public WebElement getEmpEdt() {
		return empEdt;
	}

	public WebElement getEmailedt() {
		return emailedt;
	}

	public void createOrg(String orgName, String industries, String emp) throws Throwable {
		orgNameEdt.sendKeys(orgName);
		SelecOptionByValue(industriesEdt, industries);
		empEdt.sendKeys(emp);
		Thread.sleep(2000);
		saveBtn.click();
		System.out.println("saved..................");
	}
	public void createOrg(String orgName, String industries, String emp,String email) {
		orgNameEdt.sendKeys(orgName);
		SelecOptionByValue(industriesEdt, industries);
		empEdt.sendKeys(emp);
		emailedt.sendKeys(email);
		saveBtn.click();
	}

}
