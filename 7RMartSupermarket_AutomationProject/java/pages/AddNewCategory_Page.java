package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FileUpload_Utilities;

public class AddNewCategory_Page {
	WebDriver driver;
	public AddNewCategory_Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category']//i[@class='fas fa-arrow-circle-right']")WebElement catagoryPageLink;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Category/add']")WebElement clickNew;
	@FindBy(xpath="//input[@id='category']")WebElement categoryValueField;
	@FindBy(xpath="//li[@id='134-selectable']")WebElement selectGroupDrag;
	@FindBy(xpath="//div[@class='ms-selection']")WebElement selectGroupDrop;
	@FindBy(xpath="//input[@id='main_img']")WebElement uploadImage;
	@FindBy(xpath="//input[@name='top_menu'][@value='yes']")WebElement radioShowOnTopMenu;
	@FindBy(xpath="//input[@name='show_home'][@value='yes']")WebElement radioShowOnLeftMenu;
	@FindBy(xpath="//button[@type='submit']")WebElement clickSaveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alert;
	FileUpload_Utilities input=new FileUpload_Utilities();
	public void goToCategory()
	{
		catagoryPageLink.click();
	}
	public void clickNewButton()
	{
		clickNew.click();
	}
	public void inputCategory(String categoryValue)
	{
		input.usingSendKeys(categoryValueField, categoryValue);
	}
	public void clickDiscount()
	{
		selectGroupDrag.click();
	}
	public void imageUpload(String image) {
		//input.usingSendKeys(uploadImage, image);
		FileUpload_Utilities.fileUpload_RobertClass(uploadImage, image);
	}
	public void clickRadioTopMenu()
	{
		radioShowOnTopMenu.click();
	}
	public void clickRadioLeftMenu()
	{
		radioShowOnLeftMenu.click();
	}
	public void clickSave()
	{
		clickSaveButton.click();
	}
	public boolean isAlertDisplayed()
	{
		return alert.isDisplayed();
	}
}
