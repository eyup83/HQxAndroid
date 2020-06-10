import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.touch.offset.PointOption;
import pageObjects.displaySettings;
import pageObjects.galleryElements;
import pageObjects.mainScreen;

public class basics extends base{

//	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
@Test(priority=2)
public void overlayTest() throws MalformedURLException, InterruptedException
{
		AndroidDriver<AndroidElement> driver=Capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		displaySettings d=new displaySettings(driver);
		mainScreen m=new mainScreen(driver);
			
		try {
			m.dateTime.isDisplayed();
			System.out.println("Overlays are displayed");
			m.leftQuickAccess.click();
			d.menuButton.click();
			d.overlaysButton.click();			
			d.overlayOffButton.click();			
			driver.navigate().back();
			m.dateTime.isDisplayed();
		}
		catch(NoSuchElementException e) {
		System.out.println("Overlays are turned off; not displayed");
		}
		}
		
@Test(priority=1)
public void mediaCapture() throws MalformedURLException, InterruptedException {
	AndroidDriver<AndroidElement> driver=Capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		displaySettings d=new displaySettings(driver);
		mainScreen m=new mainScreen(driver);
		galleryElements g=new galleryElements(driver);
		
		m.recordButton.click();
		m.createNewJob.click();
		Thread.sleep(8000);
		m.stopRecording.click();
		Thread.sleep(3000);
		m.photoButton.click();
		Thread.sleep(5000);
		m.stopRecording.click();
		Thread.sleep(3000);
		m.PhotoTalkButton.click();
		Thread.sleep(6000);
		m.stopRecording.click();
		System.out.println("Video, photo and PhotoTalk are recorded. Checking gallery...");
		m.leftQuickAccess.click();
		m.galleryButton.click();
		
		WebElement[] elements = {g.photoGalleryView, g.ptGalleryView, g.videoGalleryView};
		
		for (WebElement option : elements) {
		try {	
			if(option.isDisplayed()){
			    System.out.println(option + "saved in the app gallery");  
			}
			else {	
				
				System.out.println("checking missing media");
			}
		} catch (NoSuchElementException e) {
			System.out.println(option + "is missing");
		}
		}
}

@Test(priority=3)
public void textOverlay() throws MalformedURLException, InterruptedException {
	AndroidDriver<AndroidElement> driver=Capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
@Test(priority=4)
public void tiltSense() throws MalformedURLException, InterruptedException {
	AndroidDriver<AndroidElement> driver=Capabilities();
	//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		displaySettings d=new displaySettings(driver);
		mainScreen m=new mainScreen(driver);
		galleryElements g=new galleryElements(driver);
		
		
		Thread.sleep(5000);
		m.leftQuickAccess.click();
		d.menuButton.click();
		driver.navigate().back();
		Thread.sleep(10000);
		
		try{
		m.tiltSenseIcon.isDisplayed();
//		m.leftQuickAccess.click();
		d.menuButton.click();
		m.tiltSenseButton.click();
		driver.navigate().back();
		m.tiltSenseIcon.isDisplayed();
		}
			catch(StaleElementReferenceException e) {
					System.out.println("Tiltsense icon turned off; not displayed");
			}
		
		
}
	}


