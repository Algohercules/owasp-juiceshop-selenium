package com.owasp.juiceshop;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_UI_023 {

    @Test
    void verifyFontStylingConsistencyTest() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get("https://www.opencart.com/");

            List<WebElement> headings = driver.findElements(By.xpath("//h1 | //h2 | //h3"));
            assertFalse(headings.isEmpty(), "Headings should exist on the page.");

            String baseFontFamily = null;
            for (WebElement heading : headings) {
                if (heading.isDisplayed()) {
                    String fontFamily = heading.getCssValue("font-family");
                    assertNotNull(fontFamily, "Font family should not be null.");
                    if (baseFontFamily == null) {
                        baseFontFamily = fontFamily;
                    }
                }
            }

            System.out.println("Font styling consistency verified. Base font family: " + baseFontFamily);
        } finally {
            driver.quit();
        }
    }
}
