package src.webdrivertechniques;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class SeleniumGridExample {

    public static void main(String[] args) throws InterruptedException, MalformedURLException {

        /*
         *
         * This is not required for Selenium Grid as we will set in node as part of
         * configuration System.setProperty("webdriver.chrome.driver",
         * "C:\\Users\\ANUMANTHU\\Desktop\\Selenium Learning\\chromedriver.exe");
         */

        /*
         * 1.Download selenium standalone server jar 2.Copy and paste selenium
         * standalone server jar in any path 3.Configure hub using above path in CMD
         * prompt
         *
         *
         *
         * 4.Login to Node Server,copy and paste selenium standalone server jar in any
         * path 5.Make sure Java installed and configured. Check javapath in system
         * variables 6.Make sure Selenium standalone server jar should have same version
         * both in hub and node servers 7.Prepare test cases using desired capabilities
         *
         */

        DesiredCapabilities dc = new DesiredCapabilities();

        /*
         * DesiredCapabilities d=DesiredCapabilities.chrome();//This is specific to
         * Chrome browser d.acceptInsecureCerts();
         *
         * DesiredCapabilities d1=DesiredCapabilities.firefox();//This is specific to
         * Firefox browser d1.acceptInsecureCerts();
         *
         * DesiredCapabilities d3=DesiredCapabilities.internetExplorer();//This is
         * specific to IE browser d3.acceptInsecureCerts();
         *
         * DesiredCapabilities d4=DesiredCapabilities.safari();//This is specific to
         * Safari browser d4.acceptInsecureCerts();
         *
         */

        dc.setBrowserName("Chrome");
        dc.setPlatform(Platform.WINDOWS);
        dc.setVersion("56.7");//chrome version
        // dc.setAcceptInsecureCerts(true);
        //dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

        //dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

        // **********************Below 4 lines are Very
        // Important**********************************************//
        /*
         *
         * ChromeOptions ch=new ChromeOptions(); ch.merge(dc);
         * //WebDriver driver1=new
         * ChromeDriver(dc);//depriciated so we are merging Desired capabilities into
         * Chrome Options WebDriver driver1=new ChromeDriver(ch);//Declare driver in
         * this way If we want to pass desired capabilities to Browser
         * driver1.get("Put insecure websites"); drive1r.manage().window().maximize();
         * //driver1.manage().deleteAllCookies();
         * driver1.manage().deleteCookieNamed("cookiename");
         *
         *
         */

        //Declare RemoteWebDriver as below to run test cases on nodes
        //Remember the RemoteWebDriver for Selenium Grid

        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        driver.get("http://www.google.com/");

        // Write your test cases


    }

}
