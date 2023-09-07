package org.OpenHrm.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageObjectTemplate {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;


    public PageObjectTemplate(WebDriver inputPageDriver, int inputDriverWaitDuration) {
        driver = inputPageDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(inputDriverWaitDuration));
        actions = new Actions(driver);
    }
}
