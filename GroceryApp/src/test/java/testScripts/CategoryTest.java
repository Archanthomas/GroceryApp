package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.Category;
import pages.HomePage;
import pages.LoginPage;

public class CategoryTest extends BaseClass {
	HomePage home;
	LoginPage login;
	Category category;

	@Test
	public void verifyAddNewCategoryWithValidDetails() throws IOException {

		login = new LoginPage(driver);
		home = login.loginByUsingExcelData();

		category = home.clickOnCategory().clickOnNewButton().enterCategory().clickOnSelectGroup()
				.uploadImageUsingSendKeys(Constants.CATEGORY_IMAGE_PATH)

				.clickOnSaveButton();
		boolean isalertDisplayed = category.isAlertDisplayed();
		Assert.assertTrue(isalertDisplayed, "Alert not displayed for valid inputs");

	}
}
