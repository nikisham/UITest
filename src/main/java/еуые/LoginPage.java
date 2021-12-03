package еуые;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    void enterUserName(String name) {
        driver.findElement(By.id("login")).sendKeys("admin");
    }

    void enterPassword(String pass) {
        driver.findElement(By.id("pass")).sendKeys("changeme");
    }

    void clickLogin() {

    }

    void open() {
        driver.get("https://lingualeo.com");
    }

    boolean atPage() {
        if (driver.getTitle().equals("Login to Lingua Leo")) {
            return true;
        } else {
            return false;
        }
    }

}
