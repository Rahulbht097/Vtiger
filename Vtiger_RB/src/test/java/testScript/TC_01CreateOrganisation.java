package testScript;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.FileUtility;
import com.crm.vtiger.GenericUtils.WebDriverUtility;
public class TC_01CreateOrganisation {
	@Test
	public static void CrtOrg() throws Throwable  {
		FileUtility file=new FileUtility();
		WebDriverUtility web =new WebDriverUtility();
	String	Username=file.getPropertykeyvalue("username");
	String	Password=file.getPropertykeyvalue("password");
	String	Url=file.getPropertykeyvalue("url");
		WebDriver driver=new ChromeDriver();
		driver.navigate().to(Url);
		driver.manage().window().maximize();
		driver.findElement(By.name("user_name")).sendKeys(Username);
		driver.findElement(By.name("user_password")).sendKeys(Password);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[contains(@alt,'Create Organization...')]")).click();
		driver.findElement(By.name("accountname")).sendKeys("RBWORLD");
		driver.findElement(By.xpath("(//input[contains(@onfocus,'this')])[4]")).sendKeys("www.RBWORLD.com");
		driver.findElement(By.id("employees")).sendKeys("50");
		WebElement elm = driver.findElement(By.name("industry"));// everytime for drop down options first find the path of box
		web.SelecOptionByValue(elm,"Education" );
		//and store in web elements (return type)
		//Select s= new Select(Web);// create select class and pass refrence variable of webelements return type as argument
		//s.selectByValue("Education");
		WebElement web1= driver.findElement(By.name("accounttype"));
		web.SelecOptionByValue(web1, "Prospect");
		driver.findElement(By.name("emailoptout")).click();
		driver.findElement(By.name("phone")).sendKeys("1234");
		driver.findElement(By.name("fax")).sendKeys("12340@abu");
		driver.findElement(By.name("otherphone")).sendKeys("5468974512");
		driver.findElement(By.name("email1")).sendKeys("www.rahulbht097@gmail.com");
		WebElement rating = driver.findElement(By.name("rating"));
		web.SelecOptionByValue(rating, "Active");
		driver.findElement(By.name("annual_revenue")).clear();
		driver.findElement(By.name("annual_revenue")).sendKeys("90000000");
		driver.findElement(By.name("notify_owner")).click();
		driver.findElement(By.name("bill_street")).sendKeys("1445 Caldwell Road");
		driver.findElement(By.name("bill_city")).sendKeys("Yates City");
		driver.findElement(By.name("bill_state")).sendKeys("Illinois");
		driver.findElement(By.name("bill_code")).sendKeys("11004");
		driver.findElement(By.name("bill_country")).sendKeys("France");
		driver.findElement(By.xpath("(//input[@name='cpy'])[2]")).click();
		driver.findElement(By.name("description")).sendKeys("My Organization is a global leader in IT services, consulting & business solutions with a large network of innovation & delivery centers. ");
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//td[@class='small'])[2]")).click();
		WebElement save = driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]"));
		//JavascriptExecutor js= (JavascriptExecutor)driver;//for scrolling
		//js.executeScript("window.scrollBy(0,500)");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",save);
		save.click();
		web.waitUntilPageLoad(driver);
		driver.findElement(By.linkText("Sign Out")).click();
		}
	}