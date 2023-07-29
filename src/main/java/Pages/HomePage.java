package Pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class HomePage {
    /****************************************************************************
     *  >>	Variables
     *****************************************************************************/
    private final SHAFT.GUI.WebDriver driver;
    public String home_URL = System.getProperty("AutomationExerciseURL");

    /****************************************************************************
     *  >>	Constructor
     *****************************************************************************/
    public HomePage ( SHAFT.GUI.WebDriver driver){
        this.driver =driver;
    }

    /****************************************************************************
     *  >>	Locators
     *****************************************************************************/
    public static By excercise_logo(){return By.xpath("//*[@id=\"header\"]/div/div/div/div[1]/div/a/img");}
    public By signUpBtn  = By.xpath("//a[contains(.,'Signup / Login')]");
    public By productsBtn = By.xpath("//a[contains(.,'Products')]");
    public  By contactUsBtn = By.xpath("//a[contains(.,' Contact us')]");
    public  By cartBtn = By.xpath("//a[@href='/contact_us']");
    public static By LogOut(){return By.xpath("//a[contains(.,'Logout')]");}


    /****************************************************************************
     *  >>	Keywords
     *****************************************************************************/

    /**
     * Navigate to AutomationExercise home page URL.
     *
     * @return
     * a self-reference to be used to chain actions
     */
    @Step("Navigate to AutomationExercise homepage")
    public HomePage navigate() {
        driver.browser().navigateToURL(home_URL);
        return this;
    }
    /**
     * @return SignUp And login Page
     */
    public SignUpAndloginPage NavigateToSignUpOrLoginPage() {
        driver.element().click(signUpBtn);
        return new SignUpAndloginPage(driver);
    }
    /**
     * @return product Page
     */
    public ProductPage NavigateToProductPage() {
        driver.element().click(productsBtn);
        return new ProductPage(driver);
    }
    /**
     * @return ContactUs Page
     */
    public ContactUsPage NavigateToContactUsPage() {
        driver.element().click(contactUsBtn);
        return new ContactUsPage(driver);
    }
}
