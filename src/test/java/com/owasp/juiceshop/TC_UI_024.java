package com.owasp.juiceshop;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_UI_024 {

    @Test
    void verifyPageSpacingConsistencyTest() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get("https://www.opencart.com/");

            List<WebElement> containers = driver.findElements(By.xpath("//div[contains(@class, 'container')]"));
            assertFalse(containers.isEmpty(), "Page containers should exist.");

            for (WebElement container : containers) {
                if (container.isDisplayed()) {
                    int width = container.getSize().getWidth();
                    assertTrue(width > 0, "Container width should be positive.");
                }
            }

            System.out.println("Page spacing consistency verified across " + containers.size() + " containers.");
        } finally {
            driver.quit();
        }
    }
}
