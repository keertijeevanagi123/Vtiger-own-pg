package vtiger.practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPractice {

	@Test
	
	public void Prcatice()
	{
		System.out.println("step 1");
		System.out.println("step 2");
		Assert.assertEquals(false, true);
		System.out.println("step 3");
		System.out.println("step 4");
		
	}
	
	@Test
	
	public void Practice1() {
		SoftAssert sa = new SoftAssert();
		

		System.out.println("step 1-practice");
		sa.assertEquals("A", "C");// PASS
		System.out.println("step 2- practice");
		sa.assertEquals("A", "W");// PASS
		System.out.println("step 3 - practice");
		sa.assertTrue(false);//fail
		System.out.println("step 4- practice");
		sa.assertEquals("A", "b");//pass
		
		//failed
		sa.assertAll(); //failures will be logged
		
		
		
	}
	
	
}
