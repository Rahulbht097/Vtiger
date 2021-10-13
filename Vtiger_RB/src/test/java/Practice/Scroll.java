package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Scroll {
@Test
public void scrollToElement() {
	
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rahul\\Desktop\\Drivers\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.navigate().to("http://localhost:8888/index.php?action=Login&module=Users");
	driver.manage().window().maximize();
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click();
	driver.findElement(By.linkText("Organizations")).click();
	driver.findElement(By.xpath("//img[contains(@alt,'Create Organization...')]")).click();
	WebElement save = driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]"));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true)",save);
	save.click();
}
}
