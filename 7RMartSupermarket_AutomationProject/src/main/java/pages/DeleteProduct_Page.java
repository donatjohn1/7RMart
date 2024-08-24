package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteProduct_Page {
	WebDriver driver;
	public DeleteProduct_Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-product'][@class='small-box-footer']")WebElement manageProductPage;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[15]/td[9]//i[@class='fas fa-trash-alt']")WebElement deleteProduct; 
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alert;
	public void openManageProductPage()
	{
		manageProductPage.click();
	}
	public void clickDeleteProductButton()
	{
		deleteProduct.click();
		driver.switchTo().alert().accept();
	}
	public boolean isAlertDisplayed()
	{
		return alert.isDisplayed();
	}
}
