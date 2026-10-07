package login_test;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_Login_014 {

    @Test
    void testCase() {

        WebDriver driver = new ChromeDriver();

        // Open Login page directly
        driver.get("https://demo.owasp-juice.shop/#/login");

        // Enter valid email
        driver.findElement(By.xpath("//input[@id='email']"))
                .sendKeys("test@example.com");

        // Enter password containing only spaces
        driver.findElement(By.xpath("//input[@id='password']"))
                .sendKeys("     ");

        System.out.println("Password containing only spaces entered.");
        driver.quit();
    }
}
