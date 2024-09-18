package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Wait_Utilities;

public class AddNewPage_Page {
	WebDriver driver;
	public AddNewPage_Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//p[text()='Manage Content']")WebElement manageContent;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-page']")WebElement managePage;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/pages/add']")WebElement addNewPage;
	@FindBy(xpath="//input[@id='title']")WebElement titleField;
	@FindBy(xpath="//div[@class='note-editable card-block']")WebElement descriptionField;
	@FindBy(xpath="//input[@id='page']")WebElement pageNameField;
	@FindBy(xpath="//input[@id='main_img']")WebElement chooseFile;
	@FindBy(xpath="//button[@type='submit']")WebElement saveNewPageButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alert;
	public void clickManageContent()
	{
		manageContent.click();
	}
	public void clickManagePage()
	{
		managePage.click();
	}
	public void clickNewPage()
	{
		addNewPage.click();
	}
	public void enterTitle(String title)
	{
		titleField.sendKeys(title);
	}
	public void enterDescription(String description)
	{
		descriptionField.sendKeys(description);
	}
	public void enterPageName(String pageName)
	{
		pageNameField.sendKeys(pageName);
		
	}
	public void uploadFile1(String upload)
	{
		chooseFile.sendKeys(upload);
	}
	public void saveNewPage() 
	{
		Wait_Utilities wait1=new Wait_Utilities();
		wait1.waitForAnElementToBeClick(driver,saveNewPageButton);
		saveNewPageButton.click();
	}
	public boolean isAlertDisplayed()
	{
		return alert.isDisplayed();
	}
	
}
