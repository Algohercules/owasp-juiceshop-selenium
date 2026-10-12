package com.owasp.juiceshop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_UI_008 {

    @Test
    void verifySearchFieldInputTest() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get("https://www.opencart.com/index.php?route=marketplace/extension");

            WebElement searchField = driver.findElement(By.xpath("//input[@name='filter_search'] | //input[contains(@placeholder, 'Search')]"));
            assertTrue(searchField.isDisplayed(), "Search field should be visible.");

            String testKeyword = "payment";
            searchField.clear();
            searchField.sendKeys(testKeyword);

            String enteredValue = searchField.getAttribute("value");
            assertEquals(testKeyword, enteredValue, "Search field should display entered text correctly.");
            System.out.println("Search field input validation successful. Value entered: " + enteredValue);
        } finally {
            driver.quit();
        }
    }
}
