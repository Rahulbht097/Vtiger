package testScript;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.FileUtility;
public class TC_01CreateContact {
	@Test
	public static void CrtCon() throws Throwable  {
		FileUtility f=new FileUtility();
		WebDriver driver = new ChromeDriver();
	String	Username=f.getPropertykeyvalue("username");
	String	Password=f.getPropertykeyvalue("password");
	String	URL=f.getPropertykeyvalue("url");
	driver.navigate().to(URL);
	driver.manage().window().maximize();
	driver.findElement(By.name("user_name")).sendKeys(Username);
	driver.findElement(By.name("user_password")).sendKeys(Password);
	driver.findElement(By.id("submitButton")).click();
	driver.findElement(By.linkText("Contacts")).click();
	driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
	WebElement desig = driver.findElement(By.xpath("//select[@name='salutationtype']"));
	Select s = new Select(desig);
	s.selectByValue("Mr.");
	driver.findElement(By.name("firstname")).sendKeys("RAHUL");
	driver.findElement(By.name("lastname")).sendKeys("BHAT");
	driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
	Set<String> allWh = driver.getWindowHandles();
	Iterator<String> itr = allWh.iterator();
	String parentWindow = itr.next();
	String childWindow = itr.next();
	driver.switchTo().window(childWindow);
	driver.findElement(By.xpath("//a[.='RBWORLD']")).click();
	driver.switchTo().window(parentWindow);
	Thread.sleep(2000);
	WebElement leadSource = driver.findElement(By.name("leadsource"));
	Select s2 = new Select(leadSource);
	s2.selectByValue("Existing Customer");
	driver.findElement(By.name("email")).sendKeys("ABCD@xyz.com");
	driver.findElement(By.name("notify_owner")).click();
	driver.findElement(By.name("phone")).sendKeys("05226891235");
	driver.findElement(By.name("mobile")).sendKeys("9845632175");
	driver.findElement(By.name("birthday")).sendKeys("1995-08-20");
	driver.findElement(By.name("mailingstreet")).sendKeys("2982 Monroe Avenue");
	driver.findElement(By.name("mailingcity")).sendKeys("PONY");
	driver.findElement(By.name("mailingstate")).sendKeys("Montana");
	driver.findElement(By.name("mailingzip")).sendKeys("145689");
	driver.findElement(By.name("mailingcountry")).sendKeys("New York");
	driver.findElement(By.xpath("(//input[@name='cpy'])[2]")).click();
	driver.findElement(By.name("description")).sendKeys("Our Valuable Customer");
	driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
	driver.findElement(By.xpath("(//td[@class='small'])[2]")).click();
	driver.findElement(By.linkText("Sign Out")).click();

	}
}