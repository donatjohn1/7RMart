package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Page_Utilities;

public class EditUserInformation_Page {
WebDriver driver;
public EditUserInformation_Page(WebDriver driver)
{
this.driver=driver;
PageFactory.initElements(driver, this);
}
@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']")WebElement adminUserPageLink;
@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[3]/td[5]//i[@class='fas fa-edit']")WebElement editUserInformationButton;
@FindBy(xpath="//input[@id='username']")WebElement editUserNameField;
@FindBy(xpath="//input[@id='password']")WebElement editPasswordField;
@FindBy(xpath="//select[@id='user_type']")WebElement editUserTypefield;
@FindBy(xpath="//button[@name='Update']")WebElement UpdateUserButton;
@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alert;
public void openAdminUserPage()
{
	adminUserPageLink.click();
}
public void clickEditUserInformationButton()
{
	
	editUserInformationButton.click();
}
public void enterEditUserNameField(String newUserName)
{
	editUserNameField.clear();
	editUserNameField.sendKeys(newUserName);
}
public void enterEditPasswordField(String newPassword)
{
	editPasswordField.clear();
	editPasswordField.sendKeys(newPassword);
}
public void selectUserType(String userType)
{
	Page_Utilities page=new Page_Utilities();
	page.selectMethord(editUserTypefield, userType);
}
public void clickUpdateUserButton()
{
	UpdateUserButton.click();
}
public boolean isAlertDisplayed()
{
	return alert.isDisplayed();
}

}
