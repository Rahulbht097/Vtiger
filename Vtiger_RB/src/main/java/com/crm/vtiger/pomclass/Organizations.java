package com.crm.vtiger.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organizations {
	
	public Organizations(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath ="//img [@src='themes/softed/images/btnL3Add.gif']" )
	private WebElement createOrgImg;
		
	@FindBy(name="search-text")
	private WebElement searchEdt;
	
	
	@FindBy(name="search")
	private WebElement searchBtn;


	public WebElement getCreateOrgImg() {
		return createOrgImg;
	}


	public WebElement getSearchEdt() {
		return searchEdt;
	}


	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	
}
