package vtiger.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class scenario5 {

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
//Click on Create contact look up image
WebElement mouseover = driver.findElement(By.xpath("//img[contains(@alt,'Create Contact...')]"));
Actions a = new Actions(driver);
a.moveToElement(mouseover).perform();
Thread.sleep(3000);
mouseover.click();
driver.findElement(By.name("lastname")).sendKeys("ghi");
driver.findElement(By.name("button")).click();
driver.findElement(By.linkText("Organizations")).click();
//organization look up image
WebElement create = driver.findElement(By.xpath("//img[contains(@alt,'Create Organization...')]"));
Actions b = new Actions(driver);
b.moveToElement(create).perform();
create.click();
driver.findElement(By.name("accountname")).sendKeys("efg");
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
