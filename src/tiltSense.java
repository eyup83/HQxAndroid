import java.net.MalformedURLException;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.displaySettings;
import pageObjects.galleryElements;
import pageObjects.mainScreen;

public class tiltSense extends base{
	@Test
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
