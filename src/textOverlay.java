import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import pageObjects.displaySettings;
import pageObjects.galleryElements;
import pageObjects.mainScreen;

public class textOverlay extends base{
	@Test
	public void textOverlay() throws MalformedURLException, InterruptedException {
		AndroidDriver<AndroidElement> driver=Capabilities();
		//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		displaySettings d=new displaySettings(driver);
		mainScreen m=new mainScreen(driver);
		galleryElements g=new galleryElements(driver);
		
		m.rightQuickAccess.click();
		m.textOverlayButton.click();
		m.textOverlayBox.sendKeys("Test12345");
		m.textOverlayCheck.click();
		
		try
		{	
			m.textOverlayEntry.isDisplayed();			
			System.out.println("Entered text is on screen");  
		}
		catch (NoSuchElementException e)
		{
			System.out.println(m.textOverlayEntry + "not on screen");
		}
		
		TouchAction t = new TouchAction(driver);
		WebElement first = m.textOverlayEntry;
		WebElement second = m.dateTime;
		
		t.longPress(longPressOptions().withElement(element(m.textOverlayEntry)).withDuration(ofSeconds(2))).moveTo(PointOption.point(700, 400)).release().perform();			
			
			m.textOverlayEntry.click();
			m.textOverlayDelete.click();
			
}
	
}