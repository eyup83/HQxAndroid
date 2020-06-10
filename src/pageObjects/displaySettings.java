package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class displaySettings {
	//1-call the driver object from testcase to pageobject file
	//Concatenate driver
	public displaySettings(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this); //initialize all the elements listed below with the driver on this page
	}

	
	
	@AndroidFindBy(xpath="//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.ImageView[1]")
	public WebElement menuButton;
	
	@AndroidFindBy(xpath="//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/androidx.recyclerview.widget.RecyclerView[1]/android.widget.LinearLayout[1]/android.widget.Spinner[1]/android.widget.TextView[1]")
	public WebElement overlaysButton;
	
	@AndroidFindBy(uiAutomator="text(\"Preview only\")")	
	public WebElement previewOnlyButton;
	
	@AndroidFindBy(uiAutomator="text(\"Off\")")	
	public WebElement overlayOffButton;
	
	@AndroidFindBy(uiAutomator="text(\"Preview and record\")")	
	public WebElement previewAndRecordButton;

	
	

}
