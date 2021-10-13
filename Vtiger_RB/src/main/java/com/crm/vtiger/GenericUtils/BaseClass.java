package com.crm.vtiger.GenericUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.crm.vtiger.pomclass.Login;

public class BaseClass {
public FileUtility flib= new FileUtility();
public WebDriverUtility wlib= new WebDriverUtility();
public ExcelUtility elib= new ExcelUtility();
public JavaUtility jlib = new JavaUtility();
public WebDriver driver;

@BeforeSuite
//public void connectDB() {}
 
@BeforeClass
public void launchBrowser() throws Throwable {
	String URL = flib.getDataFromJson("url");
	String BROWSER = flib.getDataFromJson("browser");
	if(BROWSER.equalsIgnoreCase("chrome"))
	{
		driver =new ChromeDriver();
	}
	else {
		System.out.println("Invalid browser");
	}
	driver.manage().window().maximize();
	wlib.waitUntilPageLoad(driver);
	driver.get(URL);
}

@BeforeMethod
public void loginToApp() throws Throwable {
	String USERNAME = flib.getDataFromJson("username");
	String PASSWORD = flib.getDataFromJson("password");
	Login lp = new Login(driver);
	lp.loginToApp(USERNAME, PASSWORD);
	}

@AfterClass
public void logOutOfApp() {
	driver.close();
}

@AfterSuite
public void closeDb() {
	//dlib.closeDb();
	
	}
}
