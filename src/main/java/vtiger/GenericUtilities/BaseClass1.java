package vtiger.GenericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;

public class BaseClass1 {

	public ExcelFileUtility eUtil= new ExcelFileUtility();
	public PropertyFileUtility pUtil= new PropertyFileUtility();
	public JavaUtility jUtil = new JavaUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	public WebDriver driver = null;
	public static WebDriver sDriver; //this is for listeners
	@BeforeSuite
	public void bsConfig() {
		System.out.println("----- database connection successful -----");
	}
	//@Parameters("browser")// chrome firefox
	//@BeforeTest
	//@BeforeClass(groups={"SmokeSuite","RegressionSuite"})-->for all the annotation we need to give
	@BeforeClass
	
	public void bcConfig(/*String BROWSER*/) throws IOException {
		String URL = pUtil.readDataFromPropertyFile("url");
		
		//WebDriver driver = new FirefoxDriver();
		ChromeOptions CO= new ChromeOptions();
		CO.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(CO);
		sDriver= driver;// this is for listener
		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(URL);
		
	}	@BeforeMethod()
	public void bmConfig( ) throws IOException 	
	{		String USERNAME = pUtil.readDataFromPropertyFile("username");
	    String PASSWORD = pUtil.readDataFromPropertyFile("password");
	    
		LoginPage lp = new LoginPage(driver);
	lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("--- Login to APP successful ---");
	}
	
	@AfterMethod
	public void amConfig()
	{
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();
		System.out.println("--- logout of APP successful ---");
	}
	//@AfterTest
	@AfterClass
	public void acConfig() 
	{
		driver.quit();
        System.out.println("--- Browser closed ---");
	}
	@AfterSuite
	public void asConfig() {
		System.out.println("----- database closed successfully -----");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
