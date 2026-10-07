package login_test;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_Login_029 {

    @Test
    void testCase() {

        WebDriver driver = new ChromeDriver();

        // Open Login page directly
        driver.get("https://demo.owasp-juice.shop/#/login");

        // Enter email containing multiple @ symbols
        driver.findElement(By.xpath("//input[@id='email']"))
                .sendKeys("user@@domain.com");

        // Enter valid password
        driver.findElement(By.xpath("//input[@id='password']"))
                .sendKeys("VALID_PASSWORD");

        System.out.println("Email with multiple @ symbols entered.");
        driver.quit();
    }
}
