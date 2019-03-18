package BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestPage extends BasePageClass 
{

	public TestPage(WebDriver Driver) {
		super(Driver);
		// TODO Auto-generated constructor stub
	}
	
	public static By username = By.name("email");
	public static By password = By.name("pass");
	public static By submitButton = By.id("u_0_5");
	
	public static By MyNorton_LandingPage = By.className("a__primary__button");
	public static By NSL_Username = By.id("loginUsername");
	public static By NSL_Password = By.id("loginPassword");
	public static By NSL_Signin_Btn = By.id("signin_button");
	public static By Dashboard_Later = By.className("a__link");
	public static By Dashboard_DownloadButton = By.xpath("//button[@class='a__button a__primary__button is--medium']");
	
	//public static By Calc_TermsandCond = By.id("android:id/button1");
	public static By Calc_TermsandCond = By.xpath("//*[@resource-id='android:id/button1']");
	//public static By Calc_clear = By.id("com.miui.calculator:id/btn_c_s");
	public static By Calc_clear = By.xpath("//*[@resource-id='com.miui.calculator:id/btn_c_s']");
	//public static By Calc_Btn1 = By.id("com.miui.calculator:id/btn_1_s");
	public static By Calc_Btn1 = By.xpath("//*[@resource-id='com.miui.calculator:id/btn_1_s']");
	//public static By Calc_Btn2 = By.id("com.miui.calculator:id/btn_2_s");
	public static By Calc_Btn2 = By.xpath("//*[@resource-id='com.miui.calculator:id/btn_2_s']");
	//public static By Calc_Btn3 = By.id("com.miui.calculator:id/btn_3_s");
	public static By Calc_Btn3 = By.xpath("//*[@resource-id='com.miui.calculator:id/btn_3_s']");
	//public static By Calc_Btn4 = By.id("com.miui.calculator:id/btn_4_s");
	public static By Calc_Btn4 = By.xpath("//*[@resource-id='com.miui.calculator:id/btn_4_s']");
	
	public static By Sample_Text = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView");
	
	
	public void Calc_Activity_Check() throws InterruptedException
	{
		Click(Calc_TermsandCond);
		//Click(Calc_clear);
		//Click(Calc_Btn1);
	}
	
	public void HelloWorld_Check() throws InterruptedException
	{
		Assert.assertEquals(getStringName(Sample_Text), "Hello World");
	}
	
	
	public void Login_Pass() throws InterruptedException
	{
		Type(username, "sathishwaran.selvaraj@gmail.com");
		Type(password, "Kar@1428");
		Click(submitButton);
		Assert.assertFalse(IsElementPresent(submitButton));
	}
	
	public void Login_Fails() throws InterruptedException
	{
		Type(username, "sathishwaran.selvaraj@gmail.com");
		Type(password, "bodyspary");
		Click(submitButton);
		Assert.assertFalse(IsElementPresent(submitButton));
	}
	
	public void PortalLogin_Success() throws InterruptedException
	{
		waitForElementPresent(MyNorton_LandingPage);
		Click(MyNorton_LandingPage);
		Type(NSL_Username, "sathish@prod.com");
		Type(NSL_Password, "222222");
		Click(NSL_Signin_Btn);
		waitForElementPresent(Dashboard_Later);
		Click(Dashboard_Later);
	}
	
	public void PortalLogin_Fail() throws InterruptedException
	{
		waitForElementPresent(MyNorton_LandingPage);
		Click(MyNorton_LandingPage);
		Type(NSL_Username, "sathish@prod.com");
		Type(NSL_Password, "222222");
		Click(NSL_Signin_Btn);
		waitForElementPresent(Dashboard_Later);
		Click(Dashboard_Later);
		//waitForElementPresent(Dashboard_DownloadButton);
		Assert.assertFalse(IsElementDisplayed(Dashboard_DownloadButton));
	}
}
	