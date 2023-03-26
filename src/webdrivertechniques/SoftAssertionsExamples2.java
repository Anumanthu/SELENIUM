package src.webdrivertechniques;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertionsExamples2 {

    SoftAssert sa = new SoftAssert();

    @Test(priority = 1)
    public void testSoft() {

//	System.out.println("Test1 started");
//	sa.assertTrue(false,"expected true");
//	sa.assertEquals(12,12,"Results are matching");
//	sa.assertEquals("abcd","abcde","Strings are not matching");
//	sa.assertEquals(12,14);
//	sa.assertTrue(false, "not matching");
//	System.out.println("Test1 completed");
    }

    @Test(priority = 1)
    public void testSoft1() {

        System.out.println("Test1 started");
        sa.assertTrue(false, "expected true");
        sa.assertEquals(12, 12, "Results are matching");
        sa.assertEquals("abcd", "abcde", "Strings are not matching");
        sa.assertEquals(12, 14);
        sa.assertTrue(false, "not matching");
        System.out.println("Test1 completed");
        sa.assertAll();

        SoftAssert sa1 = new SoftAssert();
        System.out.println("Test1 started");
        sa1.assertAll();
        sa1.assertTrue(false, "expected true");
        sa1.assertEquals(12, 12, "Results are matching");
        sa1.assertEquals("abcd", "abcde", "Strings are not matching");
        sa1.assertEquals(12, 14);
        sa1.assertTrue(false, "not matching");
        System.out.println("Test1 completed");
        sa1.assertAll();

    }

    @Test(priority = 1)
    public void testSoft2() {

//	System.out.println("Test1 started");
//	sa.assertTrue(false,"expected true");
//	sa.assertEquals(12,12,"Results are matching");
//	sa.assertEquals("abcd","abcde","Strings are not matching");
//	sa.assertEquals(12,14);
//	sa.assertTrue(false, "not matching");
//	System.out.println("Test1 completed");
//	sa.assertAll();
    }

    @Test(priority = 1)
    public void testSoft3() {

//	sa.assertAll();
    }

    @Test(priority = 1)
    public void testHard() {
        System.out.println("Test2 started");
//	Assert.assertEquals(12,12);
//	Assert.assertEquals(12,13);
//	Assert.assertEquals(14,13);
//	System.out.println("Test3 completed");
    }

}
