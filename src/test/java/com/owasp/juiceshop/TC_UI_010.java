package com.owasp.juiceshop;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_UI_010 {

    @Test
    void verifyNavigationLinkInteractionTest() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get("https://www.opencart.com/");

            // Locate navigation link (Features)
            WebElement featuresLink = driver.findElement(By.xpath("//div[@id='navbar-collapse-header']//ul[contains(@class, 'navbar-nav')]//a[contains(text(), 'Features')]"));
            assertTrue(featuresLink.isDisplayed(), "Features navigation link should be visible.");

            featuresLink.click();

            String currentUrl = driver.getCurrentUrl();
            assertTrue(currentUrl.toLowerCase().contains("features") || driver.getTitle().toLowerCase().contains("features"),
                    "Selected navigation link should navigate to Features page. Current URL: " + currentUrl);
            System.out.println("Navigation link interaction verified: " + currentUrl);
        } finally {
            driver.quit();
        }
    }
}
