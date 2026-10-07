package login_test;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_Login_024 {

    @Test
    void testCase() {

        WebDriver driver = new ChromeDriver();

        // Open Login page directly
        driver.get("https://demo.owasp-juice.shop/#/login");

        // Click registration link
        driver.findElement(By.xpath("//a[contains(@href,'register')]"))
                .click();

        System.out.println("Current URL: " + driver.getCurrentUrl());
        driver.quit();
    }
}
