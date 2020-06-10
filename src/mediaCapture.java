import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.displaySettings;
import pageObjects.galleryElements;
import pageObjects.mainScreen;

public class mediaCapture extends base{
	@Test
	public void mediaCapture() throws MalformedURLException, InterruptedException {
		AndroidDriver<AndroidElement> driver=Capabilities();
		//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
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

}
