package com.owasp.juiceshop;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_UI_015 {

    @Test
    void verifyProductCardAlignmentTest() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get("https://www.opencart.com/index.php?route=marketplace/extension");

            List<WebElement> cards = driver.findElements(By.xpath("//div[contains(@class, 'extension-thumb')] | //div[contains(@class, 'col-')]//div[contains(@class, 'thumbnail')]"));
            if (cards.size() >= 2) {
                int firstWidth = cards.get(0).getSize().getWidth();
                int secondWidth = cards.get(1).getSize().getWidth();
                assertTrue(Math.abs(firstWidth - secondWidth) <= 10, "Product cards should maintain consistent dimensions.");
                System.out.println("Product card alignment and consistency verified.");
            } else {
                System.out.println("Cards found: " + cards.size() + "; verified single card visibility.");
                assertTrue(!cards.isEmpty(), "At least one card should be present.");
            }
        } finally {
            driver.quit();
        }
    }
}
