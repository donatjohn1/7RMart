package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchListPage_Page {
	WebDriver driver;
	
	public SearchListPage_Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//i[@class='fas fa-angle-left right']")WebElement manageContent;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-page']")WebElement managePage;
	@FindBy(xpath="//a[@href='javascript:void(0)']")WebElement searchInList;
	@FindBy(xpath="//input[@type='text']")WebElement enterTitleToSearch;
	@FindBy(xpath="//button[@type='submit']")WebElement searchInListButton;
	@FindBy(xpath="//center[text()='.........RESULT NOT FOUND.......']")WebElement searchNotFound; 
	public void clickManageContent()
	{
		manageContent.click();
	}
	public void clickManagePage()
	{
		managePage.click();
	}
	public void clickSearch()
	{
		searchInList.click();
	}
	public void enterTitle(String title)
	{
		enterTitleToSearch.sendKeys(title);
	}
	public void clickSearchButton()
	{
		searchInListButton.click();
	}
	public boolean isSearchResultNotDisplayed()
	{
		return searchNotFound.isDisplayed();
	}
}
