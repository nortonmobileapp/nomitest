package BaseTest;

import java.net.MalformedURLException;
import java.net.URL;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseTestClass
{

public WebDriver driver;

	@BeforeClass
	public void base_init()
	{
		try 
		{
			DesiredCapabilities capabilities=DesiredCapabilities.android();
			capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,BrowserType.CHROME);
			capabilities.setCapability(MobileCapabilityType.PLATFORM,Platform.ANDROID);
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"53095787d040");
			capabilities.setCapability(MobileCapabilityType.VERSION,"7.1.2");
			capabilities.setCapability("appActivity","com.miui.calculator.cal.CalculatorActivity");
			URL url= new URL("http://127.0.0.1:4723/wd/hub");
			driver = new RemoteWebDriver(url, capabilities);

			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public WebDriver openActivity(String packageName, String ActivityName) throws MalformedURLException
	{
		if(driver != null)
		{
			driver.quit();
		}
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("BROWSER_NAME", "Android");
		capabilities.setCapability("VERSION", "4.4.2");
		capabilities.setCapability("deviceName","53095787d040");
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("appPackage", packageName);
		capabilities.setCapability("appActivity",ActivityName);
		URL url= new URL("http://127.0.0.1:4723/wd/hub");
		return driver = new RemoteWebDriver(url, capabilities);
		
	}



	@AfterClass
	public void end_init()
	{
		driver.quit();
	}

}