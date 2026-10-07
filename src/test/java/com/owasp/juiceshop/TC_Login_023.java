package com.owasp.juiceshop;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_Login_023 {

    @Test
    void testCase() {

        WebDriver driver = new ChromeDriver();

        // Open Login page directly
        driver.get("https://demo.owasp-juice.shop/#/login");

        // Enter lowercase version of the valid email
        driver.findElement(By.xpath("//input[@id='email']"))
                .sendKeys("YOUR_VALID_EMAIL".toLowerCase());

        // Enter valid password
        driver.findElement(By.xpath("//input[@id='password']"))
                .sendKeys("YOUR_VALID_PASSWORD");

        // Click Login
        driver.findElement(By.xpath("//button[@id='loginButton']"))
                .click();

        System.out.println("Current URL: " + driver.getCurrentUrl());
        driver.quit();
    }
}
