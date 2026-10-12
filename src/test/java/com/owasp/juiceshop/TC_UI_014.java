package com.owasp.juiceshop;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_UI_014 {

    @Test
    void verifyProductInformationVisibilityTest() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get("https://www.opencart.com/index.php?route=marketplace/extension");

            // Locate extension / product listings
            List<WebElement> extensionTitles = driver.findElements(By.xpath("//div[contains(@class, 'extension-description')]//h4 | //h4//a | //div[contains(@class, 'caption')]//a"));
            assertFalse(extensionTitles.isEmpty(), "Product/extension titles should be available.");

            WebElement firstItem = extensionTitles.get(0);
            assertTrue(firstItem.isDisplayed(), "Product information should be clearly displayed.");
            String titleText = firstItem.getText().trim();
            assertFalse(titleText.isEmpty(), "Product title should not be empty.");

            System.out.println("Product information visibility verified: " + titleText);
        } finally {
            driver.quit();
        }
    }
}
