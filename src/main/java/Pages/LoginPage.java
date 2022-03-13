package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver driver;

    //LoginPage Fields
    private By SetUserNameField = By.id("user-name");
    private By SetPasswordField = By.cssSelector("#password");
    private By LoginButton = By.id("login-button");

    public LoginPage(WebDriver driver){
        this.driver=driver;
    }
    //LoginPage Methods
    public void UserName (String username){
        driver.findElement(SetUserNameField).sendKeys(username);
    }

    // remove the wrong username and enter the valid one Method
    public void WrongUserName(String validusername){
        driver.findElement(SetUserNameField).clear();
        driver.findElement(SetUserNameField).sendKeys(validusername);
    }
    public void Password (String password){
        driver.findElement(SetPasswordField).sendKeys(password);
    }
    public HomePage ClickLoginButton (){
        driver.findElement(LoginButton).click();
        return new HomePage(driver);
    }
    // The validation Error method
    public String geterrormsg(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='error-message-container error']"))));
        return driver.findElement(By.xpath("//div[@class='error-message-container error']")).getText();

    }


}
