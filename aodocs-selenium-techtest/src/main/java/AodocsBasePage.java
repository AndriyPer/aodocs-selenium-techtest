import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class AodocsBasePage {
    WebDriver driver;

    public AodocsBasePage(WebDriver driver) {
        this.driver = driver;
    }

    By demoButton = By.xpath("//div[@class='hs-u-padding-t-20']/a");

    public void requestDemo() {
        new WebDriverWait(driver, 10).until(visibilityOfElementLocated(demoButton)).click();
    }
}
