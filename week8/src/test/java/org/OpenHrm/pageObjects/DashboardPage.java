package org.OpenHrm.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

import static org.OpenHrm.WebDriverManager.*;

public class DashboardPage extends PageObjectTemplate{



    public By dashBoardWidgets = By.xpath("//div[@class='oxd-grid-3 orangehrm-dashboard-grid']/child::div");
    public By widgetName = By.xpath("//div[@class='orangehrm-dashboard-widget-name']/p");

    public By leaveApplicantsButton = By.xpath("//button[@class='oxd-icon-button oxd-icon-button--success orangehrm-report-icon']");
    public By noLeaveApplicantsOnDashboard = By.xpath("//button[@class='oxd-icon-button oxd-icon-button--success orangehrm-report-icon']/following-sibling::p");
    public By leaveApplicants = By.xpath("//div[@class='oxd-table-row oxd-table-row--with-border']");

    public By timeSheetsToApproveButton = By.xpath("//button[@class='oxd-icon-button oxd-icon-button--warn orangehrm-report-icon']");
    public By noTimeSheetsOnDashboard = By.xpath("//button[@class='oxd-icon-button oxd-icon-button--warn orangehrm-report-icon']/following-sibling::p");
    public By timeSheets = By.xpath("//div[@class='oxd-table-row oxd-table-row--with-border']");


    public By selfReviewButton = By.xpath("//button[@class='oxd-icon-button oxd-icon-button--danger orangehrm-report-icon']");
    public By noSelfReviewsOnDashboard = By.xpath("//button[@class='oxd-icon-button oxd-icon-button--danger orangehrm-report-icon']/following-sibling::p");
    public By selfReviews = By.xpath("//div[@class='oxd-table-row oxd-table-row--with-border oxd-table-row--clickable']");


    public By candidateInterviewsButton = By.xpath("//button[@class='oxd-icon-button oxd-icon-button--info orangehrm-report-icon']");
    public By noCandidateInterviewsOnDashboard = By.xpath("//button[@class='oxd-icon-button oxd-icon-button--info orangehrm-report-icon']/following-sibling::p");
    public By candidateInterviews = By.xpath("//div[@class='oxd-table-row oxd-table-row--with-border']");



    public DashboardPage(WebDriver inputDriver){
        super(inputDriver, 15);
    }

    public List<WebElement> findDashboardWidgets(){

        return getElements(dashBoardWidgets, driver);
    }



    public List<String> getWidgetNames(){

        List<String> res = new ArrayList<String>();;

        for(WebElement widget: getElements(widgetName, driver)){
            res.add(widget.getText());
        }

        return res;
    }


    public String getLeaveApplicantsButtonUrl(){
        return getWebElementUrl(leaveApplicantsButton);
    }

    public String getLeaveApplicantsOnDashboardDivUrl(){
        return getWebElementUrl(noLeaveApplicantsOnDashboard);
    }

    public String gotoLeaveApplicants(){
        wait.until(ExpectedConditions.elementToBeClickable(leaveApplicantsButton));
        String res = getElement(noLeaveApplicantsOnDashboard, driver).getText();
        getElement(leaveApplicantsButton, driver).click();
        return res;
    }

    public int countLeaveApplicants(){
        wait.until(ExpectedConditions.presenceOfElementLocated(leaveApplicants));
        int res = getElements(leaveApplicants, driver).size()-1;
        driver.navigate().back();
        return res;
    }


    public String getTimeSheetsToApproveButtonUrl(){
        return getWebElementUrl(timeSheetsToApproveButton);
    }
    public String getTimeSheetsOnDashboardDivUrl(){
        return getWebElementUrl(noTimeSheetsOnDashboard);
    }
    public String gotoTimeSheets(){
        wait.until(ExpectedConditions.elementToBeClickable(timeSheetsToApproveButton));
        String res = getElement(noTimeSheetsOnDashboard, driver).getText();
        getElement(timeSheetsToApproveButton, driver).click();
        return res;
    }

    public int countTimeSheets(){
        wait.until(ExpectedConditions.presenceOfElementLocated(timeSheets));
        int res = getElements(timeSheets, driver).size()-1;
        driver.navigate().back();
        return res;
    }


    public String getSelfReviewsButtonUrl(){
        return getWebElementUrl(selfReviewButton);
    }
    public String getSelfReviewsOnDashboardDivUrl(){
        return getWebElementUrl(noSelfReviewsOnDashboard);
    }
    public String gotoSelfReviews(){
        wait.until(ExpectedConditions.elementToBeClickable(noSelfReviewsOnDashboard));
        String res = getElement(noSelfReviewsOnDashboard, driver).getText();
        getElement(noSelfReviewsOnDashboard, driver).click();
        return res;
    }

    public int countSelfReviews(){
        wait.until(ExpectedConditions.presenceOfElementLocated(selfReviews));
        int res = getElements(selfReviews, driver).size();
        driver.navigate().back();
        return res;
    }


    public String getCandidateInterviewsButtonUrl(){
        return getWebElementUrl(candidateInterviewsButton);
    }
    public String getCandidateInterviewsOnDashboardDivUrl(){
        return getWebElementUrl(noCandidateInterviewsOnDashboard);
    }
    public String gotoCandidateInterviews(){
        wait.until(ExpectedConditions.elementToBeClickable(noCandidateInterviewsOnDashboard));
        String res = getElement(noCandidateInterviewsOnDashboard, driver).getText();
        getElement(noCandidateInterviewsOnDashboard, driver).click();
        return res;
    }

    public int countCandidateInterviews(){
        wait.until(ExpectedConditions.presenceOfElementLocated(candidateInterviews));
        int res = getElements(candidateInterviews, driver).size() - 1;
        driver.navigate().back();
        return res;
    }

    public String getWebElementUrl(By ele){
        wait.until(ExpectedConditions.elementToBeClickable(ele));
        getElement(ele, driver).click();
        String currentUrl = driver.getCurrentUrl();
        driver.navigate().back();
        return currentUrl;
    }
}
