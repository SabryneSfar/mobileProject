package appiumTests;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import static appiumTests.Config.region;

public class AppiumSauceLabs {
    public AndroidDriver driver;
    private static final String app ="Android-MyDemoApp.apk";
    URL url; //added
    @BeforeMethod
    public void setUp(Method method) throws Exception {
        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:app", "storage:filename=Android-MyDemoApp.apk");  // The filename of the mobile app
        caps.setCapability("appium:deviceName", "Google Pixel 3 XL GoogleAPI Emulator");
        caps.setCapability("appium:deviceOrientation", "portrait");
        caps.setCapability("appium:platformVersion", "11.0");
        caps.setCapability("appium:automationName", "UiAutomator2");
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("appiumVersion", "2.0.0");
        sauceOptions.setCapability("username", "oauth-sabrynesfar-1a9d5");
        sauceOptions.setCapability("accessKey", "e19aa805-cbe0-4f75-9d4c-c3a86c336a48");
        sauceOptions.setCapability("name", "VerifyCartIsNotEmpty");
        caps.setCapability("sauce:options", sauceOptions);

        URL url = new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub");

        driver = new AndroidDriver(url,caps);

    }
    @Test
    public void addToCart() throws MalformedURLException, InterruptedException {

        By backPack = By.xpath("//*[@content-desc=\"store item\"][1]");
        Thread.sleep(500);
        driver.findElement(backPack).click();
        Thread.sleep(500);
        driver.findElement(AppiumBy.accessibilityId("Add To Cart button")).click();
        Thread.sleep(500);
        driver.findElement(AppiumBy.accessibilityId("cart badge")).click();
        Thread.sleep(500);
        String itemInCart =driver.findElement(AppiumBy.accessibilityId("total number")).getText();
        WebElement checkOutButton = driver.findElement(AppiumBy.accessibilityId("Proceed To Checkout button"));
        Assert.assertEquals(itemInCart,"1 item");



    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
