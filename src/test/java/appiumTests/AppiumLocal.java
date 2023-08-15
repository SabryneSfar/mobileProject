package appiumTests;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
public class AppiumLocal extends BaseTest {
    @Test
    public void VerifyCartIsNotEmpty() throws MalformedURLException, InterruptedException {
        //ConfigureAppium();
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
}
