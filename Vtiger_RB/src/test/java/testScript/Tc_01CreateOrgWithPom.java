package testScript;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.ExcelUtility;
import com.crm.vtiger.GenericUtils.FileUtility;
import com.crm.vtiger.GenericUtils.JavaUtility;
import com.crm.vtiger.GenericUtils.WebDriverUtility;
import com.crm.vtiger.pomclass.CreateNewOrganization;
import com.crm.vtiger.pomclass.Home;
import com.crm.vtiger.pomclass.Login;
import com.crm.vtiger.pomclass.OrgInfoPage;
import com.crm.vtiger.pomclass.Organizations;

public class Tc_01CreateOrgWithPom {
	@Test
	public static void CreateOrgWithPom() throws Throwable {
		
	
		/*create object*/
		ExcelUtility elib= new ExcelUtility();
		FileUtility flib= new FileUtility();
		JavaUtility jlib= new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		WebDriver driver= null;
		
		/*read common data*/
		String	Username=flib.getPropertykeyvalue("username");
		String	Password=flib.getPropertykeyvalue("password");
		String	Url=flib.getPropertykeyvalue("url");
		String	Browser=flib.getPropertykeyvalue("browser");
		
		/*read common data*/
		@SuppressWarnings("static-access")
		String orgName=elib.getExcelData("orgName", 1, 1)+"_"+jlib.getRandomData();
		System.out.println(orgName);
		String emp = elib.getExcelData("orgName",3,1);
		
		/*Step 1 : Launch the browser*/
		
		if (Browser.equals("Firefox")) {
			driver=new FirefoxDriver();
		}
		else if (Browser.equals("edge")) {
			driver= new EdgeDriver();
		}
		else {
			driver= new ChromeDriver();
		}
		
		/*Step 2: Login to app*/
		driver.get(Url);
		Login lp = new Login(driver);
		lp.loginToApp(Username, Password);
		
		/*Step 3: navigate to org*/
		Home hp = new Home(driver);
		hp.getOrganizationLnk().click();
		
		/*Step 4: navigate to create org page*/
		Organizations op =new Organizations(driver);
		op.getCreateOrgImg().click();
		
		
		
		/*Step 5: create org*/
		CreateNewOrganization cnop = new CreateNewOrganization(driver);
		cnop.createOrg(orgName, "Apparel", emp);
		
		/*Step 6: verify*/
		OrgInfoPage oinfop = new OrgInfoPage(driver);
		wlib.waitForElementVisibility(driver,oinfop.getOrgHeaderSucInfo());
		String actSucMsg= oinfop.getOrgHeaderSucInfo().getText();
		if (actSucMsg.contains(orgName)) {
			System.out.println("org created");
			}
			else {
				System.out.println("org not created");
			}
		/*Step 7: logout*/
		hp.logout();
		/*Step 8: close the browser*/
		driver.close();
		}
	}	

