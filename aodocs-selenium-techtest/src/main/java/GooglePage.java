import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GooglePage {
    WebDriver driver;

    public GooglePage(WebDriver driver) {
        this.driver = driver;
    }

    By searchField = By.cssSelector("input.gLFyf");
    By searchResult = By.cssSelector("a[href='https://www.aodocs.com/']");
    By acceptButton = By.cssSelector("div#introAgreeButton");

    public GooglePage search(String search) {
        driver.switchTo().frame(0);
        driver.findElement(acceptButton).click();
        driver.findElement(searchField).sendKeys(search);
        driver.findElement(searchField).sendKeys(Keys.ENTER);
        return this;
    }

    public void goToResult() {
        driver.findElement(searchResult).click();
    }
}
