package tests;

import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    public SHAFT.GUI.WebDriver driver;
    @BeforeClass
    public void setup() {
        driver = new SHAFT.GUI.WebDriver();
    }
    @AfterClass
    public void TaerDown() {driver.browser().closeCurrentWindow();}


}
