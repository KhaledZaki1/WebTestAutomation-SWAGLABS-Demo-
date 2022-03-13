package DropDown;

import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class FilterOption {

    private WebDriver driver;

    private By SelectFilterOption = By.className("product_sort_container");
    private By LogOutButton = By.id("logout_sidebar_link");

    public FilterOption (WebDriver driver){
        this.driver=driver;
    }

    public void Filter(String option){
        Select SearchByFilter = new Select(driver.findElement(SelectFilterOption));
        SearchByFilter.selectByVisibleText(option);
    }

    public List<String> GetFilterOption(){
        Select getoption = new Select(driver.findElement(SelectFilterOption));
        List<WebElement> getelement = getoption.getAllSelectedOptions();
        return getelement.stream().map(e->e.getText()).collect(Collectors.toList());
    }

    public LoginPage ClickLogOutButton(){
        driver.findElement(LogOutButton).click();
        return new LoginPage(driver);
    }
}
