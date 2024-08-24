package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteSubCategoryDetails_Page {
	WebDriver driver;
	public DeleteSubCategoryDetails_Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category'][@class='small-box-footer']")WebElement subCatagoryPageLink;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[15]/td[5]//i[@class='fas fa-trash-alt']")WebElement deleteSubCategoryButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alert;
	public void openSubCatagoryPage()
	{
		subCatagoryPageLink.click();
	}
	public void clickDeleteSubCatagoryButton()
	{
		deleteSubCategoryButton.click();
		driver.switchTo().alert().accept();
	}
	public boolean isAlertDisplayed()
	{
		return alert.isDisplayed();
	}
}
