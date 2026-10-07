package login_test;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_Login_016 {

    @Test
    void testCase() {

        WebDriver driver = new ChromeDriver();

        // Open Login page directly
        driver.get("https://demo.owasp-juice.shop/#/login");

        // Enter valid email
        driver.findElement(By.xpath("//input[@id='email']"))
                .sendKeys("test@example.com");

        // Enter a very long password
        driver.findElement(By.xpath("//input[@id='password']"))
                .sendKeys("ThisIsAVeryLongPassword1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz");

        System.out.println("Long password entered successfully.");
        driver.quit();
    }
}
