package testcases;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class QnbLogin extends BaseTest {
    String url = "http://webcli-test.foreks.com.s3-website.eu-central-1.amazonaws.com/qnb/#!/login";
    String username = "108331";
    String password = "112233";

    @Test(priority = 1)
    public void loginurl() throws MalformedURLException, InterruptedException {
        setUp(url);
    }
    @Test(priority = 2)
    public void login() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//input[@frks-id='brokerLoginText']"))));
        driver.findElement(By.xpath("//input[@frks-id='brokerLoginText']")).sendKeys(username);
        wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//input[contains(@frks-id,'brokerUserPassButton')]"))));
        driver.findElement(By.xpath("//input[contains(@frks-id,'brokerUserPassButton')]")).sendKeys(password);
    }
    @Test(priority = 3)
    public void loginbutton() throws InterruptedException {
        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//span[contains(@frks-id,'home-login-btn')]"))));
        driver.findElement(By.xpath("//span[contains(@frks-id,'home-login-btn')]")).click();

    }
    @Test(priority = 4)
    public void acceptpopup() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement element = driver.findElement(By.xpath("//button[contains(@class,'ok')]"));
        JavascriptExecutor ex = (JavascriptExecutor) driver;
        ex.executeScript("arguments[0].click()", element);
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'ok')]")));
        driver.findElement(By.xpath("//button[contains(@class,'ok')]")).click();
    }
    @Test(priority = 5)
    public void openmenu() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//span[contains(@id,'menu-profile-toggle-button')]"))));
        driver.findElement(By.xpath("//span[contains(@id,'menu-profile-toggle-button')]")).click();

    }

    @Test(priority = 6)
    public void checkusername() throws MalformedURLException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable((By.xpath("(//strong[contains(@class,'ng-binding')])[1]"))));
        String usernamekontrol = driver.findElement(By.xpath("(//strong[contains(@class,'ng-binding')])[1]")).getText();
        System.out.println(usernamekontrol);
    }

    @Test(priority = 7)
    public void quit() {
        System.out.println("Login Qnb Bireysel Login başarılı şekilde gerçekleşti");
        driver.quit();

    }

}
