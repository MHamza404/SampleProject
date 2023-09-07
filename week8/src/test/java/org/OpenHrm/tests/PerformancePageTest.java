package org.OpenHrm.tests;

import org.OpenHrm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import org.OpenHrm.pageObjects.*;

import java.io.IOException;

public class PerformancePageTest extends WebDriverManager {

    PerformancePage performancePage;



    @Test(priority = 0)
    public void gotoPerformance(){
        performancePage = new PerformancePage(driver);
        performancePage.gotoPerformancePage();
    }

    @Test(priority = 1)
    public void gotoKPIs() throws IOException {

        String pageTitle = performancePage.gotoKPIs();
        Assert.assertEquals("Key Performance Indicators for Job Title", pageTitle);

    }

    @Test(priority = 2)
    public void gotoAddKPI() {

        String pageTitle = performancePage.gotoAddKPI();
        Assert.assertEquals("Add Key Performance Indicator", pageTitle);
    }

    @Test(priority = 3)
    public void testAddKPICancelButton() throws IOException {

        String pageTitle = performancePage.pressAddKPICancelButton();
        Assert.assertEquals("Key Performance Indicators for Job Title", pageTitle);


    }

    @Test(priority = 4)
    public void addEmptyKPI() {

//        performancePage = new PerformancePage(driver);
        int noErrors = performancePage.pressAddKPISaveButton();
        Assert.assertEquals(2, noErrors);

    }

    @Test(priority = 5)
    public void addKPIDetails() {
//        performancePage = new PerformancePage(driver);
        performancePage.addKPIDetails();

    }

    @Test(priority = 6)
    public void gotoMyReviews() {

        performancePage = new PerformancePage(driver);
        String pageTitle = performancePage.gotoMyReviews();
        Assert.assertEquals("My Reviews", pageTitle);

    }

    @Test(priority = 7)
    public void gotoEmployeeReviews() {

        performancePage = new PerformancePage(driver);
        String pageTitle = performancePage.gotoEmployeeReviews();
        Assert.assertEquals("Employee Reviews", pageTitle);
    }

    @Test(priority = 8)
    public void gotoPerformanceReviews() {

        performancePage = new PerformancePage(driver);
        String pageTitle = performancePage.gotoManagePerformanceReviews();
        Assert.assertEquals("Manage Performance Reviews", pageTitle);
    }

    @Test(priority = 9)
    public void gotoAddPerformanceReview() {

        performancePage = new PerformancePage(driver);
        String pageTitle = performancePage.gotoAddPerformanceReview();
        Assert.assertEquals("Add Review", pageTitle);
    }

    @Test(priority = 10)
    public void testAddPerformanceReviewCancelButton(){

        performancePage = new PerformancePage(driver);
        String pageTitle = performancePage.pressCancelButton();
        Assert.assertEquals("Manage Performance Reviews", pageTitle);
        driver.navigate().back();

    }

    @Test(priority = 11)
    public void addEmptyPerformanceReview(){

        performancePage = new PerformancePage(driver);
        int noErrors = performancePage.pressSaveButton();
        Assert.assertEquals(5, noErrors);

    }

    @Test(priority = 12)
    public void addPerformanceReviewInfo(){

        performancePage = new PerformancePage(driver);
        performancePage.addReviewData();

    }

    @Test(priority = 13)
    public void clickActivateButton(){

        performancePage = new PerformancePage(driver);
        performancePage.pressActivateButton();

    }




}
