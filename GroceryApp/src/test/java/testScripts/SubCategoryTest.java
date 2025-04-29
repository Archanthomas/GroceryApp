package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.SubCategory;

public class SubCategoryTest extends BaseClass {
	LoginPage login;
	HomePage home;
	SubCategory subcategory;

	@Test
	public void verifyAddNewSubcategoryWithValidDetails() throws IOException {

		login = new LoginPage(driver);
		home = login.loginByUsingExcelData();

		subcategory = home.clickOnSubCategory().clickOnNewbutton().selectCategory().enterSubCategory()
				.uploadImage(Constants.SUBCATEGORY_IMAGE_PATH).saveButtonClick();
		boolean isAlerDisplayed = subcategory.isAlertDisplayed();
		Assert.assertTrue(isAlerDisplayed, "Subcatedory is not added successfully");
	}

	@Test
	public void verifyEditActionInSubcategory() throws IOException {

		login = new LoginPage(driver);
		home = login.loginByUsingExcelData();

		subcategory = home.clickOnSubCategory().editButtonClick().editCategory("Veg").updateButtonClick();

		boolean isAlerDisplayed = subcategory.isAlertDisplayed();
		Assert.assertTrue(isAlerDisplayed, "Subcatedory is not updated successfully");

	}

	@Test
	public void verifySerachActionInSubcategory() throws IOException {
		login = new LoginPage(driver);
		home = login.loginByUsingExcelData();

		 subcategory = home.clickOnSubCategory().searchButtonClick().categoryDropDown().searchInputField().searchButtonClick2();
		 boolean isSubcategoryDisplayed = subcategory.isSearchedSubcategoryDisplayed("pen123");
		 Assert.assertTrue(isSubcategoryDisplayed, "Subcategory 'pen123' was not found in the search results.");
		
	}
}
