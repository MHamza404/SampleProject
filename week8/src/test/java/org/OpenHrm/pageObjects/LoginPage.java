package org.OpenHrm.pageObjects;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.OpenHrm.WebDriverManager.*;


public class LoginPage extends PageObjectTemplate {


    public LoginPage(WebDriver inputDriver){

        super(inputDriver, 15);
    }

    /* All used WebElements */
    public By credentialsField = By.xpath("//p[@class='oxd-text oxd-text--p']");
    public By inputFields = By.xpath("//input[@class='oxd-input oxd-input--active']");
    public By errorInputFields = By.xpath("//input[@class='oxd-input oxd-input--active oxd-input--error']");

    public By loginButton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']");
    public By errorMessageSpan = By.xpath("//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']");


    public String getCredential(String field) {
        wait.until(ExpectedConditions.presenceOfElementLocated(inputFields));
        wait.until(ExpectedConditions.presenceOfElementLocated(credentialsField));
        List<WebElement> credentialFields =  getElements(credentialsField, driver);

        if (field.equals("username")){
            return credentialFields.get(0).getText().split(":")[1].trim();
        }

        else if (field.equals("password")){
            return credentialFields.get(1).getText().split(":")[1].trim();
        }

        else { return "error"; }

    }

    public void fillCredentials(String username, String password){

        wait.until(ExpectedConditions.presenceOfElementLocated(inputFields));

        List<WebElement> inputFieldsElements = getElements(inputFields, driver);

        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        wait.until(ExpectedConditions.presenceOfElementLocated(inputFields));


        if (inputFieldsElements.size() == 1){

            if (username.equals("")){

                WebElement passwordInput = inputFieldsElements.get(0);
                passwordInput.sendKeys(password);
            }

            if (password.equals("")){

                WebElement passwordInput = inputFieldsElements.get(0);
                passwordInput.sendKeys(username);
            }

        }
        else {
            WebElement usernameInput = inputFieldsElements.get(0), passwordInput = inputFieldsElements.get(1);

            usernameInput.sendKeys(username);
            passwordInput.sendKeys(password);
        }

    }

    public void pressLoginButton(){
        wait.until(ExpectedConditions.presenceOfElementLocated(loginButton));
        getElement(loginButton, driver).click();
    }
    public int getErrorMessages(){
        wait.until(ExpectedConditions.presenceOfElementLocated(errorMessageSpan));
        List<WebElement> errorSpans = getElements(errorMessageSpan, driver);
        return errorSpans.size();
    }
    public void fillCredentialsAndLogin(){
        wait.until(ExpectedConditions.presenceOfElementLocated(errorInputFields));
        WebElement errorInputField = getElement(errorInputFields, driver);
        errorInputField.sendKeys(getCredential("password"));
        wait.until(ExpectedConditions.presenceOfElementLocated(loginButton));
        getElement(loginButton, driver).click();
    }









//
//    public void inputPersonaldetails(String email, String firstName, String lastName, String company, String phone, String address1, String address2, String address3){
//        List<WebElement> inputs = driver.findElements(inputFields); // get list of input fields
//
//        inputs.get(2).sendKeys(("m.aman.alam.2001@gmail.com")); // email
//
//        inputs.get(4).sendKeys(("Muhammad")); // first name
//        inputs.get(5).sendKeys(("Aman")); // last name
//        inputs.get(6).sendKeys(("Al Aman Trading")); // company
//
//        inputs.get(7).sendKeys(("R-183")); // address
//        inputs.get(8).sendKeys(("Z-6"));
//        inputs.get(9).sendKeys(("Gulshan-e-Maymar"));
//
//        driver.findElement(telephoneInput).sendKeys("03122204919"); // Phone no.
//
//    }
//
//    public void inputStateAndClickOnNext(){ // select shipping method and state then wait for loading div to disappear and click the next button.
//
//        driver.findElements(stateSelectionSelect).get(0).sendKeys(Keys.ARROW_DOWN);
//        driver.findElement(shippingMethodRadio).click();
//
//        wait.until(ExpectedConditions.elementToBeClickable(nextButton));
//        driver.findElement(nextButton).click();
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(loadingDiv));
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingDiv));
//        actions.moveToElement(driver.findElement(nextButton));  // have to create an action to click it because of the overlay div
//        actions.click().build().perform();
//
//    }

}

