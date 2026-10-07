package login_test;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_Login_027 {

    @Test
    void testCase() {

        WebDriver driver = new ChromeDriver();

        // Open Login page directly
        driver.get("https://demo.owasp-juice.shop/#/login");

        // Enter email without username
        driver.findElement(By.xpath("//input[@id='email']"))
                .sendKeys("@domain.com");

        // Enter valid password
        driver.findElement(By.xpath("//input[@id='password']"))
                .sendKeys("VALID_PASSWORD");

        System.out.println("Email without username entered.");
        driver.quit();
    }
}
