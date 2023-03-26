package src.webdrivertechniques;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertionsExamples {

    @Test(priority = 1)
    public void testSoft() {

        SoftAssert sa = new SoftAssert();

        System.out.println("Test1 started");
        sa.assertEquals(12, 13);
        sa.assertEquals("abcd", "abcde", "Strings are not matching");
        sa.assertEquals(12, 14);
        System.out.println("Test1 completed");
        sa.assertAll();
    }

    @Test(priority = 2)
    public void testHard() {


        System.out.println("Test2 started");
        Assert.assertEquals(12, 12);
        Assert.assertEquals(12, 13);
        Assert.assertEquals(14, 13);
        System.out.println("Test3 completed");
    }

}
