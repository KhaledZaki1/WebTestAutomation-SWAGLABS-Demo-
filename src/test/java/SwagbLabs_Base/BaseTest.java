package SwagbLabs_Base;

import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    private WebDriver driver;
    protected LoginPage loginpage;
    protected HomePage homepage;

    @BeforeTest
    public void SetUp() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Thread.sleep(5000);
        loginpage = new LoginPage(driver);
        homepage = new HomePage(driver);
    }

    @AfterTest
    public void Quit(){
        driver.quit();
    }
}
