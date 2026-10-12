package com.owasp.juiceshop;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_UI_011 {

    @Test
    void verifyDropdownMenuVisibilityTest() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get("https://www.opencart.com/");

            // Locate dropdown toggle link (Resources)
            WebElement dropdownToggle = driver.findElement(By.xpath("//div[@id='navbar-collapse-header']//a[contains(text(), 'Resources')]"));
            assertTrue(dropdownToggle.isDisplayed(), "Resources dropdown toggle should be visible.");

            dropdownToggle.click();

            WebElement dropdownMenu = driver.findElement(By.xpath("//div[@id='navbar-collapse-header']//li[contains(@class, 'dropdown')]//ul[contains(@class, 'dropdown-menu')] | //ul[contains(@class, 'dropdown-menu')]"));
            assertTrue(dropdownMenu.isDisplayed(), "Dropdown menu should open and be visible.");
            System.out.println("Dropdown menu visibility verified.");
        } finally {
            driver.quit();
        }
    }
}
