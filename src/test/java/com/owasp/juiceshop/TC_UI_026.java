package com.owasp.juiceshop;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_UI_026 {

    @Test
    void verifyHeaderVisibilityTest() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get("https://www.opencart.com/");

            WebElement header = driver.findElement(By.xpath("//nav[contains(@class, 'navbar')] | //header"));
            assertTrue(header.isDisplayed(), "Header navigation bar should be visible.");

            int headerY = header.getLocation().getY();
            assertTrue(headerY <= 50, "Header should be properly positioned at the top of the page. Y=" + headerY);

            System.out.println("Header visibility and top position verified.");
        } finally {
            driver.quit();
        }
    }
}
