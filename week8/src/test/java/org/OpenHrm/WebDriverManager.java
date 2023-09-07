package org.OpenHrm;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class WebDriverManager {


    public WebDriver driver;
    static int ssCounter = 1;

    @BeforeClass
    public void launch(){

        io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");
        driver = new ChromeDriver(options);
//        driver.manage().deleteAllCookies();
//        driver.navigate().refresh();

//        driver = new ChromeDriver();
    }


    @AfterMethod
    public void ssRountine() throws IOException, InterruptedException {
        try {
            takeScreenShot(driver);
        }
        catch (Exception e){
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            ssRountine();
        }

    }





    /* Static Methods */

    public static void takeScreenShot(WebDriver driver) throws IOException {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile , new File("src/test/java/resources/ss/"+String.valueOf(ssCounter)+".png"));
        ssCounter += 1;

    }
    // overloaded method to return a WebElement from a WebDriver object or within a WebElement object using a By
    public static WebElement getElement(By name, WebDriver driver){
        return driver.findElement(name);
    }



    public static WebElement getElement(By name, WebElement element){
        return element.findElement(name);
    }


    // overloaded method to return a list of WebElements from a WebDriver object or within a WebElement object using a By
    public static List<WebElement> getElements(By locator, WebDriver driver){
        return driver.findElements(locator);
    }

    public static List<WebElement> getElements(By locator, WebElement element){
        return element.findElements(locator);
    }






    /* Non-Static Methods */

    public List<WebElement> getElementsByClass(String locator){
        return driver.findElements(By.className(locator));
    }

    public WebElement getElementByXpath(String xpath){
        return driver.findElement(By.xpath(xpath));
    }

    public List<WebElement> getElementsByXpath(String xpath){ return driver.findElements(By.xpath(xpath)); }

    public WebElement getElementById(String id){
        return driver.findElement(By.id(id));
    }

    public List<WebElement> getElementsById(String id){
        return driver.findElements(By.id(id));
    }

    public void navigateDriver(String url){

        driver.navigate().to(url);
    }


    @AfterClass
    public void teardown(){
//        driver.quit();
    }

}
