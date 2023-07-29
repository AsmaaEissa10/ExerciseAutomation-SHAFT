package tests;

import Pages.ContactUsPage2;
import Pages.HomePage;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Validations;
import io.qameta.allure.*;
import org.testng.annotations.Test;

@Epic("Automation Exercise")
@Feature("Contact Us Test")
public class ContactUsTest extends BaseTest {
    public JSONFileManager ContactUsData = new JSONFileManager (System.getProperty("ContactUsTestData"));
    @Description("Given the browser is open, When i navigate to Automation Exercise URl, And Click On Contact Us Button, And Enter,name,email,subject,and,message," +
            "And Click On Submit, Then navigate to ContactUsPage ")
    @Severity(SeverityLevel.CRITICAL)
    @Story("ContactUs with valid data")
    @Test(description = "Contact Us Form Verify success message 'Success' details have been submitted successfully. ")
    public void Verify_the_user_can_ContactUs(){
        new HomePage(driver)
                .navigate()
                .NavigateToContactUsPage()
                .Enter_name_email_subject_and_message(ContactUsData.getTestData( "Name"),
                        ContactUsData.getTestData(  "Email"),
                        ContactUsData.getTestData("Subject"),
                        ContactUsData.getTestData(  "Message"),
                        ContactUsData.getTestData( "filePath"))
                .ClickOnSubmit();

        driver.assertThat()
                .element(ContactUsPage2.sucessMsg())
                .text()
                .contains("Success! Your details have been submitted successfully.")
                .withCustomReportMessage("Error Contact Us")
                .perform();

        new ContactUsPage2(driver)
                .ClickOnHome();
    }
}
