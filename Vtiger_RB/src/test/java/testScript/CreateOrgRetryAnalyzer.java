package testScript;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateOrgRetryAnalyzer {
	@Test(retryAnalyzer =)
	public void createOrgRetryAnalyzer() {
		System.out.println("org creation failed");
		Assert.fail();
	}
}
