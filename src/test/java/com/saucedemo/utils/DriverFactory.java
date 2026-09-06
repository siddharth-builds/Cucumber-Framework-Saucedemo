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

            // Check if running in GitHub Actions environment
            boolean isCI = System.getenv("GITHUB_ACTIONS") != null && System.getenv("GITHUB_ACTIONS").equals("true");

            if (isCI) {
                options.addArguments("--headless=new");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--window-size=1920,1080");
            }

            WebDriver initDriver = new ChromeDriver(options);

            if (!isCI) {
                initDriver.manage().window().maximize();
            }

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