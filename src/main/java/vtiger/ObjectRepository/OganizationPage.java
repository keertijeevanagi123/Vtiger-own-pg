package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OganizationPage {

	
	//declaration
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement CreateOrgLookUpImg;
	
	//Initialization
	public OganizationPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getCreateOrgLookUpImg() {
				return CreateOrgLookUpImg;
	}
	//Business Library
	/**
	 * This method will click on create org lookup image
	 */
	public void ClickOnCreateOrgLookUpImg() {
		CreateOrgLookUpImg.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

	}


