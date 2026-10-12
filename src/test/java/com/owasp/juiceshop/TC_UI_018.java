package com.owasp.juiceshop;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_UI_018 {

    @Test
    void verifyFooterSectionVisibilityTest() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get("https://www.opencart.com/");

            WebElement footer = driver.findElement(By.xpath("//footer"));
            assertTrue(footer.isDisplayed(), "Footer container should be visible.");

            List<WebElement> footerLinks = driver.findElements(By.xpath("//footer//a"));
            assertFalse(footerLinks.isEmpty(), "Footer should contain navigation links.");

            System.out.println("Footer section visibility verified with " + footerLinks.size() + " links.");
        } finally {
            driver.quit();
        }
    }
}
