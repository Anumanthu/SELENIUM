package src.webdrivertechniques;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class FramesExamples {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\akindint\\Desktop\\Selenium Learning\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        // WebDriver driver=new FirefoxDriver();

        driver.get("https://jqueryui.com/droppable/");

        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        Thread.sleep(2000);

        // 1.Css Selector tagname.classname example----- '.' represents class

        // 1.Css Selector tagname#id example---- '#' represents id

        WebElement e = driver.findElement(By.cssSelector("iframe.demo-frame"));

        // Finding how many frames are available
        int count = driver.findElements(By.tagName("iframe")).size();//we can find using tag 'frameset' also

        //int count1 = driver.findElements(By.tagName("frameset")).size();

        System.out.println(count);

        // Css Selector tagname[class='value'] regular formula

        // driver.findElement(By.cssSelector("iframe[class='demo-frame']"));

        // driver.switchTo().frame(e); //passing weblement to as a argument instead of
        // index

        driver.switchTo().frame(0);// only one frame available 0 means 1st frame 1 means 2nd frame like that
        // driver.findElement(By.cssSelector("div#draggable")).click();

        WebElement source = driver.findElement(By.cssSelector("div#draggable"));

        WebElement target = driver.findElement(By.cssSelector("div#droppable"));

        Actions ac = new Actions(driver);

        //	***********VVERY IMP: we can do Drag and drop element in 2 ways as shown below****************

        //ac.dragAndDrop(source, target).build().perform();

        ac.clickAndHold(source).moveToElement(target).release().build().perform();

        driver.switchTo().defaultContent();//it will come to normal window from frame

        //driver.switchTo().parentFrame(); //This will also do the same as above

        //VVV IMP Difference between driver.switchTo().defaultContent() and driver.switchTo().parentFrame()
		
		/*
		Scenario : When there are multiple frames and some of them are nested.

		iframeMain(Main HTML page)
		iframeParent
		iframechild

		Assume you are in ifrmaechild :

		When you do driver.switchTo().parentFrame(); : you will go to iframeParent .
		But when you do driver.switchTo().defaultContent(); : you will go to main HTML of page.
		Note that in this case you will not go to iframeMain .
		
		*/

    }

}
