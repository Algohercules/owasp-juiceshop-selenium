package login_test;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_Login_020 {

    @Test
    void testCase() {

        WebDriver driver = new ChromeDriver();

        // Open Login page directly
        driver.get("https://demo.owasp-juice.shop/#/login");

        // Enter only password
        driver.findElement(By.xpath("//input[@id='password']"))
                .sendKeys("TestPassword123");

        // Check Login button
        boolean enabled = driver.findElement(By.xpath("//button[@id='loginButton']"))
                .isEnabled();

        System.out.println("Login button enabled with only password: " + enabled);
        driver.quit();
    }
}
