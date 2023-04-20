package vtiger.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class scenario4 {

		public static void main(String[] args) throws InterruptedException {
			//WebDriver driver = new ChromeDriver();
			WebDriver driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get("http://localhost:8888/index.php?action=index&module=Home");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(By.name("user_name")).sendKeys("admin");
			driver.findElement(By.name("user_password")).sendKeys("admin");
			driver.findElement(By.id("submitButton")).click();
			driver.findElement(By.linkText("Organizations")).click();
			WebElement create = driver.findElement(By.xpath("//img[contains(@alt,'Create Organization...')]"));
			Actions a = new Actions(driver);
			a.moveToElement(create).perform();
			create.click();
			driver.findElement(By.name("accountname")).sendKeys("def");
			//Select "Energy" in the industry drop down
			WebElement dropdown = driver.findElement(By.name("industry"));
			Select s= new Select(dropdown);
			Thread.sleep(3000);
			s.selectByIndex(10);
			//Select "Customer" in the Type Drop down 
			WebElement type = driver.findElement(By.name("accounttype"));
			Select b= new Select(type);
			Thread.sleep(3000);
			b.selectByValue("Customer");
			//save
			driver.findElement(By.name("button")).click();
			Thread.sleep(3000);
			WebElement ele=driver.findElement(By.xpath("//img[contains(@style,'padding: 0px;padding-left:5p')][1]"));
			Actions c=new Actions(driver);
			c.moveToElement(ele).perform();
			ele.click();
			driver.findElement(By.linkText("Sign Out")).click();
			Thread.sleep(3000);
			driver.close();
			
			
	}

}
