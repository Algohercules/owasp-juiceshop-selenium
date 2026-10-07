package com.owasp.juiceshop;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TC_Login_009 {

    @Test
    void bothInvalidCredentialsLoginTest() {

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

            // Enter invalid email
            driver.findElement(By.xpath("//input[@id='email']"))
                    .sendKeys("invaliduser@gmail.com");

            // Enter invalid password
            driver.findElement(By.xpath("//input[@id='password']"))
                    .sendKeys("WrongPassword@123");

            // Click Login button
            driver.findElement(By.xpath("//button[@id='loginButton']"))
                    .click();

            // Verify login was unsuccessful
            boolean loginPageDisplayed = driver.getCurrentUrl().contains("/#/login");

            assertTrue(loginPageDisplayed,
                    "Invalid credentials should not allow login");

        } finally {
            // Close browser
            driver.quit();
        }
    }
}