package com.owasp.juiceshop;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_UI_007 {

    @Test
    void verifySearchBarVisibilityTest() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            // Navigate to marketplace where search bar is located
            driver.get("https://www.opencart.com/index.php?route=marketplace/extension");

            // Locate search bar input field
            WebElement searchBar = driver.findElement(By.xpath("//input[@name='filter_search'] | //input[contains(@placeholder, 'Search')]"));

            // Verify search bar is visible and accessible
            assertTrue(searchBar.isDisplayed(), "Search bar should be visible on the marketplace page.");
            assertTrue(searchBar.isEnabled(), "Search bar should be accessible and enabled.");
            System.out.println("Search bar visibility and accessibility verified.");
        } finally {
            driver.quit();
        }
    }
}
