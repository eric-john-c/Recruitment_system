package com.example.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
// import org.testng.annotations.AfterTest;
// import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddJob {

    public WebDriver driver;

    public AddJob(WebDriver driver) {
        this.driver = driver;
    }

    private By jobBy = By.xpath("/html/body/form/input[1]");
    private By salaryBy = By.xpath("/html/body/form/input[2]");
    private By phnoBy = By.xpath("/html/body/form/input[3]");
    private By addJobBy = By.xpath("/html/body/form/input[4]");

    @Test
    public void addJobTest(String job, String salary, String phno) {
        driver.get("http://localhost:8080/rechome");
        driver.findElement(By.xpath("/html/body/div[2]/a[2]")).click();
        driver.switchTo().frame("cont");
        driver.findElement(jobBy).clear();
        driver.findElement(jobBy).sendKeys(job);
        driver.findElement(salaryBy).clear();
        driver.findElement(salaryBy).sendKeys(salary);
        driver.findElement(phnoBy).clear();
        driver.findElement(phnoBy).sendKeys(phno);
        driver.findElement(addJobBy).click();
    }

    @AfterMethod
    public void cleanup() {
        driver.quit();
    }
}
