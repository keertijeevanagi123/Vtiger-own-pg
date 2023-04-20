package vtiger.ObjectRepository;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class CreateNewOrganizationsPage extends WebDriverUtility {
	//declaration
	@FindBy(name="accountname")
	private WebElement OrgNameEdt;
	
	@FindBy(name = "industry")
	private WebElement IndustryDropDown;
	
	@FindBy(xpath ="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	//Initialization
	public  CreateNewOrganizationsPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	//utilization
	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}
	public WebElement getIndustryDropDown() {
		return IndustryDropDown;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	//Business Libraries
	/**
	 * This method will create organization with mandatory information
	 */
	public void CreateNewOrganization(String ORGNAME) {
		OrgNameEdt.sendKeys(ORGNAME);
		SaveBtn.click();
	}
	/**
	 * This method will create organization with Industry dropdown 
	 */
	public void CreateNewOrganization(String ORGNAME,String INDUSTRY) {
		OrgNameEdt.sendKeys(ORGNAME);
		handleDropdown(IndustryDropDown,INDUSTRY);
		SaveBtn.click();
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}


