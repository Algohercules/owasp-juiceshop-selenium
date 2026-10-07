package ui_test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_UI_004 {

    @Test
    void verifyNavigationLabelsTest() {

        // Open Chrome
        WebDriver driver = new ChromeDriver();

        try {
            // Maximize browser window to ensure header navigation is expanded
            driver.manage().window().maximize();

            // Navigate to OpenCart homepage
            driver.get("https://www.opencart.com/");

            // Navigation labels to verify
            String[] expectedLabels = {"Features", "Demo", "Marketplace", "Blog", "Download", "Resources"};

            for (String expectedLabel : expectedLabels) {
                // Locate navigation link element
                WebElement link = driver.findElement(By.xpath(
                        "//div[@id='navbar-collapse-header']//ul[contains(@class, 'navbar-nav')]//a[contains(text(), '" + expectedLabel + "')]"));

                // Verify label is visible
                assertTrue(link.isDisplayed(), "Navigation label '" + expectedLabel + "' should be visible.");

                // Verify label text
                String actualText = link.getText().trim();
                assertFalse(actualText.isEmpty(), "Navigation label for '" + expectedLabel + "' should not be empty.");
                assertTrue(actualText.equalsIgnoreCase(expectedLabel) || actualText.toLowerCase().contains(expectedLabel.toLowerCase()),
                        "Navigation link should display label '" + expectedLabel + "'. Actual: " + actualText);

                // Verify label is not truncated
                assertFalse(actualText.contains("...") || actualText.contains("…"),
                        "Navigation label '" + expectedLabel + "' should not be truncated with ellipsis.");
            }

        } finally {
            // Close browser
            driver.quit();
        }
    }
}
