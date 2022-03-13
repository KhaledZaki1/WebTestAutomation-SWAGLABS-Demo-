package Pages;

import DropDown.FilterOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage {
    private WebDriver driver;

    //Product's Field
    private By OnesieProduct = By.id("add-to-cart-sauce-labs-onesie");
    private By BikeLightProduct = By.id("add-to-cart-sauce-labs-bike-light");
    private By BackPackProduct = By.id("add-to-cart-sauce-labs-backpack");

    //ShoppingCartLink
    private By ShoppingCart = By.className("shopping_cart_link");

    //Hamburger Button to logout
    private By HamburgerButton = By.id("react-burger-menu-btn");

    public HomePage (WebDriver driver){
        
        this.driver=driver;
    }
    public FilterOption clickfilter (){
        driver.findElement(By.className("product_sort_container")).click();
        return new FilterOption(driver);
    }
    //Product's methods
    public void SelectProduct1 (){
        driver.findElement(OnesieProduct).click();
    }

    public void SelectProduct2 (){
        driver.findElement(BikeLightProduct).click();
    }

    public void SelectProduct3(){
        driver.findElement(BackPackProduct).click();
    }

    //ShoppingCart Method
    public CartPage ClickAddToCart (){
        driver.findElement(ShoppingCart).click();
        return new CartPage (driver);
    }

    //HamburgerButton Method
    public FilterOption hamburgerdropdown(){
        driver.findElement(HamburgerButton).click();
        return new FilterOption(driver);
    }

}
