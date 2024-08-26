package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FileUpload_Utilities;

public class SearchCatagory_Page {
	WebDriver driver;
	public SearchCatagory_Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category']//i[@class='fas fa-arrow-circle-right']")WebElement catagoryPageLink;
	@FindBy(xpath="//a[@href='javascript:void(0)']")WebElement clickSearch;
	@FindBy(xpath="//input[@class='form-control']")WebElement categoryValueField;
	@FindBy(xpath="//button[@type='submit']")WebElement clickSearchButton;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']")WebElement searchFound; 

	FileUpload_Utilities input=new FileUpload_Utilities();
	public void goToCategory()
	{
		catagoryPageLink.click();
	}
	public void clickSearhButtonToOpenSearchPage()
	{
		clickSearch.click();
	}
	public void inputCategory(String categoryValue)
	{
		input.usingSendKeys(categoryValueField, categoryValue);
	}
	public void clickSearchButton()
	{
		clickSearchButton.click();
	}
	public boolean isSearchResultDisplayed()
	{
		return searchFound.isDisplayed();
	}
}
