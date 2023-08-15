package appiumTests;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
public class BaseTest {

    public AndroidDriver driver;
    @BeforeClass
    public void ConfigureAppium() throws MalformedURLException, InterruptedException {

        UiAutomator2Options options =new UiAutomator2Options();

        options.setDeviceName("Sabryne_Tablet");
        options.setApp("C:\\Users\\sabryne.sfar\\IdeaProjects\\mobileProject\\src\\test\\resources\\Android-MyDemoApp.apk");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        Thread.sleep(10000);




    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
