package vtiger.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class scenario1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/index.php?action=index&module=Home");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Contacts")).click();
		
		WebElement create=driver.findElement(By.xpath("//img[contains(@title,'Create Contact...')]"));
		Actions a=new Actions(driver);
		a.moveToElement(create).perform();
		//Thread.sleep(3000);
		create.click();
		
		driver.findElement(By.name("lastname")).sendKeys("jeevanagi");
		driver.findElement(By.name("button")).click();
		WebElement ele=driver.findElement(By.xpath("//img[contains(@style,'padding: 0px;padding-left:5p')][1]"));
	
		Actions b=new Actions(driver);
		b.moveToElement(ele).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		Thread.sleep(3000);
		driver.close();
		

		
		
		
		
	}

}
