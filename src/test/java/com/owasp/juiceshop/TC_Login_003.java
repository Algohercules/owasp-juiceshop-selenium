package com.owasp.juiceshop;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_Login_003 {

    @Test
    void validLoginTest() {

        // Open Chrome
        WebDriver driver = new ChromeDriver();

        // Open OWASP Juice Shop
        driver.get("https://juice-shop.herokuapp.com/#/login");

        // Click Account
        driver.findElement(By.xpath("//button[@id='navbarAccount']"))
                .click();

        // Click Login
        driver.findElement(By.xpath("//button[@id='navbarLoginButton']"))
                .click();

        // Enter Email
        driver.findElement(By.xpath("//input[@id='email']"))
                .sendKeys("");

        // Enter Password
        driver.findElement(By.xpath("//input[@id='password']"))
                .sendKeys("Mnbvcxz");

        // Click Login button
        driver.findElement(By.xpath("//button[@id='loginButton']"))
                .click();

        // Print current URL
        System.out.println("Current URL: " + driver.getCurrentUrl());

        // Close browser
        driver.quit();
    }
}
