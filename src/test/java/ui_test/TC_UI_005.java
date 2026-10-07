package com.owasp.juiceshop;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_UI_005 {

    @Test
    void verifyActionButtonVisibilityTest() {

        // Open Chrome
        WebDriver driver = new ChromeDriver();

        try {
            // Maximize browser window to ensure desktop header layout
            driver.manage().window().maximize();

            // Navigate to OpenCart homepage
            driver.get("https://www.opencart.com/");

            // Locate header container
            WebElement navbar = driver.findElement(By.xpath("//nav[contains(@class, 'navbar')]"));
            assertTrue(navbar.isDisplayed(), "Header navigation bar should be visible.");

            // Locate action buttons: Login and Register
            WebElement loginButton = driver.findElement(By.xpath(
                    "//div[@id='navbar-collapse-header']//div[contains(@class, 'navbar-right')]//a[contains(@class, 'btn') and contains(text(), 'Login')]"));
            WebElement registerButton = driver.findElement(By.xpath(
                    "//div[@id='navbar-collapse-header']//div[contains(@class, 'navbar-right')]//a[contains(@class, 'btn') and contains(text(), 'Register')]"));

            // Verify visibility of action buttons
            assertTrue(loginButton.isDisplayed(), "Action button 'Login' should be visible.");
            assertTrue(registerButton.isDisplayed(), "Action button 'Register' should be visible.");

            // Verify horizontal left-to-right alignment
            int loginX = loginButton.getLocation().getX();
            int registerX = registerButton.getLocation().getX();
            assertTrue(loginX < registerX, "Login button should be positioned to the left of Register button.");

            // Verify vertical alignment between action buttons
            int loginY = loginButton.getLocation().getY();
            int registerY = registerButton.getLocation().getY();
            int yDifference = Math.abs(loginY - registerY);
            assertTrue(yDifference <= 10, "Action buttons Login and Register should be aligned on the same horizontal plane (diff: " + yDifference + "px).");

            // Verify alignment within the navbar bounds
            int navbarY = navbar.getLocation().getY();
            int navbarBottom = navbarY + navbar.getSize().getHeight();
            assertTrue(loginY >= navbarY && loginY < navbarBottom, "Login button should be aligned within the header navbar.");
            assertTrue(registerY >= navbarY && registerY < navbarBottom, "Register button should be aligned within the header navbar.");

        } finally {
            // Close browser
            driver.quit();
        }
    }
}
