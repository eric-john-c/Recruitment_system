package com.example.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
// import org.testng.annotations.AfterTest;
// import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegPage {
    public WebDriver driver;

    private By usernameInput = By.id("username");
    private By passwordInput = By.id("password");
    private By regButton = By.id("register");

    public RegPage(WebDriver driver) {
        this.driver = driver;
    }

    @Test
    public void registration(String username, String password) {
        driver.get("http://localhost:8080");
        driver.findElement(By.xpath("/html/body/form/a")).click();
        driver.findElement(usernameInput).clear();
        driver.findElement(usernameInput).sendKeys(username);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(regButton).click();
    }

    @AfterMethod
    public void cleanup() {
        driver.quit();
    }

}
