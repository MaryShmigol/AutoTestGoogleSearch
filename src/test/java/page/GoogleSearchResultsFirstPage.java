package page;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;


public class GoogleSearchResultsFirstPage extends GoogleBasePage{

    @FindBy(xpath = "//div[@class='med']")
    private WebElement searchResultsFrame;

    @FindBy(xpath = "//div[@class='srg']")
    private WebElement searchResults;

    @FindBy(xpath = "//div[@class='srg']/div[@class='g']")
    private List<WebElement> searchResultElements;

    @FindBy(xpath = "//span[@class='csb']")
    private WebElement searchPageTwo;


    /**
     * Constructor
     * @param webDriver  web driver
     */
    public GoogleSearchResultsFirstPage(WebDriver webDriver) {
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
     * @return - list of text elements from search results
     */
    public List<String> getSearchResults(){
        List<String> searchResultsList = new ArrayList();
        for (WebElement searchResultElement : searchResultElements){
            ((JavascriptExecutor)webDriver)
                    .executeScript("arguments[0].scrollIntoView();", searchResultElement);
            String searchResultText = searchResultElement.getText();
            searchResultsList.add(searchResultText);
        }
        return searchResultsList;
    }

    /**
     * Method which navigate to second page of search test
     * @return -return new page which we search term
     */
    public GoogleSearchResultsSecondPage goToSecondPage()  {
        waitUntilElementIsClickable(searchPageTwo, 5);
        searchPageTwo.click();
        return new GoogleSearchResultsSecondPage(webDriver);
    }


}
