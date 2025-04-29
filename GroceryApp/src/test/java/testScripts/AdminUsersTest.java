package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminUsers;
import pages.HomePage;
import pages.LoginPage;

public class AdminUsersTest extends BaseClass {
	LoginPage login;
	HomePage home;
	AdminUsers adminuser;

	@Test
	public void veifyAdminusernameFromAdminUsersTable() throws IOException {

		login = new LoginPage(driver);
		home = login.loginByUsingExcelData();

		adminuser = home.clickOnAdminUsers().searchButtonClick1();
		boolean isUserFound = adminuser.enterUserName("Rob").searchButtonClick().verifyUserNameInTable("Rob");

		Assert.assertTrue(isUserFound, "❌ Username not found in Admin Users table");
	}

	@Test(groups="smoke")
	public void veifyTheAdditionOfNewAdminuser() throws IOException {

		login = new LoginPage(driver);
		home = login.loginByUsingExcelData();

		adminuser = home.clickOnAdminUsers().newButtonClick().addNewUsername().addNewpassword("123@test")
				.addUserType("2").saveButtonClick();
		 boolean isalertDisplayed = adminuser.isAlertDisplayed();
			Assert.assertTrue(isalertDisplayed, "Alert not displayed for valid inputs");
	}

}
