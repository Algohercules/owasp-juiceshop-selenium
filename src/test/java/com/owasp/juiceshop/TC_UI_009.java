package com.owasp.juiceshop;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_UI_009 {

    @Test
    void verifySearchIconVisibilityTest() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get("https://www.opencart.com/index.php?route=marketplace/extension");

            // Locate search icon or search button element
            WebElement searchIcon = driver.findElement(By.xpath("//button[@id='button-search'] | //i[contains(@class, 'fa-search')] | //button[contains(@class, 'btn')]//i"));

            assertTrue(searchIcon.isDisplayed(), "Search icon should be visible.");
            System.out.println("Search icon visibility verified successfully.");
        } finally {
            driver.quit();
        }
    }
}
