package com.example.demo;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
// import org.testng.annotations.AfterTest;

public class JobList {
    public WebDriver driver;
    private By comp = By.xpath("/html/body/div[2]/a[2]");
    private By usernameInput = By.id("username");
    private By passwordInput = By.id("password");
    private By loginButton = By.id("login");

    public JobList(WebDriver driver) {
        this.driver = driver;
    }

    @Test
    public void jobs() {
        driver.get("http://localhost:8080/clog");
        driver.findElement(usernameInput).sendKeys("alvin");
        driver.findElement(passwordInput).sendKeys("12345");
        driver.findElement(loginButton).click();
        driver.findElement(comp).click();
    }

    @AfterMethod
    public void cleanup() {
        driver.quit();
    }
}
