import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    private static final By MAIN_FEED = By.xpath("//*[@id='main_feed']");
    private static final By PHONE_EMAIL = By.cssSelector("#index_email");
    private static final By PASSWORD = By.id("index_pass");
    private static final By LOGIN_BUTTON = By.className("index_login_button");
    private static final By WRONGPASS = By.id("index_forgot");
    private static final By ENGLISH = By.className("top_nav_link");
    private static final By SEARCH = By.id("ts_input");
    private static final By HOMEBUTTON = By.className("TopHomeLink");

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void login(String number, String password){
        driver.findElement(PHONE_EMAIL).sendKeys(number);
        driver.findElement(PASSWORD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        new WebDriverWait(driver, 18).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(MAIN_FEED));
    }
    public void reg(){
        driver.findElement(WRONGPASS).click();

    }
    public void swith(){
        driver.findElement(ENGLISH).click();
    }
    public void search(String search1){
        driver.findElement(SEARCH).sendKeys(search1);
        driver.findElement(SEARCH).sendKeys(Keys.ENTER);

    }
    public void backbutton(String search2){
        driver.findElement(SEARCH).sendKeys(search2);
        driver.findElement(SEARCH).sendKeys(Keys.ENTER);
        try{
            Thread.sleep(5000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(HOMEBUTTON).click();

    }

}
