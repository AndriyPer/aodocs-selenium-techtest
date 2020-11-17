import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import selenium.driver.Browser;
import selenium.driver.WebDriverUtility;

public class MainTest {
    WebDriver driver;
    GooglePage google;
    AodocsBasePage mainPage;
    AodocsFormPage formPage;

    @Before
    public void setDriver() {
        System.setProperty("webdriver.chromedriver", "C:\\Users\\andrey\\IdeaProjects\\aodocs-selenium-techtest\\exe\\chromedriver.exe");
        driver = WebDriverUtility.getWebDriver(Browser.CHROME);
        driver.get("https://www.google.com/");

    }

    @Test
    public void mainTest() {
        google = new GooglePage(driver);
        mainPage=new AodocsBasePage(driver);
        formPage=new AodocsFormPage(driver);

        google.search("AODocs");
        google.goToResult();
        mainPage.requestDemo();
        formPage.typeFirstName("Andriy");
        formPage.typeEmail(15);
        formPage.setCompanySize("5-50 employees");
        formPage.clickSubmitButton();

        Assertions.assertTrue(formPage.isErrorsVisible());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
