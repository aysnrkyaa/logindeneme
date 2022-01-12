package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static WebDriver driver;
    String appUrl;

    public static void setUp(String url) throws MalformedURLException {
        //driver = new ChromeDriver();
        System.setProperty("webdriver.gecko.driver",
                System.getProperty("user.dir") + "//src//test//resources//executables//geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(25000, TimeUnit.MILLISECONDS);

    }
}
