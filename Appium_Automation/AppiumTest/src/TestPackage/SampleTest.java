package TestPackage;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import BasePage.TestPage;
import BaseTest.BaseTestClass;



public class SampleTest extends BaseTestClass
{
	
	TestPage PageElement;
	
	@BeforeMethod
	public void Setup()
	{
		PageElement = new TestPage(driver);
		driver.get("https://my.norton.com/");
	}
	
	public void init(WebDriver driver)
	{
		PageElement = new TestPage(driver);
	}
	
/*	@Test
	public void LoginToPortal() throws InterruptedException
	{
		PageElement.Login_Pass();
	}
	
	@Test
	public void LoginToPortal_Fails() throws InterruptedException
	{
		PageElement.Login_Fails();
	}*/
	
	//@Test
	public void CalculatorActivity_Success() throws InterruptedException, MalformedURLException
	{
		WebDriver driver = openActivity("com.miui.calculator", "com.miui.calculator.cal.CalculatorActivity");
		init(driver);
		PageElement.Calc_Activity_Check();
	}
	
	@Test
	public void HelloWorld_Success() throws InterruptedException, MalformedURLException
	{
		WebDriver driver = openActivity("com.example.vishwanath_rajakumar.nomi_test", "com.example.vishwanath_rajakumar.nomi_test.MainActivity");
		init(driver);
		PageElement.HelloWorld_Check();
		base_init();
	}
	
	//@Test
	public void NGPLoginToPortal_Success() throws InterruptedException, MalformedURLException
	{
		PageElement.PortalLogin_Success();
	}
	
	//@Test
	public void NGPLoginToPortal_Failure() throws InterruptedException
	{
		PageElement.PortalLogin_Fail();
	}
	
	@AfterMethod
	public void End()
	{
		driver.get("https://my.norton.com//Identity/Account/LogOff");
	}
}
