package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OverViewPage {

    private WebDriver driver;

    //Price Field
    private By Price = By.className("inventory_item_price");

    //OverViewPage Field
    private By FinishButton = By.id("finish");

    // items prices
    private By Item1 = By.xpath("//div[@class='inventory_item_price'][normalize-space()='$7.99']");
    private By Item2 = By.xpath("//div[@class='inventory_item_price'][normalize-space()='$29.99']");
    private  By actualTotalPrice = By.xpath("//div[contains(@class,'summary_subtotal_label')]");

    public String getItem1Price(){
        return driver.findElement(Item1).getText();
    }
    public String getItem2Price(){
            return driver.findElement(Item2).getText();
    }
    public String getActualTotalPrice(){
        return driver.findElement(actualTotalPrice).getText();
    }
    public OverViewPage(WebDriver driver){
        this.driver=driver;
    }

    //OverViewPage Method
    public ThankYouPage finishbutton(){
        driver.findElement(FinishButton).click();
        return new ThankYouPage (driver);
    }

    // Helper method (To remove the $ Sign)
    public String removeFirstChar (String str){
        StringBuffer sb = new StringBuffer(str);
        sb.delete(0,1);
        return  sb.toString();
    }
    // Helper method (To remove the $ Sign from the actual total price)
    public String removeString( String str){
        StringBuffer sb = new StringBuffer(str);
        sb.delete(0,13);
        return  sb.toString();

    }
}
