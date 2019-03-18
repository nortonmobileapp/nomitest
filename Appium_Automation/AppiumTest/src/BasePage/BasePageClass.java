package BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;


public abstract class BasePageClass 
{
	public WebDriver driver;
	private int waitForElementPresentMax = 30;
	
	public BasePageClass(WebDriver Driver)
	{
		driver = Driver;
	}
	
	public void Click(By element)
	{		
		driver.findElement(element).click();
	}
	
	public Boolean Type(By element, String Text) throws InterruptedException
	{
		waitForElementPresent(element);
		if(IsElementPresent(element)) 
		{
			driver.findElement(element).clear();
			driver.findElement(element).sendKeys(Text);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public String getStringName(By element) throws InterruptedException
	{
		waitForElementPresent(element);
		if(IsElementPresent(element)) 
		{
			return driver.findElement(element).getText();
		}
		else
		{
			return "No Such Element Found";
		}
	}
	
	
	public void waitForElementPresent(By by) throws InterruptedException
	{
		for (int second = 0; ; second++)
		{
			if (second >= waitForElementPresentMax);

			try
			{
				if (IsElementPresent(by)) break;
			}
			catch (Exception e)

			{ }

			Thread.sleep(1000);
		}
	}
	
	
	public Boolean IsElementPresent(By by)
	{
		try
		{
			driver.findElement(by);
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}
	
	public Boolean IsElementDisplayed(By by)
	{
		return driver.findElement(by).isDisplayed();
	}
	
}
