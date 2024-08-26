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
public void enterUserNameField(String userName)
{
	userNameField.sendKeys(userName);
}
public void enterPasswordField(String password)
{
	passwordField.sendKeys(password);
}
public void clickSubmitButton()
{
	submitButton.click();
}
public boolean isDashboardisLoaded()
{
	return dashBoard.isDisplayed();
}
public boolean isAlertDisplayed()
{
	return alert.isDisplayed();
}
}