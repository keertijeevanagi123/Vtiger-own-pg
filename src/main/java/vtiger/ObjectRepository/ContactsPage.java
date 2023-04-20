package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
    //declaration
@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")	
private WebElement CreateContactsLookUpImg;
	
	
	//Initialization
	public ContactsPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}
	//utilization
	public WebElement getCreateContactsLookUpImg() {
		return CreateContactsLookUpImg;
	}
	
//Business Libraries
	/**
	 * This method will click on create contact lookup image
	 */
	public void ClickOnCreateContactLookupImg() {
		CreateContactsLookUpImg.click();	
		
	}






}


