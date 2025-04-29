package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.FakerUtility;
import Utilities.Page_Utilities;

public class ManageNews {

	public WebDriver driver;
	FakerUtility faker = new FakerUtility();
	Page_Utilities page = new Page_Utilities();

	public ManageNews(WebDriver driver) // constructor
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);// to initialize web elements

	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButtonClick;
	@FindBy(xpath = "//textarea[@id='news']")
	WebElement enterNewsField;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveButtonclick;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;

	@FindBy(xpath = "//i[@class=\"fas fa-edit\"]/parent::a[@href='https://groceryapp.uniqassosiates.com/admin/news/edit?edit=4459&page_ad=1']")
	WebElement editNews;
	@FindBy(xpath="//button[@name='update']")WebElement updateButton;

	public ManageNews newButton() {
		newButtonClick.click();
		return this;
	}

	public ManageNews newNews() {

		String news = faker.generatefakeNewsBody();
		enterNewsField.clear();
		enterNewsField.sendKeys(news);
		return this;
	}

	public ManageNews saveButton() {
		saveButtonclick.click();
		return this;
	}

	public boolean isAlertDisplayed() {

		return alert.isDisplayed();
	}

	public ManageNews editNews(String newnews) {
	    editNews.click(); // click the edit button to open the edit form
	    enterNewsField.clear(); // Clear the old news
	    enterNewsField.sendKeys(newnews+page.generateCurrentDateAndTime()); // Enter the new news text
	    return this;
	}
	
	public ManageNews updateButtonClick() {
		updateButton.click();
		return this;
	}
}
