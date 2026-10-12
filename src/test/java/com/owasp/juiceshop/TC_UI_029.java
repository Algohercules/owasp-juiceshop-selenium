package com.owasp.juiceshop;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_UI_029 {

    @Test
    void verifyButtonTextVisibilityTest() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get("https://www.opencart.com/");

            List<WebElement> buttons = driver.findElements(By.xpath("//div[@id='navbar-collapse-header']//a[contains(@class, 'btn')]"));
            assertFalse(buttons.isEmpty(), "Header buttons should be present.");

            for (WebElement btn : buttons) {
                if (btn.isDisplayed()) {
                    String text = btn.getText().trim();
                    assertFalse(text.isEmpty(), "Button text should be clearly visible.");
                    assertFalse(text.contains("...") || text.contains("…"), "Button text should not be truncated.");
                }
            }

            System.out.println("Button text visibility without truncation verified.");
        } finally {
            driver.quit();
        }
    }
}
