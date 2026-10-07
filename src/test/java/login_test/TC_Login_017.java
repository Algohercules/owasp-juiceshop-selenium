package login_test;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_Login_017 {

    @Test
    void testCase() {

        WebDriver driver = new ChromeDriver();

        // Open Login page directly
        driver.get("https://demo.owasp-juice.shop/#/login");

        // Enter password
        driver.findElement(By.xpath("//input[@id='password']"))
                .sendKeys("TestPassword123");

        // Check password field type
        String fieldType = driver.findElement(By.xpath("//input[@id='password']"))
                .getAttribute("type");

        System.out.println("Password field type: " + fieldType);
        driver.quit();
    }
}
