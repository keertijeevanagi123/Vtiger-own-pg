package vtiger.practice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.LoginPage;

public class POMClassPractice {

	public static void main(String[] args) {
ChromeOptions CO= new ChromeOptions();
CO.addArguments("--remote-allow-origins=*");
WebDriver driver = new ChromeDriver(CO);
//	WebDriverManager.firefoxdriver().setup();
//WebDriver driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888");
		
		LoginPage lp = new LoginPage(driver);
//lp.getUserNameEdt().sendKeys("admin");
//lp.getPasswordEdt().sendKeys("admin");
//lp.getSubmitBtn().click();
		
lp.loginToApp("admin","admin");
		
		
	}

}
