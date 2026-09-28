package com.owasp.juiceshop;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicSeleniumTest {

    @Test
    void validLoginTest() {

        WebDriver driver = new ChromeDriver();

        try {
            // Open Juice Shop
            driver.get("https://juice-shop.herokuapp.com/#/search");

            // Open Account menu
            driver.findElement(By.id("navbarAccount")).click();

            // Click Login
            driver.findElement(By.id("navbarLoginButton")).click();

            // Enter email
            driver.findElement(By.id("email"))
                    .sendKeys("adarshrreso@gmail.com");

            // Enter password
            driver.findElement(By.id("password"))
                    .sendKeys("Mnbvcxz@123");

            // Click Login
            driver.findElement(By.id("loginButton")).click();

            // Display result
            System.out.println("Login completed");
            System.out.println("Current URL: " + driver.getCurrentUrl());

        } finally {
            driver.quit();
        }
    }
}

