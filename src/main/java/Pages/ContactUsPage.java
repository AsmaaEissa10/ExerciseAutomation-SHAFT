package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class ContactUsPage {

    /****************************************************************************
     *  >>	Variables
     *****************************************************************************/
    private final SHAFT.GUI.WebDriver driver;
    /****************************************************************************
     *  >>	Constructor
     *****************************************************************************/
    public ContactUsPage (SHAFT.GUI.WebDriver driver){ this.driver =driver;}

    /****************************************************************************
     *  >>	Locators
     *****************************************************************************/
    private final   By Name = By.name("name");
    private final By Email = By.name("email");
    private final By Subject = By.name("subject");
    private final By Message = By.name("message");
    private final By UploadFileLocator = By.name("upload_file");
    private final By SubmitButton = By.xpath("//input[@name='submit']");

    /****************************************************************************
     *  >>	Keywords
     *****************************************************************************/
    /**
     * @param name     String Value From testDataFiles ContactUsTestData.json
     * @param email    String Value From testDataFiles ContactUsTestData.json
     * @param subject  String Value From testDataFiles ContactUsTestData.json
     * @param message  String Value From testDataFiles ContactUsTestData.json
     * @param FilePath String Value From testDataFiles profile.pdf
     * @return
     * a self-reference to be used to chain actions
     */
    public ContactUsPage Enter_name_email_subject_and_message(String name, String email, String subject, String message, String FilePath) {
        driver.element().type(Name, name);
        driver.element().type(Email, email);
        driver.element().type(Subject, subject);
        driver.element().type(Message, message);
        driver.element().typeFileLocationForUpload(UploadFileLocator, FilePath);
        return this;
    }

    /**
     * @return ContactUsPage2
     */
    public ContactUsPage2 ClickOnSubmit() {
        driver.browser().setWindowSize(1000 , 1000);
        driver.element().scrollToElement(SubmitButton).click(SubmitButton);
        driver.browser().maximizeWindow();
        return new ContactUsPage2(driver);
    }
}



