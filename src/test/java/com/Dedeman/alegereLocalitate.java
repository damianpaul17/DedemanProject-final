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

public class alegereLocalitate {
    public void waitFor(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void alegerelocalitate() {

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
        //click alegere localitate
         WebElement alegereLocalite= driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div/div[2]/div[1]/div[1]/span"));
        alegereLocalite.click();
        waitFor(1000);

       WebElement judet = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[3]/div/div/div[1]/div/input"));
        judet.click();
        judet.sendKeys("Cluj");
        waitFor(2000);
        new Actions(driver).sendKeys(Keys.ENTER).perform();
        waitFor(2000);

        // Selectarea localității Cluj-Napoca
        WebElement localitate = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[3]/div/div/div[2]/div/input"));
        localitate.click();
        waitFor(2000);
        localitate.sendKeys("Cluj-Napoca");
        //new Actions(driver).contextClick((WebElement)localitate);

        new Actions(driver).sendKeys(Keys.TAB).perform();
        waitFor(1000);
        System.out.println(driver.getCurrentUrl());
        waitFor(3000);
        WebElement cookies2= driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/ul/li[2]/button"));
        cookies2.click();
        waitFor(2000);

        WebElement paginaanterioara= driver.findElement(By.xpath("/html/body/div[2]/header/div/div[1]/a/span"));
        paginaanterioara.click();
        waitFor(2000);
        WebElement locatiealeasa= driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div[1]/div[1]/span/span[2]/span"));
        Assert.assertTrue(locatiealeasa.getText().contains("Cluj"));

        driver.close();
    }
}