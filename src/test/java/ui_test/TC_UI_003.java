package com.owasp.juiceshop;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_UI_003 {

    @Test
    void verifyHeaderElementAlignmentTest() {

        // Open Chrome
        WebDriver driver = new ChromeDriver();

        try {
            // Maximize browser window to ensure desktop header layout
            driver.manage().window().maximize();

            // Navigate to OpenCart homepage
            driver.get("https://www.opencart.com/");

            // Locate header container
            WebElement navbar = driver.findElement(By.xpath("//nav[contains(@class, 'navbar')]"));
            assertTrue(navbar.isDisplayed(), "Header navigation bar container should be visible.");

            // Locate header elements: Logo, navigation menu, and action buttons section
            WebElement logo = driver.findElement(By.xpath("//a[@class='navbar-brand']"));
            WebElement navMenu = driver.findElement(By.xpath("//div[@id='navbar-collapse-header']//ul[contains(@class, 'navbar-nav')]"));
            WebElement rightActions = driver.findElement(By.xpath("//div[@id='navbar-collapse-header']//div[contains(@class, 'navbar-right')]"));

            // Verify visibility of all header elements
            assertTrue(logo.isDisplayed(), "Header logo should be visible.");
            assertTrue(navMenu.isDisplayed(), "Header navigation menu should be visible.");
            assertTrue(rightActions.isDisplayed(), "Header right actions should be visible.");

            // Verify horizontal left-to-right alignment (Logo -> Navigation Menu -> Action Buttons)
            int logoX = logo.getLocation().getX();
            int navMenuX = navMenu.getLocation().getX();
            int rightActionsX = rightActions.getLocation().getX();

            assertTrue(logoX < navMenuX, "Header logo should be positioned to the left of the navigation menu.");
            assertTrue(navMenuX < rightActionsX, "Navigation menu should be positioned to the left of the action buttons.");

            // Verify vertical alignment within header bounds
            int navbarY = navbar.getLocation().getY();
            int navbarBottom = navbarY + navbar.getSize().getHeight();

            int logoY = logo.getLocation().getY();
            int navY = navMenu.getLocation().getY();
            int rightY = rightActions.getLocation().getY();

            assertTrue(logoY >= navbarY && logoY < navbarBottom, "Logo should be aligned within the header navigation bar.");
            assertTrue(navY >= navbarY && navY < navbarBottom, "Navigation menu should be aligned within the header navigation bar.");
            assertTrue(rightY >= navbarY && rightY < navbarBottom, "Right action buttons should be aligned within the header navigation bar.");

        } finally {
            // Close browser
            driver.quit();
        }
    }
}
