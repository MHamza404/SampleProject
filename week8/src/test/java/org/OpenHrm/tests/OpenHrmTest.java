package org.OpenHrm.tests;

import org.OpenHrm.WebDriverManager;
import org.OpenHrm.config.PropertyReader;
import org.OpenHrm.pageObjects.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class OpenHrmTest extends WebDriverManager {

    public String url = PropertyReader.getProperty("url");




    @BeforeClass
    public void preNavigate(){

        navigateDriver(url);
    }



    @Test(priority = 1)
    public void EmptyLoginTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.pressLoginButton();
        Assert.assertEquals(loginPage.getErrorMessages(), 2);
    }

    @Test(priority = 2)
    public void OnlyUserLoginTest(){

        driver.navigate().refresh();

        LoginPage loginPage = new LoginPage(driver);

        String user = loginPage.getCredential("username");

        loginPage.fillCredentials(user, "");
        loginPage.pressLoginButton();
        Assert.assertEquals(loginPage.getErrorMessages(), 1);
    }


    @Test(priority = 3)
    public void OnlyPassrLoginTest(){

        driver.navigate().refresh();
        LoginPage loginPage = new LoginPage(driver);

        String pass = loginPage.getCredential("password");

        loginPage.fillCredentials("", pass);
        loginPage.pressLoginButton();
        Assert.assertEquals(loginPage.getErrorMessages(), 1);

    }


    @Test(priority = 4)
    public void LoginTest(){

        LoginPage loginPage = new LoginPage(driver);


        String user = loginPage.getCredential("username");
        String pass = loginPage.getCredential("password");

        loginPage.fillCredentialsAndLogin();

    }















}








