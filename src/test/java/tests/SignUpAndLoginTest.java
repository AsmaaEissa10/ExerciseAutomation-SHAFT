package tests;

import Pages.AccountCreatedPage;
import Pages.HomePage;
import Pages.SignUpAndloginPage;
import Pages.SignUpPage;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Validations;
import io.qameta.allure.*;
import org.testng.annotations.Test;
@Epic("Automation Exercise")
@Feature("SignUp And Login Test")
public class SignUpAndLoginTest extends BaseTest {
    String currentTime = String.valueOf(System.currentTimeMillis());
    public JSONFileManager RegisterTestData = new JSONFileManager(System.getProperty("SignUpTestData"));
    public JSONFileManager AccountTestData = new JSONFileManager(System.getProperty("AccountDetailsTestData"));

    @Description("Given the browser is open, When i navigate to Automation Exercise URl,Then Home page is visible successfully ")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Open Home page")
    @Test(priority = 1,  description = "Verify that home page is visible successfully")
    public void Verify_that_home_page_is_visible_successfully() {

        new HomePage(driver)
                .navigate();
        driver.assertThat()
                .element(HomePage.excercise_logo())
                .isVisible()
                .withCustomReportMessage("Verify that home page is visible successfully")
                .perform();
    }

    @Description("Given the browser is open, When i navigate to Automation Exercise URl,And Click On Signup Button, Then Navigate to SignUp And login Page")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Register User with valid data")
    @Test(priority = 1,description = "Verify the user Can Sign UP via name and email.")
    public void Verify_the_user_can_signUp_via_name_and_email() {

        new HomePage(driver)
                .navigate()
                .NavigateToSignUpOrLoginPage();

        driver.assertThat().element(SignUpAndloginPage.NewUserSignupLocator())
                .isVisible()
                .withCustomReportMessage("Error Sign Up")
                .perform();

        new SignUpAndloginPage(driver)
                .AddNewUserSignup(RegisterTestData.getTestData("name"),
                        RegisterTestData.getTestData("SignUpEmail") + currentTime + "@gmail.com")
                    .ClickOnSignUpButton();

        driver.assertThat().element(SignUpAndloginPage.account_infoLocator())
                .isVisible()
                .withCustomReportMessage("Error Sign Up")
                .perform();
    }
    @Description("Fill Account Details, And Click On Create Account Button,Then Navigate To Account Created Page and Verify the account created")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Login user with valid data")
    @Test(priority =3, description = "Verify that 'ACCOUNT CREATED!' is visible")
    public void Verify_the_account_created() {
          new SignUpPage (driver)
                .FillInfoToMakeAccount(
                        AccountTestData.getTestData("Name"),
                        AccountTestData.getTestData("Password"),
                        Integer.parseInt(AccountTestData.getTestData("Day")),
                        AccountTestData.getTestData("Month"),
                        Integer.parseInt(AccountTestData.getTestData("Year")),
                        AccountTestData.getTestData("FirstName"),
                        AccountTestData.getTestData("LastName"),
                        AccountTestData.getTestData("Company"),
                        AccountTestData.getTestData("Address1"),
                        AccountTestData.getTestData("Address2"),
                        AccountTestData.getTestData("Country"),
                        AccountTestData.getTestData("State"),
                        AccountTestData.getTestData("City"),
                        Integer.parseInt(AccountTestData.getTestData("Zipcode")),
                        Integer.parseInt(AccountTestData.getTestData("MobileNumber")))
                .ClickOnCreateAccountButton();
        driver.assertThat()
                .element(AccountCreatedPage.AccountCreatedLocator())
                .isVisible()
                .withCustomReportMessage("Verify that 'ACCOUNT CREATED!' is visible")
                .perform();
        new AccountCreatedPage(driver)
                .ClickOnContainBtn();
    }
}


