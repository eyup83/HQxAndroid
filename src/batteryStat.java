import java.net.MalformedURLException;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.displaySettings;
import pageObjects.galleryElements;
import pageObjects.mainScreen;

public class batteryStat extends base{
	@Test
	public void batteryStat() throws MalformedURLException, InterruptedException {
		AndroidDriver<AndroidElement> driver=Capabilities();
		//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			displaySettings d=new displaySettings(driver);
			mainScreen m=new mainScreen(driver);
			galleryElements g=new galleryElements(driver);
			
			Thread.sleep(5000);
			m.leftQuickAccess.click();
			d.menuButton.click();
			driver.navigate().back();
			Thread.sleep(5000);
			
			System.out.println(driver.findElementByXPath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[2]/android.widget.RelativeLayout[2]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.ImageView[2]").getAttribute("contentDescription"));
			
	}
	
}
