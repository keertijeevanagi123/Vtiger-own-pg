package vtiger.Organization.Tests;

import java.io.IOException;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;



import vtiger.GenericUtilities.BaseClass1;
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
public class CreateOrganizationTest extends BaseClass1 {
	
@Test
	
public  void createOrgTest() throws IOException {
		
	
	String ORGNAME = eUtil.readDataFromExcel("organization", 1, 2)+jUtil.getRandomNumber();
	/*ChromeOptions CO= new ChromeOptions();
	CO.addArguments("--remote-allow-origins=*");
	WebDriver driver = new ChromeDriver(CO);

	wUtil.maximizeWindow(driver);
	wUtil.waitForPageLoad(driver);
	driver.get(URL);
	String USERNAME = pUtil.readDataFromPropertyFile("username");
    String PASSWORD = pUtil.readDataFromPropertyFile("password");*/
	
	//LoginPage lp = new LoginPage(driver);
	//lp.loginToApp(USERNAME, PASSWORD);
	
	//Step 5: Navigate to Organizations link
     HomePage hp = new HomePage(driver);
	hp.clickOnOrganizationLink();
	
	//Step 6: Click on Create Organization Look up Image
	OganizationPage op = new OganizationPage(driver);
	op.ClickOnCreateOrgLookUpImg();
	
	//Step 7: Create organization with mandatory Fields
  CreateNewOrganizationsPage cnop = new CreateNewOrganizationsPage(driver);
	cnop.CreateNewOrganization(ORGNAME);

	
	
			//Step 8: Validate for Organization
	OrganizationInfoPage oip = new OrganizationInfoPage(driver);
	String OrgHeader = oip.getOrganizationHeader();
   if (OrgHeader.contains(ORGNAME)) {
		System.out.println(OrgHeader + " --- Organization Created ---");
	} else {
		System.out.println(" ----Organization creation Failed ----");
	}
			
			
	
	
}

}
