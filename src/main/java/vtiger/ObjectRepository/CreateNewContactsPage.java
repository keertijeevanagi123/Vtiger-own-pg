package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class CreateNewContactsPage extends WebDriverUtility {

	//declaration
	@FindBy(name="lastname")
	private WebElement lastnameEdt;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::Img[@title='Select']")
	private WebElement OrgLookUpImg;
	
	@FindBy(xpath ="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	@FindBy(name="search_text")
	private WebElement OrgSearchEdt;
	
	@FindBy(name="search")
	private WebElement OrgSearchBtn;
	
	//Initialization
	public CreateNewContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
    //utilization
	public WebElement getlastNameEdt() {
		return lastnameEdt;
		
	} 
	public WebElement getOrgLookupImg() {
		return OrgLookUpImg;
	}
	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	public WebElement getOrgSearchEdt() {
		return OrgSearchEdt;
	}
	public WebElement getOrgSearchBtn() {
		return OrgSearchBtn;
	}
	
	
	//Business Library
	/**
	 * This method will create Contact with mandatory information
	 */
	public void CreateNewContact(String LASTNAME) {
		lastnameEdt.sendKeys(LASTNAME);
		SaveBtn.click();
	}
	/**
	 * This method will create Contact with Organization
	  * @param driver
	 * @param LASTNAME
	 * @param ORGNAME
	 */
	 
	 
	public void CreateNewContact(WebDriver driver,String LASTNAME,String ORGNAME) {
		lastnameEdt.sendKeys(LASTNAME);
		OrgLookUpImg.click();
		switchToWindow(driver,"Accounts");
		OrgSearchEdt.sendKeys(ORGNAME);
		OrgSearchBtn.click();
		driver.findElement(By.xpath("//a[.='"+ORGNAME+"']")).click();
		switchToWindow(driver,"Contacts");
		SaveBtn.click();
}
}


