package testcases;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Forekslogin extends BaseTest {
    String url = "http://webcli-test.foreks.com.s3-website.eu-central-1.amazonaws.com/foreks";
    String username = "otomasyonduzey1plus";
    String password = "123456";
    String newpassword = "654321";

    @Test(priority = 1)
    public void loginurl() throws InterruptedException, IOException {

        setUp(url);
    }

    @Test(priority = 2)
    public void loginusername() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@frks-id='loginUserName']")));
        driver.findElement(By.xpath("//*[@frks-id='loginUserName']")).sendKeys(username);
    }

    @Test(priority = 3)
    public void loginpassword()
    {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@frks-id='loginPassword']")));
        driver.findElement(By.xpath("//*[@frks-id='loginPassword']")).sendKeys(password);
    }

    @Test(priority = 4)
    public void loginbutton() throws InterruptedException {
        driver.findElement(By.xpath("//*[@frks-id='home-login-btn']")).click();
        Thread.sleep(2000);
    }

    @Test(priority = 5)
    public void checktitle() {
        Assert.assertEquals(driver.getTitle(), "Foreks Trader");
       // ServiceRequests.getSnapshotData();
    }

    @Test(priority = 6)
    public void acceptpopup() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("//button[contains(@class,'ok')]"));
        JavascriptExecutor ex = (JavascriptExecutor) driver;
        ex.executeScript("arguments[0].click()", element);
    }
    @Test(priority = 7)
    public void openmenu() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu-profile-toggle-button")));
        driver.findElement(By.id("menu-profile-toggle-button")).click();
    }

    @Test(priority = 8)
    public void checkusername() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@frks-id='menu-username-lbl']")));
        String kullanici = driver.findElement(By.xpath("//*[@frks-id='menu-username-lbl']")).getText();
        Assert.assertEquals(kullanici, "otomasyonduzey1plus");
    }

    @Test(priority = 9)
    public void quit() {
        System.out.println("Login Foreks başarılı şekilde gerçekleşti");
        driver.quit();
    }
}
