package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.FileUploadUtilities;
import Utilities.Page_Utilities;

public class SubCategory {

	public WebDriver driver;
	Page_Utilities page = new Page_Utilities();
	FileUploadUtilities file = new FileUploadUtilities();

	public SubCategory(WebDriver driver) // constructor
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);// to initialize web elements

	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement NewButton;
	@FindBy(xpath = "//select[@name='cat_id']")
	WebElement subcategoryDropDown;
	@FindBy(xpath = "//input[@name='subcategory']")
	WebElement subCategoryField;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement chooseFile;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement successAlert;
	@FindBy(xpath = "//i[@class='fas fa-edit']/parent::a[@href='https://groceryapp.uniqassosiates.com/admin/Subcategory/edit?edit=3637&page_ad=1']")WebElement editButton;
	@FindBy(xpath = "//button[@name='update']")WebElement updateButton;
	@FindBy(xpath="//a[@onclick='click_button(2)']")WebElement searchButton;
	@FindBy(xpath="//select[@class='form-control selectpicker']")WebElement categoryDropdown;
	@FindBy(xpath="//input[@class='form-control']")WebElement searchInputField;
	@FindBy(xpath="//button[@type='submit']")WebElement searchButtonClick;
	
	@FindBy(xpath = "//table//td[contains(text(),'pen123')]")
	WebElement searchedSubCategory;
	
	public SubCategory clickOnNewbutton()
	{
		NewButton.click();
		return this;
	}
	
	public SubCategory selectCategory()
	
	{
		page.selectDropDownWithVisibletext(subcategoryDropDown, "veggies");
		return this;
	}
	
	public SubCategory enterSubCategory()
	{
		subCategoryField.sendKeys("Potato"+page.generateCurrentDateAndTime());//current date and time will add to the sub category to prevent duplicate.
		return this;
	}

	public SubCategory uploadImage(String path)
	{
		file.fileUploadUsingsendkeys(chooseFile, path);
		return this;
	}
	
	public SubCategory saveButtonClick()
	{
		saveButton.click();
		return this;
	}
	
	public boolean isAlertDisplayed()
	{
		return successAlert.isDisplayed();
		
	}
	
	public SubCategory editButtonClick()
	{
		editButton.click();
		return this;
	}
	
   public SubCategory editCategory(String categoryName)
	
	{
		page.selectDropDownWithVisibletext(subcategoryDropDown, categoryName);
		return this;
	}
   
   public SubCategory updateButtonClick()
   {
	   updateButton.click();
	   return this;
   }
   public SubCategory searchButtonClick()
   {
	   searchButton.click();
	   return this;
   }
   
   public SubCategory categoryDropDown()
   {
	   page.selectDropDownWithVisibletext(categoryDropdown, "Accessories");
	   return this;
   }
   public SubCategory searchInputField()
   {
	   searchInputField.sendKeys("Pen");
	   return this;
   }
   
   public SubCategory searchButtonClick2()
   {
	 searchButtonClick.click();  
	 return this;
   }
   
   public boolean isSearchedSubcategoryDisplayed(String subcategoryName) {
	    WebElement element = driver.findElement(By.xpath("//table//td[contains(text(),'" + subcategoryName + "')]"));
	    return element.isDisplayed();
	}
	
}
