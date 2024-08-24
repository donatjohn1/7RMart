package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SearchAdminUser_Page {
WebDriver driver;
	
	
	public SearchAdminUser_Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']")WebElement adminUserPageLink;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")WebElement searchAdminUserButton;
	@FindBy(xpath="//input[@id='un']")WebElement userNameSearchField;
	@FindBy(xpath="//select[@id='ut']")WebElement userTypesearchField;
	@FindBy(xpath="//button[@value='sr']")WebElement userSearchButton;
	@FindBy(xpath="//center[text()='.........RESULT NOT FOUND.......']")WebElement searchNotFound; 
	public void openAdminUserPage()
	{
		adminUserPageLink.click();
	}
	public void clickSearchAdminUserButton()
	{
		searchAdminUserButton.click();
	}
	public void enterUserName(String userName)
	{
		userNameSearchField.sendKeys(userName);
	}
	public void userType(String userValue)
	{
		Select selectField=new Select(userTypesearchField);
		selectField.selectByVisibleText(userValue);
	}
	public void clickSearchButton()
	{
		userSearchButton.click();	
	}
	public boolean isSearchResultNotDisplayed()
	{
		return searchNotFound.isDisplayed();
	}
}