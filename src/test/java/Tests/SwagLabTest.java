package Tests;

import DropDown.FilterOption;
import Pages.CartPage;
import Pages.CheckOutPage;
import Pages.OverViewPage;
import Pages.ThankYouPage;
import SwagbLabs_Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SwagLabTest extends BaseTest {

    @Test
    public void ProjectTest(){

        //Invalid Login Credential(Username)--------------------
        loginpage.UserName("Khaled_Hamdy");
        loginpage.Password("secret_sauce");
        loginpage.ClickLoginButton();
        String errortext = loginpage.geterrormsg();
        assertEquals(errortext,"Epic sadface: Username and password do not match any user in this service",
                "The user will be redirected to the HomePage ");

        //Inserting the valid username
        loginpage.WrongUserName("standard_user");
        loginpage.ClickLoginButton();


       //DropdownTests------------------------
       FilterOption Filterss = homepage.clickfilter();
       Filterss.Filter("Price (low to high)");
       assertEquals(Filterss.GetFilterOption().size(),1, "option in sot selected");
       assertTrue(Filterss.GetFilterOption().contains("Price (low to high)"),"Option is not selected");


        //ShoppingCart-------------------------
        homepage.SelectProduct1();
        homepage.SelectProduct2();

        //ClickShoppingCart--------------------
        CartPage cartpage = homepage.ClickAddToCart();
        cartpage.Remove();
        cartpage.ContinueButton();
        homepage.SelectProduct3();
        homepage.ClickAddToCart();
        CheckOutPage checkoutpage = cartpage.Check();

        //checkoutpage Credentials-------------
        checkoutpage.firstname("Admin");
        checkoutpage.lastname("User");
        checkoutpage.postalcode("121212");
        OverViewPage overviewpage = checkoutpage.clickcontinue();

        //FinishButton
        String item1Price = overviewpage.getItem1Price();
        String item2Price = overviewpage.getItem2Price();
        String actualTotalPrice = overviewpage.getActualTotalPrice();
        // remove the $ sign
        String newItem1Price  = overviewpage.removeFirstChar(item1Price);
        String newItem2Price  = overviewpage.removeFirstChar(item2Price);
        String newActualTotalPrice  = overviewpage.removeString(actualTotalPrice);

        double expectedTotalPrice = Double.parseDouble(newItem1Price) + Double.parseDouble(newItem2Price);

        System.out.println("The Expected Price is: " + expectedTotalPrice);
        System.out.println("The Actual Price is: " + newActualTotalPrice);
        //System.out.println("The Expected Price is: " + expectedTotalPrice);

        Assert.assertEquals(Double.toString(expectedTotalPrice), newActualTotalPrice
                , "The actual total price and the expected total price are not the same");

        ThankYouPage thankyoupage = overviewpage.finishbutton();


        //ThankYouPage-------------------------
        assertTrue(thankyoupage.AlertMessage1().contains("THANK YOU FOR YOUR ORDER")
                ,"Alert Message1 is incorrect");
        assertTrue(thankyoupage.AlertMessage2().contains("Your order has been dispatched, and will arrive just as fast as the pony can get there!")
                ,"Alert Message2 is incorrect");
        thankyoupage.BackButton();

        //ByeBye Button------------------------
        FilterOption sidelistmenu = homepage.hamburgerdropdown();
        sidelistmenu.ClickLogOutButton();
    }


}
