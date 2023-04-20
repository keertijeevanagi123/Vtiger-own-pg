package vtiger.practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class testng2 {
	
	@Test
	
	public void CreateUserTest()
	{
		//Assert.fail();
		System.out.println("User Created");// executed= fail
		
	}
	//@Test(enabled = false)
	@Test
public void ModifyUserTest()
{
		System.out.println("user modified");//should not be executed
	}
	@Test(dependsOnMethods = "CreateUserTest")
	public void deleteUserTest()
	{
		System.out.println("user deleted");
		
	}
	
	
}