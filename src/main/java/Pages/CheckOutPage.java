package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage {

    private WebDriver driver;

    //CheckOutPage Fields
    private By FirstNameField = By.id("first-name");
    private By LastNameField = By.id("last-name");
    private By PostalCodeField = By.id("postal-code");
    private By ContinueButton = By.id("continue");

    public CheckOutPage (WebDriver driver){
        this.driver=driver;
    }

    //CheckOutPage Methods
    public void firstname (String fname){
        driver.findElement(FirstNameField).sendKeys(fname);
    }
    public void lastname (String lname){
        driver.findElement(LastNameField).sendKeys(lname);
    }
    public void postalcode (String zipcode){
        driver.findElement(PostalCodeField).sendKeys(zipcode);
    }
    public OverViewPage clickcontinue (){
        driver.findElement(ContinueButton).click();
        return new OverViewPage (driver);
    }

}
