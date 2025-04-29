package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ManageContact;

public class ManageContactTest extends BaseClass {
	LoginPage login;
	HomePage home;
	ManageContact contact;
  @Test
  public void verifyUpdateContactWithvalidDetails() throws IOException {
	  
	  login = new LoginPage(driver);
	  home=login.loginByUsingExcelData();
	  
	  contact= home.clickOnManageContact().clickOnActionButton().updatePhoneNumber().updateEmail().updateAddress().updatedeliveryTime("6 pm").
			  updatedeliveryChargeLimit("50").updateButtonClick();
	  boolean isalertDisplayed = contact.isAlertDisplayed();
		Assert.assertTrue(isalertDisplayed, "Alert not displayed for valid inputs");
	 
	 
	  
	  
  }
}
