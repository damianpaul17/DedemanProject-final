package com.Dedeman;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
public class adaugareCos {
    public void waitFor(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void adaugareincos() {


        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "https://www.dedeman.ro/";
        driver.get(url);
        //driver.manage().window().maximize();

        //verificam landing page
        Assert.assertEquals(url, driver.getCurrentUrl());
        //accept cookies
        WebElement acceptcookies = driver.findElement(By.xpath("/html/body/div[1]/div/footer/div[1]/div/div/div[2]/div/a[1]"));
        acceptcookies.click();
        waitFor(1000);

        WebElement searchbar= driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[1]/div/div[2]/div[2]/div[1]/form/input"));
        searchbar.click();
        searchbar.sendKeys("tractoras gazon");
        waitFor(1000);
        WebElement cauta= driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[1]/div/div[2]/div[2]/div[1]/form/div/button/div"));
        cauta.click();
        waitFor(4000);

        Assert.assertTrue(driver.getCurrentUrl().contains("tractoras"));

        waitFor(2000);
        WebElement tractoras= driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[4]/div[2]/div[1]/div[2]/div[2]/a/span[2]"));
        tractoras.click();

        waitFor(5000);

        WebElement heart= driver.findElement(By.cssSelector("#app > div > div.container > div.page-section.custom > div > div.col-lg-5.col-sm-5 > div > div.position-relative > div.actions.transparent.align-right.position-relative.clearfix > div > button > span"));
        heart.click();

    }
}