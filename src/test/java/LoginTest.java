import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class LoginTest extends Constants{
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(SITE_HOME_PAGE);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void testLogin(){
        new LoginPage(driver).login(USER_PHONE_NUMBER,USER_PASSWORD);
    }

    @Test
    public void wrongpass(){
        new LoginPage(driver).reg();

    }
    @Test
    public void switchLanguage(){
        new LoginPage(driver).swith();
    }
    @Test
    public void searches(){
        new LoginPage(driver).search(SEARCH);
    }
    @Test
    public void searches2(){
        new LoginPage(driver).backbutton(SEARCH2);
    }

}
