import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class AodocsFormPage {
    WebDriver driver;

    public AodocsFormPage(WebDriver driver) {
        this.driver = driver;
    }

    By firstName = By.cssSelector("input[id*=firstname]");
    By email = By.cssSelector("input[id*=email]");
    By companySizeDropdown = By.cssSelector("select[id*=company_size]");
    String companySizeDropdownOption = "//select[contains(@id,'company_size')]/option[text()='%s']";
    By submitButton = By.cssSelector("input[type='submit']");
    By notifDismissButton = By.cssSelector("button#ccc-notify-dismiss");
    By errorMsg = By.cssSelector("label.hs-error-msg");

    public AodocsFormPage typeFirstName(String name) {
        driver.findElement(firstName).sendKeys(name);
        return this;
    }

    public AodocsFormPage typeEmail(int length) {
        driver.findElement(email).sendKeys(RandomStringUtils.randomAlphanumeric(length));
        return this;
    }

    public AodocsFormPage setCompanySize(String size) {
        driver.findElement(companySizeDropdown).click();
        new WebDriverWait(driver, 5).until(visibilityOfElementLocated(By.xpath(String.format(companySizeDropdownOption, size)))).click();
        return this;
    }

    public void clickSubmitButton() {
        driver.findElement(notifDismissButton).click();
        driver.findElement(submitButton).click();
    }

    public boolean isErrorsVisible() {
        return driver.findElements(errorMsg).size() > 0;
    }
}
