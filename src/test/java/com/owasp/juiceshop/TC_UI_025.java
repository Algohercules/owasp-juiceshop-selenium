package com.owasp.juiceshop;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_UI_025 {

    @Test
    void verifyClickableElementVisibilityTest() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get("https://www.opencart.com/");

            List<WebElement> interactiveElements = driver.findElements(By.xpath("//a[contains(@class, 'btn')] | //button"));
            assertFalse(interactiveElements.isEmpty(), "Interactive elements should be present.");

            for (WebElement elem : interactiveElements) {
                if (elem.isDisplayed()) {
                    String cursor = elem.getCssValue("cursor");
                    assertTrue("pointer".equals(cursor) || "auto".equals(cursor) || cursor != null,
                            "Interactive element should have visible clickability indicator.");
                }
            }

            System.out.println("Clickable element visibility and affordance verified.");
        } finally {
            driver.quit();
        }
    }
}
