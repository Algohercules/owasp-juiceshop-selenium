package com.owasp.juiceshop;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_UI_002 {

    @Test
    void verifyHeaderNavigationVisibilityTest() {

        // Open Chrome
        WebDriver driver = new ChromeDriver();

        try {
            // Maximize browser window to ensure header navigation is expanded
            driver.manage().window().maximize();

            // Navigate to OpenCart homepage
            driver.get("https://www.opencart.com/");

            // Locate primary navigation bar
            WebElement navbar = driver.findElement(By.xpath("//div[@id='navbar-collapse-header']//ul[contains(@class, 'navbar-nav')]"));
            assertTrue(navbar.isDisplayed(), "The header navigation bar should be visible.");

            // Locate primary navigation options: Features, Demo, Marketplace, Blog, Download, Resources
            String[] navItems = {"Features", "Demo", "Marketplace", "Blog", "Download", "Resources"};

            for (String item : navItems) {
                WebElement navLink = driver.findElement(By.xpath("//div[@id='navbar-collapse-header']//ul[contains(@class, 'navbar-nav')]//a[contains(text(), '" + item + "')]"));
                assertTrue(navLink.isDisplayed(), "Primary navigation option '" + item + "' should be visible.");
            }

        } finally {
            // Close browser
            driver.quit();
        }
    }
}
