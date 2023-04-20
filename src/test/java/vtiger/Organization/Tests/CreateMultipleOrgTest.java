package vtiger.Organization.Tests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;
import vtiger.ObjectRepository.CreateNewOrganizationsPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OganizationPage;
import vtiger.ObjectRepository.OrganizationInfoPage;
@Listeners(vtiger.GenericUtilities.ListenersImplementation.class)
public class CreateMultipleOrgTest {
	
	ExcelFileUtility eUtil = new ExcelFileUtility();
	JavaUtility jUtil = new JavaUtility();
	//@Test
	
	@Test(dataProvider ="OrgWithIndustry")
	
	public void createOrgTest(String ORG,String INDUSTRY) throws IOException{
		
		//step 1: Create Object of Generic utilities
		
		PropertyFileUtility pUtil = new PropertyFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		
		
		// step 2: Read all the required Data
		String URL = pUtil.readDataFromPropertyFile("url");
		//String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		String ORGNAME = ORG+jUtil.getRandomNumber();
		ChromeOptions CO= new ChromeOptions();
		CO.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(CO);
		//WebDriver driver = new ChromeDriver();
		//WebDriver driver = new FirefoxDriver();
		/*WebDriver driver = null;
		
		//Step 3: Launch the Browser - RUNTIME POLYMORPHISM
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("invalid browser name");
		}*/
		
		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(URL);
		
		// Step 4: Login to App
				LoginPage lp = new LoginPage(driver);
				lp.loginToApp(USERNAME, PASSWORD);

				// Step 5: Navigate to Organizations link
				HomePage hp = new HomePage(driver);
				hp.clickOnOrganizationLink();

				// Step 6: Click on Create Organization Look up Image
				OganizationPage op = new OganizationPage(driver);
				op.ClickOnCreateOrgLookUpImg();

				// Step 7: Create organization with mandatory Fields
				CreateNewOrganizationsPage cnop = new CreateNewOrganizationsPage(driver);
				cnop.CreateNewOrganization(ORGNAME,INDUSTRY);

				// Step 8: Validate for Organization
				OrganizationInfoPage oip = new OrganizationInfoPage(driver);
				String OrgHeader = oip.getOrganizationHeader();
				/*if (OrgHeader.contains(ORGNAME)) {
					System.out.println(OrgHeader + " --- Organization Created ---");
				} else {
					System.out.println(" ----Organization creation Failed ----");
				}*/
				Assert.assertTrue(OrgHeader.contains(ORGNAME));
				
				//Step 10: Logout of app
				WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				wUtil.mouseHoverAction(driver, ele);
				driver.findElement(By.linkText("Sign Out")).click();
				hp.logoutOfApp(driver);
				System.out.println("Sign out successful");
					
		
	}
	@DataProvider(name = "OrgWithIndustry")
	public Object[][] getData() throws EncryptedDocumentException,IOException{
		Object[][] data= eUtil.readDatafromExcelToDataProvider("dataProviderOrg");
		return data;
	}
}


