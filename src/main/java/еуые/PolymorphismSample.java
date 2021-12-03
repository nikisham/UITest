package еуые;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PolymorphismSample {

    private WebDriver driver;
    private LoginPage loginPage;


    @BeforeTest
    public void setUp(String browserName) {
        driver = new FirefoxDriver();
        loginPage = new LoginPage(driver);

    }

    @Test
    public void successfulLoginTest() {
        loginPage.open();
        assertTrue(loginPage.atPage());
        loginPage.enterUserName("admin");
        loginPage.enterPassword("changeme");
        loginPage.clickLogin();

    }

    @Test
    public void wrongPasswordLoginTest() {
        loginPage.open();
        assertTrue(loginPage.atPage());
        loginPage.enterUserName("admin");
        loginPage.enterPassword("wrongPassword");
        loginPage.clickLogin();
    }

    @Test
    public void wrongLoginNameLoginTest() {
        driver.get("https://lingualeo.com");
        driver.findElement(By.id("login")).sendKeys("wrongUserName");
        driver.findElement(By.id("pass")).sendKeys("changeme");
        assertEquals("Home Page", driver.getTitle());
    }

}