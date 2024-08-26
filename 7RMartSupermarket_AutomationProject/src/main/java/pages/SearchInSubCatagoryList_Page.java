package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Page_Utilities;

public class SearchInSubCatagoryList_Page {
	WebDriver driver;
	public SearchInSubCatagoryList_Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category'][@class='small-box-footer']")WebElement subCatagoryPageLink;
	@FindBy(xpath="//a[@href='javascript:void(0)']")WebElement openSearchSubCatagoryPage;
	@FindBy(xpath="//select[@id='un']")WebElement selectCatagory;
	@FindBy(xpath="//input[@class='form-control']")WebElement subCatagoryField;
	@FindBy(xpath="//button[@type='submit']")WebElement SearhSubCategoryButton;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']")WebElement searchFound; 
	public void openSubCatagoryPage()
	{
		subCatagoryPageLink.click();
	}
	public void clickSearchSubCatagoryButton()
	{
		openSearchSubCatagoryPage.click();
	}
	public void selectCatagoryValue(String catagory)
	{
		Page_Utilities page=new Page_Utilities();
		page.selectMethord(selectCatagory,catagory);
	}
	public void enterSubCatagory(String subCatagory)
	{
		subCatagoryField.sendKeys(subCatagory);
	}
	public void searchSubCatagory()
	{
		SearhSubCategoryButton.click();
	}
	public boolean isSearchResultDisplayed()
	{
		return searchFound.isDisplayed();
	}
}
