package org.OpenHrm.tests;

import org.OpenHrm.WebDriverManager;
import org.OpenHrm.pageObjects.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class DashboardTest extends WebDriverManager {

    DashboardPage dashboardPage;
    List<WebElement> dashboardWidgets;


    @Test(priority = 1)
    public void getDashboardWidgets() { // Test to see if correct number of widgets is displayed.

        dashboardPage = new DashboardPage(driver);
        dashboardWidgets = dashboardPage.findDashboardWidgets();
        Assert.assertEquals(dashboardWidgets.size(), 7);
    }

    @Test(priority = 2)
    public void validateWidgetNames() { // Test to see if correct widgets are diplayed.

        List<String> names = dashboardPage.getWidgetNames();

        Assert.assertEquals(names.get(0), "Time at Work");
        Assert.assertEquals(names.get(1), "My Actions");
        Assert.assertEquals(names.get(2), "Quick Launch");
        Assert.assertEquals(names.get(3), "Buzz Latest Posts");
        Assert.assertEquals(names.get(4), "Employees on Leave Today");
        Assert.assertEquals(names.get(5), "Employee Distribution by Sub Unit");
        Assert.assertEquals(names.get(6), "Employee Distribution by Location");
    }

    /* Validate the My Actions Widget of the Dashboard */

    @Test(priority = 3)
    public void validateLeaveApplicants() {

        String res = dashboardPage.gotoLeaveApplicants().split(" ")[0]; // navigate to the leave applicants page and also return the current number of applicants.

        res = res.substring(1, res.length() - 1); // remove brackets and make it and integer for assertions.
        int noApplicantsInDashboard = Integer.parseInt(res);

        int noApplicants = dashboardPage.countLeaveApplicants(); // count number of leave applicants records inside the page.

        Assert.assertEquals(noApplicants, noApplicantsInDashboard); // compare to see if the dashboard is displaying correct information.

    }

    @Test(priority = 4)
    public void validateTimeSheetsButton() {

        dashboardPage = new DashboardPage(driver);

        String res = dashboardPage.gotoTimeSheets().split(" ")[0]; // navigate to the time sheets page and also return the current number of time sheets.

        res = res.substring(1, res.length() - 1); // remove brackets and make it and integer for assertions.

        int noTimeSheetsInDashboard = Integer.parseInt(res);

        int noTimeSheets = dashboardPage.countTimeSheets(); // count number of time sheets records inside the page.

        Assert.assertEquals(noTimeSheets, noTimeSheetsInDashboard); // compare to see if the dashboard is displaying correct information.
    }

    @Test(priority = 5)
    public void validateSelfReviewButton() {
//        dashboardPage = new DashboardPage(driver);
        String res = dashboardPage.gotoSelfReviews().split(" ")[0]; // navigate to the self reviews page and also return the current number of self reviews.
        res = res.substring(1, res.length() - 1); // remove brackets and make it and integer for assertions.
        int noSelfReviewsInDashboard = Integer.parseInt(res);
        int noSelfReviews = dashboardPage.countSelfReviews(); // count number of self reviews records inside the page.
        Assert.assertEquals(noSelfReviews, noSelfReviewsInDashboard); // compare to see if the dashboard is displaying correct information.

    }

    @Test(priority = 6)
    public void validateCandidateInterviewButton() {
//        dashboardPage = new DashboardPage(driver);

        String res = dashboardPage.gotoCandidateInterviews().split(" ")[0]; // navigate to the candidate interviews page and also return the current number of candidate interviews.

        res = res.substring(1, res.length() - 1); // remove brackets and make it and integer for assertions.

        int noCandidateInterviewsInDashboard = Integer.parseInt(res);

        int noCandidateInterviews = dashboardPage.countCandidateInterviews(); // count number of candidate interviews records inside the page.


        Assert.assertEquals(noCandidateInterviews, noCandidateInterviewsInDashboard); // compare to see if the dashboard is displaying correct information.
    }

    @Test(priority = 7)
    public void validateLeaveRequestButton() {
        dashboardPage = new DashboardPage(driver);

        Assert.assertEquals(dashboardPage.getLeaveApplicantsButtonUrl(), dashboardPage.getLeaveApplicantsOnDashboardDivUrl());
    }

    @Test(priority = 8)
    public void timeSheetsToApproveButton() {
        dashboardPage = new DashboardPage(driver);

        Assert.assertEquals(dashboardPage.getTimeSheetsToApproveButtonUrl(), dashboardPage.getTimeSheetsOnDashboardDivUrl());
    }

    @Test(priority = 9)
    public void selfReviewButton() {
        dashboardPage = new DashboardPage(driver);

        Assert.assertEquals(dashboardPage.getSelfReviewsButtonUrl(), dashboardPage.getSelfReviewsOnDashboardDivUrl());
    }

    @Test(priority = 10)
    public void candidateInterviewsButton() {
        dashboardPage = new DashboardPage(driver);

        Assert.assertEquals(dashboardPage.getCandidateInterviewsButtonUrl(), dashboardPage.getCandidateInterviewsOnDashboardDivUrl());
    }


}
