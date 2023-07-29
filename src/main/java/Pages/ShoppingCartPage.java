package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class ShoppingCartPage {

    /****************************************************************************
     *  >>	Variables
     *****************************************************************************/
    private final SHAFT.GUI.WebDriver driver;

    /****************************************************************************
     *  >>	Constructor
     *****************************************************************************/
    public ShoppingCartPage(SHAFT.GUI.WebDriver driver) { this.driver = driver;}

    /****************************************************************************
     *  >>	Locators
     *****************************************************************************/
    private final By checkOutBtn = By.linkText("Proceed To Checkout");

    /****************************************************************************
     *  >>	Keywords
     *****************************************************************************/
    /**
     * @return CheckOut Page
     */
    public CheckOutPage ClickOnCheckOutBtn(){
        driver.element().click(checkOutBtn);
        return new CheckOutPage(driver);
    }
}
