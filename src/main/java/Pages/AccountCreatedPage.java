package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class AccountCreatedPage {
    /****************************************************************************
     *  >>	Variables
     *****************************************************************************/
    private final SHAFT.GUI.WebDriver driver;

    /****************************************************************************
     *  >>	Constructor
     *****************************************************************************/

    public AccountCreatedPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    /****************************************************************************
     *  >>	Locators
     *****************************************************************************/
    public static By AccountCreatedLocator() {return By.xpath("//b[contains(.,'Account Created')]");}
    public static By containBtn(){ return By.xpath("//a[contains(.,'Continue')]");}

    /****************************************************************************
     *  >>	Keywords
     *****************************************************************************/

    /**
     * @return Home Page
     */
    public HomePage ClickOnContainBtn() {
        driver.element().click(containBtn());
        return new HomePage(driver);
    }
}
