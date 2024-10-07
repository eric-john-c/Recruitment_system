package com.example.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
// import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class RemJob {

    public WebDriver driver;

    private By dashBy = By.xpath("/html/body/div[2]/a[2]");
    private By remButtBy = By.xpath("//*[@id=\"flash-cards\"]/div[1]/form/input[2]");

    public RemJob(WebDriver driver) {
        this.driver = driver;
    }

    @Test
    public void remJobTest() {
        driver.get("http://localhost:8080/rechome");
        driver.findElement(dashBy).click();
        driver.switchTo().frame("cont");
        driver.findElement(remButtBy).click();
    }

    @AfterMethod
    public void cleanup() {
        driver.quit();
    }
}
