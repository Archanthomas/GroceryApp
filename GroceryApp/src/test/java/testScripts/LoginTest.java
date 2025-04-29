package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;



public class LoginTest extends BaseClass {
  @Test
  public void verifyLoginWithValidCredentials() throws IOException {
	  
	 LoginPage login = new LoginPage(driver);
	 login.loginByUsingExcelData();
	 boolean isHomePageLoaded = login.ishomePageLoaded();
	 Assert.assertTrue(isHomePageLoaded, Constants.LP_VERIFYLOGINWITHVALIDCREDENTIALS);
	 
  }
  
  
  @Test
  public void verifyUsernameWithValidUsernameandInvalidPassword()
  {
	  LoginPage login = new LoginPage(driver);
	  login.enterUsernameOnUsernameField("admin");
	  login.enterPasswordOnPasswordField("abc");
	  login.SignInButtonClick();; 
	  boolean isalertDisplayed = login.isAlertDispalyed();
	  Assert.assertTrue(isalertDisplayed, "Alert not displayed for incoorect password");
  }
  
  @Test
  public void verifyUsernameWithInvalidUsernameandValidPassword()
  {
	  LoginPage login = new LoginPage(driver);
	  login.enterUsernameOnUsernameField("abc");
	  login.enterPasswordOnPasswordField("admin");
	  login.SignInButtonClick(); 
	  boolean isalertDisplayed = login.isAlertDispalyed();
	  Assert.assertTrue(isalertDisplayed, "Alert not displayed for incoorect Username");
  }
  
  @Test
  public void verifyUsernameWithInvalidUsernameandInvalidPassword()
  {
	  LoginPage login = new LoginPage(driver);
	  login.enterUsernameOnUsernameField("abc");
	  login.enterPasswordOnPasswordField("123");
	  login.SignInButtonClick(); 
	  boolean isalertDisplayed = login.isAlertDispalyed();
	  Assert.assertTrue(isalertDisplayed, "Alert not displayed for invalid username and password");
  }
  
  @Test(dataProvider="invalid_inputs")
  public void invalidCases(String name, String password)
  {
	LoginPage login = new LoginPage(driver);
	login.enterUsernameOnUsernameField(name);
	login.enterPasswordOnPasswordField(password);
	login.SignInButtonClick();
	boolean isalertDisplayed = login.isAlertDispalyed();
	Assert.assertTrue(isalertDisplayed, "Alert not displayed for invalid inputs");
	  
  }
  
  @DataProvider(name="invalid_inputs")
  public Object[][] invalidinputs()
  {
	 return new Object[][] {{"1" ,"2"},{"Admin","@123"},{"wer","Admin"}};
  }
}
