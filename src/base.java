import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class base {

	public static AndroidDriver<AndroidElement> Capabilities() throws MalformedURLException {
		// TODO Auto-generated method stub

		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "S8");
	//	cap.setCapability(MobileCapabilityType.APP, "com.seescan.hqxlivestream");
	//	cap.setCapability("deviceName","S8");
		cap.setCapability("udid", "98897a474a394c5457");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "8.0.0");
		cap.setCapability("appPackage", "com.seescan.hqxlivestream");
		cap.setCapability("appActivity", "com.seescan.hqxlivestream.FullscreenActivity");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2"); 
	    cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60000);

		cap.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS,true); 
		AndroidDriver<AndroidElement> driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		return driver;
	}

}
