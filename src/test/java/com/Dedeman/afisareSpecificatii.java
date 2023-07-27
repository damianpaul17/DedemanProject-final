package com.Dedeman;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class afisareSpecificatii {



    public void waitFor(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public  void afisareSpecificatii() {
                // Setarea calei către driverul Chrome
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

                // Deschiderea browserului Chrome
                WebDriver driver = new ChromeDriver();

                // Accesarea site-ului Dedeman
                driver.get("https://www.dedeman.ro/");

                driver.manage().window().maximize();

            WebElement acceptcookies = driver.findElement(By.xpath("/html/body/div[1]/div/footer/div[1]/div/div/div[2]/div/a[1]"));
            acceptcookies.click();


                // Căutarea "tractoras gazon" în bara de căutare
                WebElement searchInput = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[1]/div/div[2]/div[2]/div[1]/form/input"));
                searchInput.sendKeys("tractoras gazon");
                searchInput.submit();

                // Așteptarea încărcării paginii produsului
                waitFor(3000);

                // Alegerea al doilea rezultat
                WebElement tractoras= driver.findElement(By.linkText("Tractoras de tuns iarba, AL-KO Easy 123013, 8.5 kW, 4T, latime de taiere 93 cm"));
                tractoras.click();

                // Așteptarea încărcării paginii produsului
               waitFor(2000);

                //scroll
                WebElement footer = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]"));
                int deltaY = footer.getRect().getY();
                new Actions(driver)
                        .scrollByAmount(0, 1500)
                        .perform();

                waitFor(2000);
                // Adăugarea produsului la favorite

              /* WebElement addToFavorites = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[4]/div[3]/div/div[2]/div/div[2]/div[5]/div/button/i"));
                //driver.switchTo().frame(addToFavoritesButton);
                addToFavorites.click();
                //driver.findElement(By.tagName("button")).click();

        waitFor(2000);

        WebElement emailcos= driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[3]/div/div[1]/form/div[1]/input"));
            emailcos.sendKeys("damian.paul17@gmail.com");

            WebElement parola= driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[3]/div/div[1]/form/div[2]/input"));
            parola.sendKeys("Tester1234");

           */
            WebElement arataspecificatii= driver.findElement(By.xpath("//*[@id=\"description-component\"]/div/div[3]/div/div/a"));
          arataspecificatii.click();

          WebElement verificare= driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[4]/div/div[3]/div/div/a"));
            Assert.assertTrue(verificare.getText().contains("Ascunde"));

          // Închiderea browserului
            driver.quit();
            }
        }
