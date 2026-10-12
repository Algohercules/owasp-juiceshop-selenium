package com.owasp.juiceshop;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_UI_021 {

    @Test
    void verifyHorizontalScrollingTest() {
        WebDriver driver = new ChromeDriver();
        try {
            // Set mobile resolution
            driver.manage().window().setSize(new Dimension(375, 667));
            driver.get("https://www.opencart.com/");

            JavascriptExecutor js = (JavascriptExecutor) driver;
            Long scrollWidth = (Long) js.executeScript("return document.documentElement.scrollWidth;");
            Long clientWidth = (Long) js.executeScript("return document.documentElement.clientWidth;");

            // Allow small 25px leeway for scrollbar gutter
            assertTrue(scrollWidth <= clientWidth + 25, 
                    "Page should not require horizontal scrolling on mobile. scrollWidth: " + scrollWidth + ", clientWidth: " + clientWidth);

            System.out.println("Horizontal scrolling validation passed. scrollWidth=" + scrollWidth + ", clientWidth=" + clientWidth);
        } finally {
            driver.quit();
        }
    }
}
