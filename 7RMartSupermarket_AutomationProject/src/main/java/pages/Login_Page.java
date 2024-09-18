package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class Login_Page {
WebDriver driver;

public Login_Page(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="//input[@type='text']")WebElement userNameField;
@FindBy(xpath="//input[@type='password']")WebElement passwordField;
@FindBy(xpath="//button[@type='submit']")WebElement submitButton;
@FindBy(xpath="//p[text()='Dashboard']")WebElement dashBoard;
@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")WebElement alert;
@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']//i[@class='fas fa-arrow-circle-right']")WebElement adminUserPageLink;
@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category']//i[@class='fas fa-arrow-circle-right']")WebElement catagoryPageLink;
public Login_Page enterUserNameField(String userName) {
	userNameField.sendKeys(userName);
	return this;
}

public Login_Page enterPasswordField(String password) {
	passwordField.sendKeys(password);
	return this;
}

public Login_Page clickSubmitButton() {
	submitButton.click();
	return new Login_Page(driver);
}

public boolean isDashboardisLoaded() {
	return dashBoard.isDisplayed();
}
public NewAdminUser_Page openAdminUserPage(){
	adminUserPageLink.click();
	return new NewAdminUser_Page(driver);
}
public SearchAdminUser_Page openAdminUserPageSearch(){
	adminUserPageLink.click();
	return new SearchAdminUser_Page(driver);
}
public DeleteAdminUser_Page openAdminUserPageDelete()
{
	adminUserPageLink.click();
	return new DeleteAdminUser_Page(driver);
}
public AddNewCategory_Page goToCategory()
{
	catagoryPageLink.click();
	return new AddNewCategory_Page(driver);
}
public boolean isAlertDisplayed() {
	return alert.isDisplayed();
}
}