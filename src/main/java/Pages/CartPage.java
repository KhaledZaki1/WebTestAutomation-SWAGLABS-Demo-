package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private WebDriver driver;

    //CartPage Fields
    private By RemoveProductButton = By.id("remove-sauce-labs-bike-light");
    private By ContinueShoppingButton = By.id("continue-shopping");
    private By CheckOutButton = By.id("checkout");

    public CartPage(WebDriver driver){
        this.driver=driver;
        }
    //CartPage Methods
    public void Remove(){
        driver.findElement(RemoveProductButton).click();
    }
    public HomePage ContinueButton(){
        driver.findElement(ContinueShoppingButton).click();
        return new HomePage(driver);
    }
    public CheckOutPage Check(){
        driver.findElement(CheckOutButton).click();
        return new CheckOutPage (driver);
    }
}