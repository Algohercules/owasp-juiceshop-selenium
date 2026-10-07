package com.owasp.juiceshop;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TC_Login_007 {

    @Test
    void emailMissingAtSymbolTest() {

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

            // Enter email without @
            driver.findElement(By.xpath("//input[@id='email']"))
                    .sendKeys("adarshrresogmail.com");

            // Enter valid password
            driver.findElement(By.xpath("//input[@id='password']"))
                    .sendKeys("Mnbvcxz@123");

            // Click Login button
            driver.findElement(By.xpath("//button[@id='loginButton']"))
                    .click();

            // Verify login is prevented
            boolean loginPageDisplayed = driver.getCurrentUrl().contains("/#/login");

            assertTrue(loginPageDisplayed,
                    "Email without @ should be rejected");

        } finally {
            // Close browser
            driver.quit();
        }
    }
}