package com.owasp.juiceshop;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_UI_019 {

    @Test
    void verifyMobileLayoutTest() {
        WebDriver driver = new ChromeDriver();
        try {
            // Set mobile resolution 375 x 667
            driver.manage().window().setSize(new Dimension(375, 667));
            driver.get("https://www.opencart.com/");

            // In mobile view, navbar toggle button (hamburger) should be displayed
            WebElement navToggle = driver.findElement(By.xpath("//button[contains(@class, 'navbar-toggle')] | //button[contains(@class, 'navbar-toggler')] | //div[@class='navbar-header']"));
            assertTrue(navToggle.isDisplayed(), "Mobile navbar toggle button should be visible in mobile view.");

            // Logo should remain visible in mobile view
            WebElement logo = driver.findElement(By.xpath("//a[@class='navbar-brand']"));
            assertTrue(logo.isDisplayed(), "Logo should remain visible in mobile layout.");

            System.out.println("Mobile layout adaptation (375x667) verified successfully.");
        } finally {
            driver.quit();
        }
    }
}
