package com.owasp.juiceshop;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_UI_016 {

    @Test
    void verifyInputFieldLabelsAndPlaceholdersTest() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get("https://www.opencart.com/index.php?route=account/login");

            // Locate email input field
            WebElement emailInput = driver.findElement(By.xpath("//input[@name='email'] | //input[@id='input-email']"));
            assertTrue(emailInput.isDisplayed(), "Email input field should be visible.");

            // Locate password input field
            WebElement passwordInput = driver.findElement(By.xpath("//input[@name='password'] | //input[@id='input-password']"));
            assertTrue(passwordInput.isDisplayed(), "Password input field should be visible.");

            // Check placeholder or associated label
            String emailPlaceholder = emailInput.getAttribute("placeholder");
            boolean hasPlaceholderOrLabel = (emailPlaceholder != null && !emailPlaceholder.isEmpty()) 
                    || driver.findElements(By.xpath("//label[contains(@for, 'email') or contains(text(), 'E-Mail')]")).size() > 0;
            assertTrue(hasPlaceholderOrLabel, "Input field should have visible label or placeholder.");

            System.out.println("Input field labels and placeholders verified.");
        } finally {
            driver.quit();
        }
    }
}
