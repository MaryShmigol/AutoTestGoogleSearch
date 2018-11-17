package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;

public class GoogleSearchResultsSecondPage extends GoogleBasePage {

    @FindBy(xpath = "//div[@id='res']")
    private WebElement searchResultsFrame;

    @FindBy(xpath = "//div[@class='srg']")
    private WebElement searchResults;

    @FindBy(xpath = "//div[@class='srg']/div[@class='g']")
    private List<WebElement> searchResultElements;

    /**
     * Constructor
     * @param webDriver - web driver
     */
    public GoogleSearchResultsSecondPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Method which test is page loaded or not
     * @return - return element in display
     */
    public boolean isPageLoaded(){
        return searchResultsFrame.isDisplayed();
    }

    /**
     * Method which get list of search term list of web elements
     * @return return new page which we search term
     */
    public List<String> getSearchResults(){
        List<String> searchResultsList = new ArrayList();
        for (WebElement searchResultElement : searchResultElements){
            ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();", searchResultElement);
            String searchResultText = searchResultElement.getText();
            searchResultsList.add(searchResultText);
        }
        return searchResultsList;
    }


}
