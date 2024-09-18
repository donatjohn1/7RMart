package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SearchAdminUser_Page {
WebDriver driver;
	
	
	public SearchAdminUser_Page(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']")WebElement adminUserPageLink;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")WebElement searchAdminUserButton;
	@FindBy(xpath="//input[@id='un']")WebElement userNameSearchField;
	@FindBy(xpath="//select[@id='ut']")WebElement userTypesearchField;
	@FindBy(xpath="//button[@value='sr']")WebElement userSearchButton;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']")WebElement searchFound; 
	public SearchAdminUser_Page openAdminUserPageSearch()
	{
		adminUserPageLink.click();
		return this;
	}
	public SearchAdminUser_Page clickSearchAdminUserButton()
	{
		searchAdminUserButton.click();
		return this;
	}
	public SearchAdminUser_Page enterUserName(String userName)
	{
		userNameSearchField.sendKeys(userName);
		return this;
	}
	public SearchAdminUser_Page userType(String userValue)
	{
		Select selectField=new Select(userTypesearchField);
		selectField.selectByVisibleText(userValue);
		return this;
	}
	public SearchAdminUser_Page clickSearchButton()
	{
		userSearchButton.click();
		return new SearchAdminUser_Page(driver);
	}
	public boolean isSearchResultNotDisplayed()
	{
		return searchFound.isDisplayed();
	}
}