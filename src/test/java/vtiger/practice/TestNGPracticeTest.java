package vtiger.practice;

import org.testng.annotations.Test;

public class TestNGPracticeTest {
	
	@Test(invocationCount = -3,priority = 0)
	
	public void CreateUserTest()
	{
		System.out.println("User Created");
		
	}
	@Test
	
public void ModifyUserTest()
{
		System.out.println("user modified");
	}
	@Test
	public void deleteUserTest()
	{
		System.out.println("user deleted");
		
	}
	
	
}
