package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.WaitUtilities;

public class HomePage {

	public WebDriver driver;
	WaitUtilities wait = new WaitUtilities();

	public HomePage(WebDriver driver) // constructor
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);// to initialize web elements

	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category']")
	WebElement subCategoryLink;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category']/parent::li[@class='nav-item']") WebElement categoryLink;
	@FindBy(xpath="//a[@href=\"https://groceryapp.uniqassosiates.com/admin/list-contact\"]/parent::li[@class='nav-item']")WebElement manageContactLink;
	@FindBy(xpath="//div[@class='small-box bg-info']//parent::a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']")WebElement adminUsersLink;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='active nav-link']")WebElement manageNewsLink;

	public SubCategory clickOnSubCategory() {
		subCategoryLink.click();
		return new SubCategory(driver);
	}
	
	public Category clickOnCategory() {
		wait.waitForElementtobeClickable(driver, categoryLink);
		 System.out.println("Is displayed: " + categoryLink.isDisplayed());
	        System.out.println("Is enabled: " + categoryLink.isEnabled());
		categoryLink.click();
		return new Category(driver);
	}
	
	public ManageContact clickOnManageContact() {
		manageContactLink.click();
		return new ManageContact(driver);
	}
	
	public AdminUsers clickOnAdminUsers() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 seconds wait
	    wait.until(ExpectedConditions.elementToBeClickable(adminUsersLink));
	    adminUsersLink.click();
		return new AdminUsers(driver);
	}
	
	public ManageNews clickOnManageNews() {
		manageNewsLink.click();
		return new ManageNews(driver);
	}

}
