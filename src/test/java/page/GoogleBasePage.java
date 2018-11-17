package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class GoogleBasePage {
    WebDriver webDriver;

    /**
     * Method which test is page loaded or not in each Page Object
     * @return return visible element
     */
    public abstract boolean isPageLoaded();

    /**
     * Method which wait until element will bi clickable
     * @param webElement element web page
     * @param timeOutInSeconds - time out in second time
     * @return - return element of page
     */

    public WebElement waitUntilElementIsClickable (WebElement webElement, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(webDriver, timeOutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        return webElement;
    }



}
