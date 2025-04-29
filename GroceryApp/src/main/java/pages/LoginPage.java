package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.ExcelUtility;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// to initialize web elements

	}

	@FindBy(xpath = "//input[@name='username']")
	WebElement usernameField;// to declare web element.
	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordField;
	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	WebElement SignInButton;
	@FindBy(xpath = "//span[text()='7rmart supermarket']")
	WebElement homepageicon;
	@FindBy(xpath = "//i[@class='icon fas fa-ban']")
	WebElement alert;

	public void enterUsernameOnUsernameField(String username) {

		usernameField.sendKeys(username);
	}

	public void enterPasswordOnPasswordField(String password) {
		passwordField.sendKeys(password);
	}

	public HomePage SignInButtonClick() {
		SignInButton.click();
		return new HomePage(driver);
	}

	public boolean ishomePageLoaded() {
		return homepageicon.isDisplayed();
	}

	public boolean isAlertDispalyed() {
		return alert.isDisplayed();

	}

	public HomePage loginByUsingExcelData() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "login");
		String password = ExcelUtility.getStringData(1, 1, "login");
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		SignInButton.click();
		return new HomePage(driver);

	}

}
