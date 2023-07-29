package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class SignUpAndloginPage {

    /****************************************************************************
     *  >>	Variables
     *****************************************************************************/
    private final SHAFT.GUI.WebDriver driver;

    /****************************************************************************
     *  >>	Locators
     *****************************************************************************/
    public static By NewUserSignupLocator() {
        return By.xpath("//h2[contains(.,'New User Signup!')]");
    }
    private final By nameField =  By.name("name");
    private final By emailAdressField = By.xpath("//*[@data-qa='signup-email']");
    private final By signUpBtn = By.xpath("//button[contains(.,'Signup')]");
    private final By SignInEmail = By.xpath("(//input[@type='email'])[1]");
    private final By password = By.name("password");
    private final By LoginButton = By.xpath("//button[contains(.,'Login')]");
    public static By account_infoLocator(){return By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/h2/b");};


    /****************************************************************************
     *  >>	Constructor
     *****************************************************************************/
    public SignUpAndloginPage (SHAFT.GUI.WebDriver driver){ this.driver =driver;}

    /****************************************************************************
     *  >>	Keywords
     *****************************************************************************/

    /**
     * @param name        String Value From testDataFiles signUpData.json
     * @param signupEmail String Value From testDataFiles signUpData.json
     * @return
     * a self-reference to be used to chain actions
     */
    public SignUpAndloginPage AddNewUserSignup (String name, String signupEmail) {
        driver.element().type(nameField, name);
        driver.element().type(emailAdressField , signupEmail);
        return this;
    }

    /**
     * @return SignUp Page
     */
    public SignUpPage ClickOnSignUpButton() {
        driver.element().click(signUpBtn);
       return new SignUpPage(driver);
    }
    /**
     * @param email    String Value From testDataFiles loginpData.json
     * @param Password String Value From testDataFiles loginData.json
     * @return
     * a self-reference to be used to chain actions
     */
    public SignUpAndloginPage LoginUsingValidNameAndPassword( String email, String Password) {
        driver.element().type(SignInEmail, email);
        driver.element().type(password, Password);
        return this;
    }

    /**
     * @return Home Page
     */
    public HomePage ClickOnLoginButton() {
        driver.element().click(LoginButton);
        return new HomePage(driver);
    }

}
