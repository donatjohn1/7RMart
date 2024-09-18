package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteCategoryDetails_Page {
WebDriver driver;
public DeleteCategoryDetails_Page(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category']//i[@class='fas fa-arrow-circle-right']")WebElement catagoryPageLink;
@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[15]/td[4]//i[@class='fas fa-trash-alt']")WebElement deleteCategoryButton;
@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alert;
public void openCatagoryPage()
{
	catagoryPageLink.click();
}
public void clickDeleteCatagoryButton()
{
	deleteCategoryButton.click();
	driver.switchTo().alert().accept();
}
public boolean isAlertDisplayed()
{
	return alert.isDisplayed();
}
}
