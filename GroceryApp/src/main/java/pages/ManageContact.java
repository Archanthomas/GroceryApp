package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.FakerUtility;
import Utilities.FileUploadUtilities;
import Utilities.Page_Utilities;

public class ManageContact {

	public WebDriver driver;
	Page_Utilities page = new Page_Utilities();
	FakerUtility faker = new FakerUtility();

	public ManageContact(WebDriver driver) // constructor
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);// to initialize web elements

	}

	@FindBy(xpath = "//a[@href=\"https://groceryapp.uniqassosiates.com/admin/contact/edit_contact?edit=1\"]")
	WebElement actionButtonClick;
	@FindBy(xpath = "//input[@id='phone']")
	WebElement phoneField;
	@FindBy(xpath = "//input[@id='email']")
	WebElement emailField;
	@FindBy(xpath = "//textarea[@name='address']")
	WebElement addressField;
	@FindBy(xpath = "//textarea[@name='del_time']")
	WebElement deliveryTime;
	@FindBy(xpath = "//input[@name='del_limit']")
	WebElement deliverychargeLimit;
	@FindBy(xpath = "//button[@name=\"Update\"]")
	WebElement updateButton;
	@FindBy(xpath="//div[@class=\"alert alert-success alert-dismissible\"]")WebElement alert;
	

	public ManageContact clickOnActionButton() {
		actionButtonClick.click();
		return this;
	}

	public ManageContact updatePhoneNumber() {

		String phoneNumber = faker.generatePhone();
		phoneField.clear();
		phoneField.sendKeys(phoneNumber);
		return this;
	}

	public ManageContact updateEmail() {
		String email = faker.gnerateEmail();
		emailField.clear();
		emailField.sendKeys(email);
		return this;
	}

	public ManageContact updateAddress() {
		String address = faker.generateAddress();
		emailField.clear();
		emailField.sendKeys(address);
		return this;
	}

	public ManageContact updatedeliveryTime(String time) {
		
        deliveryTime.clear();
		deliveryTime.sendKeys(time);
		return this;
	}
	
	public ManageContact updatedeliveryChargeLimit(String limit) {
		deliverychargeLimit.clear();
		deliverychargeLimit.sendKeys(limit);
		return this;
	}

	public ManageContact updateButtonClick() {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("arguments[0].click();", updateButton);
		    return this;
	}
	public boolean isAlertDisplayed()
	 {
		return alert.isDisplayed();
		 
	 }
	

}
