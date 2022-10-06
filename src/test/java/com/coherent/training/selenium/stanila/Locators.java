package com.coherent.training.selenium.stanila;

import org.openqa.selenium.By;

public class Locators {
    public static final By LOG_CENTRAL_PAGE = By.xpath("//button[starts-with(@class,'Button2')]");
    public static final By USERNAME_SPACE = By.id("passp-field-login");
    public static final By LOG_USERNAME = By.xpath("//button[@id='passp:sign-in']");
    public static final By PASSWORD_SPACE = By.className("Textinput-Control");
    public static final By LOGIN_PASSWORD = By.xpath("//button[@id='passp:sign-in']");
    public static final By cssSelector = By.cssSelector("a.Folder-m__link--oBMDN");
    public static final By USERNAME_DISPLAY = By.linkText("moraru.andy");
    public static final By LABEL = By.partialLinkText("Add");
    public static final By LINKS = By.tagName("a");
}
