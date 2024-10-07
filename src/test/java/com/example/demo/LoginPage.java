package com.example.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
// import org.testng.annotations.AfterTest;
// import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPage {
    private WebDriver driver;
    private By usernameInput = By.id("username");
    private By passwordInput = By.id("password");
    private By loginButton = By.id("login");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Test(dataProvider = "dp")
    public void validation(String username, String password) {
        driver.get("http://localhost:8080");
        driver.findElement(usernameInput).clear();
        driver.findElement(usernameInput).sendKeys(username);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    @AfterMethod
    public void cleanup() {
        driver.quit();
    }

    @DataProvider(name = "dp")
    public Object[][] dp() {
        return new Object[][] { { "sriram", "kins@123" }, { "syed", "eric@123" } };
    }

}
