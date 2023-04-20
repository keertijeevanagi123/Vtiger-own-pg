package vtiger.Contact.Tests;

import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;
import vtiger.ObjectRepository.ContactsInfoPage;
import vtiger.ObjectRepository.ContactsPage;

import vtiger.ObjectRepository.CreateNewContactsPage;

import vtiger.ObjectRepository.CreateNewOrganizationsPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OganizationPage;
import vtiger.ObjectRepository.OrganizationInfoPage;

@Listeners(vtiger.GenericUtilities.ListenersImplementation.class)
public class CreateContactWithOrganizationTest {
	//@Test(groups={"SmokeSuite","RegressionSuite"})
@Test(alwaysRun = true)
	public void createContactWithOrgTest() throws IOException {

		// Step 1: Create Object of Utilities
		ExcelFileUtility eUtil = new ExcelFileUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		JavaUtility jUtil = new JavaUtility();
		WebDriverUtility wUtil = new WebDriverUtility();

		// Step 2: Read all the necessary Data
		String URL = pUtil.readDataFromPropertyFile("url");
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");

		String LASTNAME = eUtil.readDataFromExcel("contacts", 4, 2);
		String ORGNAME = eUtil.readDataFromExcel("contacts", 4, 3)+jUtil.getRandomNumber();
		ChromeOptions CO= new ChromeOptions();
		CO.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(CO);
		/*WebDriver driver = null;

		// Step 3: Launch the Browser - RUNTIME POLYMORPHISM
		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
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
		cnop.CreateNewOrganization(ORGNAME);
         //Assert.fail();
		// Step 8: Validate for Organization
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String OrgHeader = oip.getOrganizationHeader();
		/*if (OrgHeader.contains(ORGNAME)) {
			System.out.println(OrgHeader + " --- Organization Created ---");
		} else {
			System.out.println(" ----Organization creation Failed ----");
		}*/ //assert is used for if else
		Assert.assertTrue(OrgHeader.contains(ORGNAME));

		// Step 9: Navigate Contacts Link
		hp.clickOnContactsLink();

		// Step 10: Click on create Contact Look Up Image
		ContactsPage cp = new ContactsPage(driver);
		cp.ClickOnCreateContactLookupImg();

		// Step 11: Create contact
		CreateNewContactsPage cncp = new CreateNewContactsPage(driver);
		cncp.CreateNewContact(driver, LASTNAME, ORGNAME);
		wUtil.takeScreenShot(driver, "Screenshot2");

		// Step 12: Validate for Contacts
		ContactsInfoPage cip = new ContactsInfoPage(driver);
		String ContactHeader = cip.getContactHeader();
		/*if (ContactHeader.contains(LASTNAME)) {
			System.out.println(ContactHeader + " --- PASS ---");
		} else {
			System.out.println(" ---- Failed ----");
		}*/
		Assert.assertTrue(ContactHeader.contains(LASTNAME));

		// Step 13: Logout
		hp.logoutOfApp(driver);
		System.out.println("Sign out successful");

		// Step 11: close the browser
		driver.quit();

	}
	@Test
	public void demo()
	{
		System.out.println("This is demo");
	}


	}


