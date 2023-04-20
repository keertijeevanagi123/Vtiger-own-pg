package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;

import org.openqa.selenium.support.FindAll;

public class LoginPage extends WebDriverUtility
  { //Rule 1: create a separate POM class for every web page
	//Rule 2 : Identify all the web elements using annotations
	@FindBy(name="user_name")
	private WebElement UserNameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindAll({@FindBy(id = "submitButton"),@FindBy(xpath="//input[@type = 'submit']")})
	private WebElement submitBtn;
	
	// Rule 3:Initiliase with these web elements with a constructor
	//public WebDriver driver;
	//public LoginPage(WebDriver sDriver)
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		//PageFactory.initElements(sDriver, this);
		//this.driver=driver;
		//PageFactory.initElements(this.driver, driver);
	}
	//Rule 4: Provide getters to access these elements
	public WebElement getUserNameEdt() {
		return UserNameEdt;
	}
	public WebElement getPasswordEdt() {
		return passwordEdt;
	}
	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	//Buisness Library-Generic methods-Project specifics
	/**
	 * This method will Login to the applicatin
	 * @param USERNAME
	 * @param PASSWORD
	 */
	public void loginToApp(String USERNAME, String PASSWORD) 
	{
		 System.out.println(USERNAME+"USERNAME**");
		 System.out.println(PASSWORD+"PASSWORD**");
//		 driver.findElement(By.name("user_name")).sendKeys("admin");
//		driver.findElement(By.name("user_password")).sendKeys("admin");
		 UserNameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);
		submitBtn.click();
		}
	
		

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
