package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class ProductDetails {
    /****************************************************************************
     *  >>	Variables
     *****************************************************************************/
    private final SHAFT.GUI.WebDriver driver;
    /****************************************************************************
     *  >>	Constructor
     *****************************************************************************/
    public ProductDetails(SHAFT.GUI.WebDriver driver) { this.driver = driver;}

    /****************************************************************************
     *  >>	Locators
     *****************************************************************************/
    public final By addToCART = By.xpath("//button[contains(.,'Add to cart')]");
    public final By viewCART = By.xpath("//*[@id='cartModal']/div/div/div[2]/p[2]/a/u");
    public static By successMsg(){return By.xpath("//*[@id='cartModal']/div/div/div[1]/h4");}

    /****************************************************************************
     *  >>	Keywords
     *****************************************************************************/

    /**
     * click on AddToCart
     * @return
     * a self-reference to be used to chain actions
     */
    public ProductDetails ClickOnAddToCart(){
        driver.element().click(addToCART);
        return this;
    }
    /**
     * click on view cart
     * @return
     * ShoppingCartPage
     */
    public ShoppingCartPage ClickOnviewCartBtn(){
        driver.element().click(viewCART);
        return new ShoppingCartPage(driver);
    }
}
