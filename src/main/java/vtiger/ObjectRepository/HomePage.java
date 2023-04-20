package vtiger.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;

import vtiger.GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	//declaration
	@FindBy(linkText ="Organizations")
	private WebElement OrganizationLink;
	
@FindBy(linkText = "Contacts")
private WebElement  ContactsLink;

@FindBy(linkText = "Opportunities")
private WebElement OpportunitiesLink;

@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
private WebElement AdministratorImg;

@FindBy(linkText= "Sign Out")
private WebElement SignOutLink;

//Initialization
public HomePage(WebDriver driver) {
PageFactory.initElements(driver, this);

}

//Utilization
public WebElement getOrganizationLink() {
 return	OrganizationLink;

}
public WebElement getContactsLink() {
return 	ContactsLink;
}
public WebElement getOpportunitiesLink() {
	return OpportunitiesLink;
	
}
public WebElement getAdministratorImg() {
	 return AdministratorImg;
}

public WebElement getSignoutLink() {
return	SignOutLink;
}

//Business Libraries
/**
 * This method will click on OrganizationLink
 */
public void  clickOnOrganizationLink()
{
	OrganizationLink.click();
}
/**
 * This method will click on ContactsLink
 */
public void  clickOnContactsLink()
{
	ContactsLink.click();
}
/**
 * This method will perform Signout operation on web app
 * @param driver
 */
public void logoutOfApp(WebDriver driver)
{
	mouseHoverAction(driver,AdministratorImg);
	SignOutLink.click();

}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	}

