package com.coherent.training.selenium.stanila;

import org.openqa.selenium.By;

public class Locators {
    public static By logCentralPage = By.xpath("//button[starts-with(@class,'Button2')]");
    public static By usernameSpace = By.id("passp-field-login");
    public static By logUsername = By.xpath("//button[@id='passp:sign-in']");
    public static By passwordSpace = By.className("Textinput-Control");
    public static By loginPassword = By.xpath("//button[@id='passp:sign-in']");
    public static By cssSelector = By.cssSelector("a.Folder-m__link--oBMDN");
    public static By userNameDisplay = By.linkText("moraru.andy");
    public static By label = By.partialLinkText("Add");
    public static By links = By.tagName("a");
}
