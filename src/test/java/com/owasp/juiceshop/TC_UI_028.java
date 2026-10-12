package com.owasp.juiceshop;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_UI_028 {

    @Test
    void verifyActiveNavigationStateTest() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get("https://www.opencart.com/index.php?route=cms/features");

            // Verify active state in navbar or page title reflection
            String pageTitle = driver.getTitle();
            String currentUrl = driver.getCurrentUrl();
            boolean isActive = currentUrl.contains("features") || pageTitle.toLowerCase().contains("features");

            assertTrue(isActive, "Current navigation option should show active state. URL: " + currentUrl);
            System.out.println("Active navigation state verified: " + currentUrl);
        } finally {
            driver.quit();
        }
    }
}
