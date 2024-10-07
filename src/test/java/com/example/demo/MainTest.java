package com.example.demo;

// import org.openqa.selenium.By;
// import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.support.ui.ExpectedConditions;
// import org.openqa.selenium.support.ui.WebDriverWait;
// import org.openqa.selenium.support.ui.ExpectedConditions;
// import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

// import java.time.Duration;
// import java.util.concurrent.TimeUnit;

public class MainTest {
    public WebDriver driver = new ChromeDriver();

    @Test(priority = 0, dataProvider = "dp")
    public void Test1(String username, String password) {
        RegPage rp = new RegPage(driver);
        rp.registration(username, password);
    }

    @Test(priority = 1, dataProvider = "dp")
    public void Test2(String username, String password) {
        LoginPage lp = new LoginPage(driver);
        lp.validation(username, password);
    }

    @Test(priority = 2, dataProvider = "dp1")
    public void Test3(String job, String sal, String phno) {
        AddJob aj = new AddJob(driver);
        aj.addJobTest(job, sal, phno);
    }

    @Test(priority = 3)
    public void Test4() {
        JobList jl = new JobList(driver);
        jl.jobs();
    }

    @Test(priority = 4)
    public void Test5() {
        RemJob rj = new RemJob(driver);
        rj.remJobTest();
    }

    @Test(priority = 5)
    public void Test6() {
        JobList jl = new JobList(driver);
        jl.jobs();
    }

    @DataProvider(name = "dp")
    public Object[][] dp() {
        return new Object[][] { { "sriram", "kins@123" }, { "syed", "eric@123" } };
    }

    @DataProvider(name = "dp1")
    public Object[][] dp2() {
        return new Object[][] { { "Job a", "$8457", "236528736" }, { "Job b", "$3276", "387648723" } };
    }

    @AfterTest
    public void cleanup() {
        driver.quit();
    }

}
