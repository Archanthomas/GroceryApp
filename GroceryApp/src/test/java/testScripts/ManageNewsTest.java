package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ManageNews;

public class ManageNewsTest extends BaseClass {
	
	LoginPage login;
	HomePage home;
	ManageNews managenews;
  @Test
  public void verifyTheAddtionOfNewNews() throws IOException {
	  
	  login = new LoginPage(driver);
		home = login.loginByUsingExcelData();
		
		managenews=home.clickOnManageNews().newButton().newNews().saveButton();
		 boolean isalertDisplayed = managenews.isAlertDisplayed();
			Assert.assertTrue(isalertDisplayed, "Alert not displayed for valid inputs");
	  
	  
  }
  
  @Test
  public void verifyTheEditActionOfNews() throws IOException {
	  
	  login = new LoginPage(driver);
		home = login.loginByUsingExcelData();
		
		managenews=home.clickOnManageNews().editNews("This is the updated new news").updateButtonClick();
		 boolean isalertDisplayed = managenews.isAlertDisplayed();
			Assert.assertTrue(isalertDisplayed, "Alert not displayed for valid inputs");
	  
		 
	  
	  
  }
}
