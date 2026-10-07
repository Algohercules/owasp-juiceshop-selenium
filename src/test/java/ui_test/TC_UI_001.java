package com.owasp.juiceshop;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_UI_001 {

    @Test
    void verifyOpenCartLogoVisibilityTest() {

        // Open Chrome
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to OpenCart
            driver.get("https://www.opencart.com/");

            // Locate OpenCart logo
            WebElement logo = driver.findElement(By.xpath("//a[@class='navbar-brand']//img"));

            // Verify that the logo is displayed
            assertTrue(logo.isDisplayed(), "The OpenCart logo should be visible on the OpenCart homepage.");

        } finally {
            // Close browser
            driver.quit();
        }
    }
}
