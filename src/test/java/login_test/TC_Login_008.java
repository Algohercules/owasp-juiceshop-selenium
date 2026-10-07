package com.owasp.juiceshop;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TC_Login_008 {

    @Test
    void emptyCredentialsLoginTest() {

        // Open Chrome
        WebDriver driver = new ChromeDriver();

        try {
            // Open OWASP Juice Shop
            driver.get("https://juice-shop.herokuapp.com/#/login");

            // Click Account
            driver.findElement(By.xpath("//button[@id='navbarAccount']"))
                    .click();

            // Click Login
            driver.findElement(By.xpath("//button[@id='navbarLoginButton']"))
                    .click();

            // Do not enter email

            // Do not enter password

            // Verify login button is disabled
            boolean loginButtonDisabled = !driver.findElement(By.xpath("//button[@id='loginButton']"))
                    .isEnabled();

            assertTrue(loginButtonDisabled,
                    "Login button should be disabled when fields are empty");

        } finally {
            // Close browser
            driver.quit();
        }
    }
}