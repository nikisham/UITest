import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.concurrent.TimeUnit;

@DirtiesContext
@SpringBootTest
public class PageObject {


    protected WebDriver driver;


    public PageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUserName(String name){
        driver.findElement(By.id("index_email")).sendKeys("79992");
    }
    public void enterPass(String pass){
        driver.findElement(By.id("index_pass")).sendKeys("qwe123");
    }


    protected void browser() {
        driver.get("https://vk.com/");
    }

    protected void auth() {
        driver.findElement(By.id("index_login_button")).click();
    }

}
