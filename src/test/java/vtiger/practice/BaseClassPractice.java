package vtiger.practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BaseClassPractice {
	@Test
	public void bsConfig2() {
		System.out.println("test");
	}
	@BeforeSuite
	public void bsConfig() {
		System.out.println("before suite");
	}
	@AfterSuite
	public void asConfig() {
		System.out.println("aftr suite");
	}
	
	
	@BeforeClass
	
	public void bcConfig() {
		System.out.println("bfr class");
	}
	@AfterClass
	public void acConfig() {
		System.out.println("after class");
	}
@BeforeMethod
	
	public void bmConfig() {
		System.out.println("bfr method");
	}
	@AfterMethod
	public void amConfig() {
		System.out.println("after method");
	}
	
	
	
	
	
	
	
	
	
	
}
