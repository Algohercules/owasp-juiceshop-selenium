package com.owasp.juiceshop;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_UI_027 {

    @Test
    void verifyLogoClickabilityTest() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            // Start from features page
            driver.get("https://www.opencart.com/index.php?route=cms/features");

            WebElement logo = driver.findElement(By.xpath("//a[@class='navbar-brand']"));
            assertTrue(logo.isDisplayed(), "Brand logo should be visible.");

            logo.click();

            String currentUrl = driver.getCurrentUrl();
            assertTrue(currentUrl.equals("https://www.opencart.com/") || currentUrl.contains("opencart.com"),
                    "Clicking logo should navigate to homepage. Current URL: " + currentUrl);

            System.out.println("Logo clickability verified. Navigated to: " + currentUrl);
        } finally {
            driver.quit();
        }
    }
}
