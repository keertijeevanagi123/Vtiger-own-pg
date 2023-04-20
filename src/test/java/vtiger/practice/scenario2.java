package vtiger.practice;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class scenario2 {

	public static void main(String[] args) throws InterruptedException, IOException {
		//Step 1: Read all the neccessary Data
				/*Read the data from property file*/
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pobj= new Properties();
		pobj.load(fis);
		String BROWSER = pobj.getProperty("browser");
		String URL = pobj.getProperty("url");
		String USERNAME = pobj.getProperty("username");
		String PASSWORD = pobj.getProperty("password");
		
	
		Random r = new Random();
		int value = r.nextInt(1000);
		//read the data from Excel sheet
		FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\testdata.xlsx");
		Workbook wb= WorkbookFactory.create(fise);
		String ORGNAME = wb.getSheet("organization").getRow(1).getCell(2).getStringCellValue()+value;
		wb.close();
		
     /*WebDriver driver = null;
     ChromeOptions CO= new ChromeOptions();
		CO.addArguments("--remote-allow-origins=*");
		//Step 1: Launch the Browser - RUNTIME POLYMORPHISM
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(CO);
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
		ChromeOptions CO= new ChromeOptions();
		CO.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(CO);
		//WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://localhost:8888/index.php?action=index&module=Home");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		driver.findElement(By.name("accountname")).sendKeys("xyz"+value);
		driver.findElement(By.name("button")).click();
		//step 7.validate for organization
		String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(OrgHeader.contains("xyz"))
		{
			System.out.println(OrgHeader+" ---- PASS ----");
		}
		else
		{
			System.out.println(" ---- Failed ----");
		}
		
	
		WebElement ele=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions c=new Actions(driver);
		c.moveToElement(ele).perform();
		
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Sign out successful");
		
		
		
		//Thread.sleep(3000);
		driver.close();
		
	}

}
