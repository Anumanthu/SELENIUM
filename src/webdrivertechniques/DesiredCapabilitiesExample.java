package webdrivertechniques;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.gargoylesoftware.htmlunit.javascript.configuration.BrowserName;

public class DesiredCapabilitiesExample {

	public static void main(String[] args) throws InterruptedException {

		DesiredCapabilities ch = new DesiredCapabilities();
		// ch.acceptInsecureCerts();
		//ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		//ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

		// ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		// ch.setBrowserName(BrowserName.CHROME);
		// ch.setPlatform(Platform.WINDOWS);

		ChromeOptions c = new ChromeOptions();

		//c.merge(ch);
		
		ch.merge((Capabilities) c);
		

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ANUMANTHU\\Desktop\\Selenium Learning\\chromedriver.exe");

		WebDriver driver = new ChromeDriver(c);

		// FirefoxOptions c1 = new FirefoxOptions();
		// c1.merge(ch);

		// WebDriver driver1=new FirefoxDriver(c1);

		driver.get("Put insecure websites");

		driver.manage().window().maximize();

		// driver.manage().deleteAllCookies();

		driver.manage().deleteCookieNamed("cookiename");
		
		Thread.sleep(2000);

	}

}
