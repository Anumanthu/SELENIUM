package locators;


import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionExamples {
	
	@Test
	
	public void assert1()
	{
		System.out.println("Test Started test1");
		Assert.assertEquals(12, 13);
		
		System.out.println("Test completed test1");
		
		
	}
	
	@Test
	public void assert2()
	{
		//Assert.assertEquals(12, 13);
		System.out.println("Test Started test2");

		Assert.assertEquals(12,12,"Integeres are not matches");
		System.out.println("Test completed test2");
	}
	
	@Test
	public void assert3()
	{
		//Assert.assertEquals(12, 13);
		
		
		System.out.println("Test Started test3");
		Assert.assertEquals("abcde","abcd","Strings are not matches");
	
		System.out.println("Test completed test3");
	}
	
	@Test
	public void assert4()
	{
		System.out.println("Test Started test4");
		Assert.assertTrue(true);
		//Assert.assertTrue(false,"It is expecting boolean value true but u are passing false");
		Assert.assertFalse(true,"It is expecting boolean value false but u are passing true");
		System.out.println("Test completed test4");	
	}

}
