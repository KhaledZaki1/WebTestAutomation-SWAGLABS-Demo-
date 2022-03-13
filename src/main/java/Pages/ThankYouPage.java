package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ThankYouPage {

    private WebDriver driver;

    //ThankYouPage Field
    private By AlertMsg1 = By.className("complete-header");
    private By AlertMsg2 = By.className("complete-text");
    private By BackHomeButton = By.id("back-to-products");

    public ThankYouPage(WebDriver driver){
        this.driver=driver;
    }

    public String AlertMessage1 (){
        return driver.findElement(AlertMsg1).getText();
    }
    public String AlertMessage2(){
       return driver.findElement(AlertMsg2).getText();
    }
    public HomePage BackButton(){
        driver.findElement(BackHomeButton).click();
        return new HomePage(driver);
    }
}
