package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class GoogleSearchResultsSecondPage extends GoogleBasePage {

    @FindBy(id = "main")
    private WebElement searchResultsFrame;

    @FindBy(xpath = "//div[@class='srg']")
    private WebElement searchResults;

    @FindBy(xpath = "//div[@class='srg']/div[@class='g']")
    private List<WebElement> searchResultElements;

    public GoogleSearchResultsSecondPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public boolean isPageLoaded(){
        return searchResultsFrame.isDisplayed();
    }

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
