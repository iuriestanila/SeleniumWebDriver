package com.coherent.training.selenium.stanila;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Yandex {
    WebDriver driver;
    SoftAssert softAssert;
    public static final String USERNAME = "moraru.andy";
    public static final String PASSWORD = "RootRoot5?";

    @BeforeMethod
    void setUp(){
        driver =  WebDriverManager.chromedriver().create();
        softAssert = new SoftAssert();
    }

    @Test
    @SneakyThrows
    void logIn() {
        driver.manage().window().maximize();
        driver.get("https://mail.yandex.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        driver.findElement(Locators.logCentralPage).click();

        driver.findElement(Locators.usernameSpace).sendKeys(USERNAME);
        TimeUnit.SECONDS.sleep(1);

        driver.findElement(Locators.logUsername).click();
        TimeUnit.SECONDS.sleep(2);

        driver.findElement(Locators.passwordSpace).sendKeys(PASSWORD);
        TimeUnit.SECONDS.sleep(2);

        driver.findElement(Locators.loginPassword).click();
        TimeUnit.SECONDS.sleep(4);

        String expectedTitle = "Inbox — Yandex Mail";
        softAssert.assertEquals(driver.getTitle(),expectedTitle);
        softAssert.assertAll();
    }

    @Test
    void inboxEnabled(){
        logIn();
        softAssert.assertTrue(driver.findElement(Locators.cssSelector).isEnabled());
        softAssert.assertAll();
    }


    @Test
    void displayUsername(){
        logIn();
        softAssert.assertTrue(driver.findElement(Locators.userNameDisplay).isDisplayed());
        softAssert.assertAll();
    }

    @Test
    void addLabelEnabled(){
        logIn();
        softAssert.assertTrue(driver.findElement(Locators.label).isEnabled());
        softAssert.assertAll();
    }

    @Test
    void sumOfLinks(){
        driver.manage().window().maximize();
        driver.get("https://mail.yandex.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        int expectedLinksPage = 24;
        int actualLinksPage = driver.findElements(Locators.links).size();
        softAssert.assertEquals(actualLinksPage,expectedLinksPage);
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

