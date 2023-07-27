package com.Dedeman;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class abonareNewsletter {

    public void waitFor(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void dedemanNewsletter() throws InterruptedException {

        //instantiem driverul
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //deschidem dedeman.ro
        String url = "https://www.dedeman.ro/";
        driver.get(url);

        //maximizam pagina
        driver.manage().window().maximize();

        //verificam landing page
        Assert.assertEquals(url, driver.getCurrentUrl());


        waitFor(300);

        //accept cookies
        WebElement acceptcookies= driver.findElement(By.xpath("/html/body/div[1]/div/footer/div[1]/div/div/div[2]/div/a[1]"));
        acceptcookies.click();

        //cautare newsletter
        WebElement email = driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[7]/form/div/div[1]/input"));
        email.sendKeys("damian.paul17@gmail.com");

        //biface checkbox
        WebElement checkbox= driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[7]/form/div/div[2]/div[1]/span/input"));
        checkbox.click();

        //click Abonare
        WebElement abonare= driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[7]/form/button/div"));
        abonare.click();

        waitFor(4000);

        //abonare cu succes
        String successMessage = "Ai fost abonat cu succes.";
        WebElement successAlert = driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[7]/form/div/span"));
        Assert.assertTrue(successAlert.getText().contains(successMessage));

        //inchidem pagina
        driver.close();


    }
}
