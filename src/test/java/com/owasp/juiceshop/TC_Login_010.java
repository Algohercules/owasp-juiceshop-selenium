package com.owasp.juiceshop;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TC_Login_010 {

    @Test
    void validEmailIncorrectPasswordTest() {

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

            // Enter valid email
            driver.findElement(By.xpath("//input[@id='email']"))
                    .sendKeys("adarshrreso@gmail.com");

            // Enter incorrect password
            driver.findElement(By.xpath("//input[@id='password']"))
                    .sendKeys("WrongPassword@123");

            // Click Login button
            driver.findElement(By.xpath("//button[@id='loginButton']"))
                    .click();

            // Verify login was unsuccessful
            boolean loginPageDisplayed = driver.getCurrentUrl().contains("/#/login");

            assertTrue(loginPageDisplayed,
                    "Incorrect password should not allow login");

        } finally {
            // Close browser
            driver.quit();
        }
    }
}