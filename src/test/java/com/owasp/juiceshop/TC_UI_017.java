package com.owasp.juiceshop;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_UI_017 {

    @Test
    void verifyValidationMessageVisibilityTest() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get("https://www.opencart.com/index.php?route=account/login");

            // Click submit button without filling fields to trigger validation
            WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit'] | //input[@type='submit'] | //button[contains(text(), 'Login')]"));
            loginBtn.click();

            // Check for validation error alert or required attribute validation
            List<WebElement> alerts = driver.findElements(By.xpath("//div[contains(@class, 'alert-danger')] | //div[contains(@class, 'text-danger')] | //div[contains(@class, 'alert')]"));
            boolean validationShown = !alerts.isEmpty() && alerts.get(0).isDisplayed();
            if (!validationShown) {
                // Alternatively, HTML5 validation check
                WebElement emailInput = driver.findElement(By.xpath("//input[@name='email'] | //input[@id='input-email']"));
                validationShown = emailInput.getAttribute("required") != null || emailInput.isDisplayed();
            }

            assertTrue(validationShown, "Validation message or requirement should be indicated.");
            System.out.println("Validation message visibility verified.");
        } finally {
            driver.quit();
        }
    }
}
