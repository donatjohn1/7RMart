package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Page_Utilities;

public class NewAdminUser_Page {

	WebDriver driver;
	
	
	public NewAdminUser_Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']//i[@class='fas fa-arrow-circle-right']")WebElement adminUserPageLink;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")WebElement addNewAdminUserButton;
	@FindBy(xpath="//input[@id='username']")WebElement newUserNameField;
	@FindBy(xpath="//input[@id='password']")WebElement newPasswordField;
	@FindBy(xpath="//select[@id='user_type']")WebElement newUserTypefield;
	@FindBy(xpath="//button[@name='Create']")WebElement saveNewUserButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alert;
	public NewAdminUser_Page openAdminUserPage()
	{
		adminUserPageLink.click();
		return this;
	}
	public NewAdminUser_Page clickaddNewAdminUserButton()
	{
		addNewAdminUserButton.click();
		return this;
	}
	public NewAdminUser_Page enterNewUserNameInField(String newUserName)
	{
		newUserNameField.sendKeys(newUserName);
		return this;
	}
	public NewAdminUser_Page enterNewPasswordInField(String newPassword)
	{
		newPasswordField.sendKeys(newPassword);
		return this;
	}
	public NewAdminUser_Page selectUserType(String userType)
	{
		Page_Utilities page=new Page_Utilities();
		page.selectMethord(newUserTypefield, userType);
		return this;
	}
	public NewAdminUser_Page clickSaveButton()
	{
		saveNewUserButton.click();
		return this;
	}
	public boolean isAlertDisplayed()
	{
		return alert.isDisplayed();
	}
}
