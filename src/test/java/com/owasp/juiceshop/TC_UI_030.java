package com.owasp.juiceshop;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_UI_030 {

    @Test
    void verifyButtonAlignmentTest() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get("https://www.opencart.com/");

            WebElement loginBtn = driver.findElement(By.xpath("//div[@id='navbar-collapse-header']//div[contains(@class, 'navbar-right')]//a[contains(text(), 'Login')]"));
            WebElement registerBtn = driver.findElement(By.xpath("//div[@id='navbar-collapse-header']//div[contains(@class, 'navbar-right')]//a[contains(text(), 'Register')]"));

            assertTrue(loginBtn.isDisplayed(), "Login button should be visible.");
            assertTrue(registerBtn.isDisplayed(), "Register button should be visible.");

            int loginY = loginBtn.getLocation().getY();
            int registerY = registerBtn.getLocation().getY();
            int yDiff = Math.abs(loginY - registerY);

            assertTrue(yDiff <= 10, "Adjacent action buttons should be aligned on the same horizontal plane. Difference: " + yDiff + "px");
            System.out.println("Button alignment verified. Vertical difference: " + yDiff + "px");
        } finally {
            driver.quit();
        }
    }
}
