package com.owasp.juiceshop;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_UI_013 {

    @Test
    void verifyProductImageRenderingTest() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get("https://www.opencart.com/");

            // Locate showcase or feature images
            List<WebElement> images = driver.findElements(By.xpath("//img"));
            assertTrue(!images.isEmpty(), "Images should be present on page.");

            boolean atLeastOneRendered = false;
            JavascriptExecutor js = (JavascriptExecutor) driver;
            for (WebElement img : images) {
                if (img.isDisplayed()) {
                    Boolean naturalWidth = (Boolean) js.executeScript(
                            "return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0;", img);
                    if (Boolean.TRUE.equals(naturalWidth)) {
                        atLeastOneRendered = true;
                        break;
                    }
                }
            }

            assertTrue(atLeastOneRendered, "Images should render without broken-image indicators.");
            System.out.println("Product/feature image rendering verified successfully.");
        } finally {
            driver.quit();
        }
    }
}
