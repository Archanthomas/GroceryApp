package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.FakerUtility;
import Utilities.Page_Utilities;

public class AdminUsers {
	
	public WebDriver driver;
	Page_Utilities page = new Page_Utilities();
	FakerUtility faker = new FakerUtility();

	
	public AdminUsers(WebDriver driver) // constructor
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);// to initialize web elements

	}
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")WebElement serarchButtonClick1;
	@FindBy(xpath="//input[@id='un']")WebElement usernameField;
	@FindBy(xpath="//button[@class='btn btn-block-sm btn-danger' and @value='sr']")WebElement searchButton2;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']")WebElement userTable;
	@FindBy(xpath="//a[@onclick='click_button(1)']")WebElement newButtonClick;
	@FindBy(xpath="//input[@id='username']")WebElement addNewUserName;
	@FindBy(xpath="//input[@id='password']")WebElement passwordField;
	@FindBy(xpath="//select[@id='user_type']")WebElement userTypeDropdown;
	@FindBy(xpath="//button[@name='Create']")WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement successAlert;
	
	 
	
	public AdminUsers searchButtonClick1()
	{  
		serarchButtonClick1.click();
		return this;
		
		
	}
	
	public AdminUsers enterUserName(String username) {
		usernameField.clear();
		usernameField.sendKeys(username);
		return this;
		
	}
	
	public AdminUsers searchButtonClick()
	{
		searchButton2.click();
		return  this;
	}
	
	public boolean verifyUserNameInTable(String expectedUsername) {
	    List<WebElement> userNameList = userTable.findElements(By.xpath(".//tbody/tr/td[1]"));
	    for (WebElement userElement : userNameList) {
	        if (userElement.getText().equalsIgnoreCase(expectedUsername)) {
	            return true;
	        }
	    }
	    return false; 
	}   
	
	public AdminUsers newButtonClick()
	{  
		newButtonClick.click();
		return this;
		
	}
	
	public AdminUsers addNewUsername(){
		
		String newusername = faker.generateName();
		addNewUserName.clear();
		addNewUserName.sendKeys(newusername);
		return this;
		
	}
	
	public AdminUsers addNewpassword(String password)
	{
		passwordField.clear();
		passwordField.sendKeys(password);
		return this;
	}

	public AdminUsers addUserType(String value)
	{
		value=page.selectDropdownWithIndex(userTypeDropdown, 2);
		return this;
	}
	
	public AdminUsers saveButtonClick() {
		saveButton.click();
		return this;
	}
	
	public boolean isAlertDisplayed()
	{
		return successAlert.isDisplayed();
		
	}
}
