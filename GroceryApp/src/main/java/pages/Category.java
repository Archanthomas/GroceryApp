package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.FileUploadUtilities;
import Utilities.Page_Utilities;

public class Category {
	
	public WebDriver driver;
	Page_Utilities page = new Page_Utilities();
	FileUploadUtilities file = new FileUploadUtilities();

	public Category(WebDriver driver) // constructor
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);// to initialize web elements

	}
 @FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")WebElement newButton;
 @FindBy(xpath="//input[@id='category']")WebElement categoryField;
 @FindBy(xpath="//li[@id='134-selectable']")WebElement selectGroup;
 @FindBy(xpath="//input[@id='main_img']")WebElement chooseFile;
 @FindBy(xpath="//input[@name=\"show_home\" and @value='no']")WebElement showOnLeftMenuRadiobutton;
 @FindBy(xpath="//button[@type='submit']")WebElement saveButton;
 @FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alert;
 
 public Category clickOnNewButton()
 {
	newButton.click(); 
	return this;
 }
 public Category enterCategory()
	{
		categoryField.sendKeys("Phone"+page.generateCurrentDateAndTime());//current date and time will add to the sub category to prevent duplicate.
		return this;
	}
 public Category clickOnSelectGroup()
 {
	 selectGroup.click();
	 return this;
 }
 public Category uploadImageUsingSendKeys(String filePath) {
	    file.fileUploadUsingsendkeys(chooseFile, filePath);
	    return this;
	}
 
 /*public void selectShowOnLeftMenu() {
	    page.clickRadioButton(showOnLeftMenuRadiobutton);
	}*/
 
 public Category clickOnSaveButton()
 {
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click();", saveButton);
	    return this;
 }
 public boolean isAlertDisplayed()
 {
	return alert.isDisplayed();
	 
 }
}
