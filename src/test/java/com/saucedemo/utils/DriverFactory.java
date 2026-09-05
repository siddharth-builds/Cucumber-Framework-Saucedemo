package com.saucedemo.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class DriverFactory {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            ChromeOptions options = new ChromeOptions();
            
            // Turn off password manager & leak detection popups
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            prefs.put("profile.password_manager_leak_detection", false);
            options.setExperimentalOption("prefs", prefs);

            // Additional flags to suppress password save banners
            options.addArguments("--disable-save-password-bubble");
            options.addArguments("--disable-notifications");

            WebDriver initDriver = new ChromeDriver(options);
            initDriver.manage().window().maximize();
            initDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.set(initDriver);
        }
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}