package testScript;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.pomclass.CreateNewOrganization;
import com.crm.vtiger.pomclass.Home;
import com.crm.vtiger.pomclass.OrganizationInfo;
import com.crm.vtiger.pomclass.Organizations;

public class Tc_01CreateOrgWithBaseClass extends BaseClass {
	@SuppressWarnings("static-access")
	@Test
	
	public void createOrgWithBaseClass() throws Throwable, Throwable {
		Home h= new Home(driver);
		h.getOrganizationLnk().click();
		Organizations og = new Organizations(driver);
		og.getCreateOrgImg().click();
		String ORGNAME = elib.getExcelData("orgName", 1, 1)+"_"+jlib.getRandomData();
		String EMP = elib.getExcelData("orgName", 3, 1);
		CreateNewOrganization cn = new CreateNewOrganization(driver);
		cn.createOrg(ORGNAME, "Apparel", EMP);
		OrganizationInfo oInf= new OrganizationInfo(driver);
		System.out.println(oInf.getSuccesFullMsg()); 
		
		
	}
	
	

}
