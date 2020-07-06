package com.alejandro.info.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    private static final String CHROME = "webdriver.chrome.driver";
    private static final String PATH_DRIVER = "/home/alejandro/Projects/chromedriver";

    public static WebDriver getDriver() {
        System.setProperty(CHROME, PATH_DRIVER);
        try {
            return new ChromeDriver();
        } catch (Exception e){
            throw new RuntimeException("Error to create web driver");
        }
    }
}
