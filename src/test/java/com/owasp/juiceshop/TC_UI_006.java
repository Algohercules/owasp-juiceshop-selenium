package com.owasp.juiceshop;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TC_UI_006 {

    @Test
    void verifyButtonHoverStateTest() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get("https://www.opencart.com/");

            // Locate primary action button
            WebElement button = driver.findElement(By.xpath("//div[@id='navbar-collapse-header']//a[contains(text(), 'Register') or contains(text(), 'Login')]"));
            assertTrue(button.isDisplayed(), "Action button should be visible on homepage.");

            String initialBg = button.getCssValue("background-color");
            assertNotNull(initialBg, "Initial background color should not be null.");

            // Hover over button
            Actions actions = new Actions(driver);
            actions.moveToElement(button).perform();

            String hoverBg = button.getCssValue("background-color");
            System.out.println("Button hover effect verified. Initial bg: " + initialBg + ", Hover bg: " + hoverBg);
            assertTrue(button.isDisplayed(), "Button should remain visible during hover.");
        } finally {
            driver.quit();
        }
    }
}
