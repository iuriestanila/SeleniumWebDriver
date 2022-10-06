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
    public void setUp(){
        driver =  WebDriverManager.chromedriver().create();
        softAssert = new SoftAssert();
    }

    @Test
    public void testLogInSuccessful() {
        login();
        String expectedTitle = "Inbox — Yandex Mail";
        softAssert.assertEquals(driver.getTitle(),expectedTitle);
        softAssert.assertAll();
    }

    @Test
    public void testInboxEnabled(){
        login();
        softAssert.assertTrue(driver.findElement(Locators.cssSelector).isEnabled());
        softAssert.assertAll();
    }

    @Test
    public void testDisplayUsername(){
        login();
        softAssert.assertTrue(driver.findElement(Locators.USERNAME_DISPLAY).isDisplayed());
        softAssert.assertAll();
    }

    @Test
    public void testAddLabelEnabled(){
        login();
        softAssert.assertTrue(driver.findElement(Locators.LABEL).isEnabled());
        softAssert.assertAll();
    }

    @Test
    public void testSumOfLinks(){
        driver.manage().window().maximize();
        driver.get("https://mail.yandex.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        int expectedLinksPage = 24;
        int actualLinksPage = driver.findElements(Locators.LINKS).size();
        softAssert.assertEquals(actualLinksPage,expectedLinksPage);
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @SneakyThrows
    public void login(){
        driver.manage().window().maximize();
        driver.get("https://mail.yandex.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        driver.findElement(Locators.LOG_CENTRAL_PAGE).click();

        driver.findElement(Locators.USERNAME_SPACE).sendKeys(USERNAME);
        TimeUnit.SECONDS.sleep(1);

        driver.findElement(Locators.LOG_USERNAME).click();
        TimeUnit.SECONDS.sleep(2);

        driver.findElement(Locators.PASSWORD_SPACE).sendKeys(PASSWORD);
        TimeUnit.SECONDS.sleep(2);

        driver.findElement(Locators.LOGIN_PASSWORD).click();
        TimeUnit.SECONDS.sleep(4);
    }
}

