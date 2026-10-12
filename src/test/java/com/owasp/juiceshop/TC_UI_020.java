package com.owasp.juiceshop;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_UI_020 {

    @Test
    void verifyTabletLayoutTest() {
        WebDriver driver = new ChromeDriver();
        try {
            // Set tablet resolution 768 x 1024
            driver.manage().window().setSize(new Dimension(768, 1024));
            driver.get("https://www.opencart.com/");

            WebElement header = driver.findElement(By.xpath("//nav[contains(@class, 'navbar')]"));
            assertTrue(header.isDisplayed(), "Header should adapt and display correctly in tablet view.");

            WebElement container = driver.findElement(By.xpath("//div[contains(@class, 'container')]"));
            assertTrue(container.isDisplayed(), "Main content container should adapt in tablet layout.");

            System.out.println("Tablet layout adaptation (768x1024) verified successfully.");
        } finally {
            driver.quit();
        }
    }
}
