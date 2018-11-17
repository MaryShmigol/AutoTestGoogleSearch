package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class GoogleBasePage {
    WebDriver webDriver;

    //public GoogleBasePage(WebDriver webDriver){

        //this.webDriver = webDriver;
   // }

    public abstract boolean isPageLoaded();

    public WebElement waitUntilElementIsVisible (WebElement webElement, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(webDriver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(webElement));
        return webElement;
    }



}
