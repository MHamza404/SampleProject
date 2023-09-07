package org.OpenHrm.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.security.Key;
import java.util.List;

import static org.OpenHrm.WebDriverManager.*;

public class PerformancePage extends PageObjectTemplate{

    public By performancePageButton = By.xpath("//nav/div[2]/ul/li[7]");
    public By h5PageTitle = By.xpath("//h5[@class='oxd-text oxd-text--h5 oxd-table-filter-title']");
    public By h6PageTitle = By.xpath("//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title']");
    public By manageReviewsDropDown = By.xpath("//nav/ul/li[2]");

    public By DropDownOptions = By.xpath("//ul[@class='oxd-dropdown-menu']/li");
    public By addButton = By.xpath("//div[@class='orangehrm-header-container']/button");
    public By performanceReviewButtons = By.xpath("//div[@class='orangehrm-button-row']/button");
    public By emptyErrorButton = By.xpath("//*[text()='Required']");
    public By performanceReviewInputs = By.xpath("//form//input");
    public By suggestionDropdown = By.xpath("//*[contains(text(),'Odis  Adalwin')]");
    public By suggestionDropdown2 = By.xpath("//*[contains(text(),'John  Smith')]");

    public By configureDropDown = By.xpath("//nav/ul/li[1]");
    public By addKPIPageTitle = By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-main-title']");
    public By addKPIPageButtons = By.xpath("//div[@class='oxd-form-actions']/button");
    public By kpiIndicator= By.xpath("//*[@class='oxd-input oxd-input--active oxd-input--error']");
    public By jobTitleSelect = By.xpath("//*[@class='oxd-select-text-input']");
    public By submitButton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");


    public PerformancePage(WebDriver inputDriver){
        super(inputDriver, 15);
    }

    public void gotoPerformancePage(){
        wait.until(ExpectedConditions.presenceOfElementLocated(performancePageButton));
        getElement(performancePageButton, driver).click();
    }
    public String gotoManagePerformanceReviews(){
        getElement(manageReviewsDropDown, driver).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(DropDownOptions));
        getElements(DropDownOptions, driver).get(0).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(h5PageTitle));
        return getElement(h5PageTitle, driver).getText();

    }

    public String gotoMyReviews(){
        getElement(manageReviewsDropDown, driver).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(DropDownOptions));
        getElements(DropDownOptions, driver).get(1).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(h6PageTitle));
        return getElement(h6PageTitle, driver).getText();

    }

    public String gotoEmployeeReviews(){
        getElement(manageReviewsDropDown, driver).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(DropDownOptions));
        getElements(DropDownOptions, driver).get(2).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(h5PageTitle));
        return getElement(h5PageTitle, driver).getText();

    }

    public String gotoAddPerformanceReview(){
        wait.until(ExpectedConditions.elementToBeClickable(addButton));
        getElement(addButton, driver).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(h6PageTitle));
        return getElement(h6PageTitle, driver).getText();
    }

    public String pressCancelButton(){
        wait.until(ExpectedConditions.presenceOfElementLocated(performanceReviewButtons));
        getElements(performanceReviewButtons, driver).get(0).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(h5PageTitle));
        return getElement(h5PageTitle, driver).getText();
    }

    public int pressSaveButton(){
        wait.until(ExpectedConditions.presenceOfElementLocated(performanceReviewButtons));
        getElements(performanceReviewButtons, driver).get(1).click();
        return getElements(emptyErrorButton, driver).size();
    }

    public void addReviewData(){
        wait.until(ExpectedConditions.presenceOfElementLocated(performanceReviewInputs));
        List<WebElement> inputs = getElements(performanceReviewInputs, driver);

        inputs.get(0).sendKeys("Odis  Adalwin");
        wait.until(ExpectedConditions.presenceOfElementLocated(suggestionDropdown));
        wait.until(ExpectedConditions.elementToBeClickable(suggestionDropdown));
        getElements(suggestionDropdown, driver).get(0).click();
        inputs.get(1).sendKeys("John ");
        wait.until(ExpectedConditions.presenceOfElementLocated(suggestionDropdown2));
        wait.until(ExpectedConditions.elementToBeClickable(suggestionDropdown2));
        getElements(suggestionDropdown2, driver).get(0).click();
        inputs.get(2).sendKeys("2023-01-04");
        inputs.get(3).sendKeys("2023-01-05");
        inputs.get(4).sendKeys("2023-01-06");
    }

    public void pressActivateButton(){
        wait.until(ExpectedConditions.presenceOfElementLocated(performanceReviewButtons));
        getElements(performanceReviewButtons, driver).get(2).click();
    }

    public String gotoKPIs(){
        wait.until(ExpectedConditions.elementToBeClickable(configureDropDown));
        getElement(configureDropDown, driver).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(DropDownOptions));
        getElements(DropDownOptions, driver).get(0).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(h5PageTitle));
        return getElement(h5PageTitle, driver).getText();

    }

    public String gotoAddKPI(){
        wait.until(ExpectedConditions.elementToBeClickable(addButton));
        getElement(addButton, driver).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(addKPIPageTitle));
        return getElement(addKPIPageTitle, driver).getText();

    }

    public String pressAddKPICancelButton(){
        wait.until(ExpectedConditions.presenceOfElementLocated(addKPIPageButtons));
        getElements(addKPIPageButtons, driver).get(0).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(h5PageTitle));
        String res =  getElement(h5PageTitle, driver).getText();
        driver.navigate().back();
        wait.until(ExpectedConditions.presenceOfElementLocated(addKPIPageTitle));
        return res;
    }

    public int pressAddKPISaveButton(){
        wait.until(ExpectedConditions.presenceOfElementLocated(addKPIPageButtons));
        getElements(addKPIPageButtons, driver).get(1).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(emptyErrorButton));
        return getElements(emptyErrorButton, driver).size();
    }

    public void addKPIDetails(){
        wait.until(ExpectedConditions.presenceOfElementLocated(kpiIndicator));
        getElement(kpiIndicator, driver).sendKeys("abc");
        WebElement jobTitle = getElement(jobTitleSelect, driver);
        jobTitle.click();
        jobTitle.sendKeys(Keys.DOWN);
        jobTitle.sendKeys(Keys.DOWN);
        jobTitle.sendKeys(Keys.DOWN);
        jobTitle.sendKeys(Keys.DOWN);
        jobTitle.sendKeys(Keys.RETURN);
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        getElement(submitButton, driver).click();

    }
}
