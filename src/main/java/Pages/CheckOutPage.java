package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class CheckOutPage {

    /****************************************************************************
     *  >>	Variables
     *****************************************************************************/
    private final SHAFT.GUI.WebDriver driver;
    /****************************************************************************
     *  >>	Constructor
     *****************************************************************************/
    public CheckOutPage(SHAFT.GUI.WebDriver driver) { this.driver = driver;}

    /****************************************************************************
     *  >>	Locators
     *****************************************************************************/
    private final By addComment = By.xpath("//div[@class='form-group']//textarea");
    private final By placeHolder = By.linkText("Place Order");

    /****************************************************************************
     *  >>	Keywords
     *****************************************************************************/

    /**
     * type comment in textarea
     * @return
     * a self-reference to be used to chain actions
     */
    public CheckOutPage AddComment(String text) {
        driver.element().type(addComment, text);
        return this;
    }

    /**
     * @return Payment Page
     */
    public PaymentPage clickOnPlaceholder(){
        driver.element().click(placeHolder);
        return new PaymentPage(driver);
    }
}
