package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteAdminUser_Page {
	WebDriver driver;
	public DeleteAdminUser_Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']//i[@class='fas fa-arrow-circle-right']")WebElement adminUserPageLink;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[15]/td[5]//i[@class='fas fa-trash-alt']")WebElement deleteAdminUserButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alert;
	public DeleteAdminUser_Page openAdminUserPageDelete()
	{
		adminUserPageLink.click();
		return this;
	}
	public DeleteAdminUser_Page clickDeleteAdminUserButton()
	{
		deleteAdminUserButton.click();
		driver.switchTo().alert().accept();
		return new DeleteAdminUser_Page(driver);
	}
	public boolean isAlertDisplayed()
	{
		return alert.isDisplayed();
	}
}
