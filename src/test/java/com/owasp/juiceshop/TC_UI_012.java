package com.owasp.juiceshop;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_UI_012 {

    @Test
    void verifyDropdownOptionAlignmentTest() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get("https://www.opencart.com/");

            WebElement dropdownToggle = driver.findElement(By.xpath("//div[@id='navbar-collapse-header']//a[contains(text(), 'Resources')]"));
            dropdownToggle.click();

            List<WebElement> options = driver.findElements(By.xpath("//div[@id='navbar-collapse-header']//ul[contains(@class, 'dropdown-menu')]//li/a"));
            assertFalse(options.isEmpty(), "Dropdown options should be present.");

            int firstX = options.get(0).getLocation().getX();
            for (WebElement option : options) {
                if (option.isDisplayed()) {
                    int optX = option.getLocation().getX();
                    assertTrue(Math.abs(optX - firstX) <= 15, "Dropdown option should be properly aligned with other options.");
                }
            }
            System.out.println("Dropdown option alignment verified across " + options.size() + " options.");
        } finally {
            driver.quit();
        }
    }
}
