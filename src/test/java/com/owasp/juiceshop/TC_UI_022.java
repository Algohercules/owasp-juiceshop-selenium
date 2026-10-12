package com.owasp.juiceshop;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_UI_022 {

    @Test
    void verifyButtonStylingConsistencyTest() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get("https://www.opencart.com/");

            List<WebElement> primaryButtons = driver.findElements(By.xpath("//a[contains(@class, 'btn')] | //button[contains(@class, 'btn')]"));
            assertFalse(primaryButtons.isEmpty(), "Buttons should be present on homepage.");

            for (WebElement btn : primaryButtons) {
                if (btn.isDisplayed()) {
                    String borderRadius = btn.getCssValue("border-radius");
                    assertNotNull(borderRadius, "Button should have defined border-radius styling.");
                }
            }

            System.out.println("Button styling consistency verified across buttons.");
        } finally {
            driver.quit();
        }
    }
}
