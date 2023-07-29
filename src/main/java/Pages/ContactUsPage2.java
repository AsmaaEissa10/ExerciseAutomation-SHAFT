package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class ContactUsPage2 {
    /****************************************************************************
     *  >>	Variables
     *****************************************************************************/
    private final SHAFT.GUI.WebDriver driver;

    /****************************************************************************
     *  >>	Constructor
     *****************************************************************************/
    public ContactUsPage2 (SHAFT.GUI.WebDriver driver){ this.driver =driver;}

    /****************************************************************************
     *  >>	Locators
     *****************************************************************************/
    public static By sucessMsg(){ return By.xpath("//div[@class='status alert alert-success']");}
    public static By homeBtn(){ return By.xpath("//a[@class='btn btn-success']");}

    /****************************************************************************
     *  >>	Keywords
     *****************************************************************************/

    /**
     * @return Home Page
     */
    public HomePage ClickOnHome(){
        driver.element().click(homeBtn());
    return new HomePage(driver);
    }
}
