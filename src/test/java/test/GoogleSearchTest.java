package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.GoogleSearchResultsFirstPage;
import page.GoogleSearchResultsSecondPage;
import java.util.List;

public class GoogleSearchTest extends GoogleBaseTest {
    /**
     * PreConditions:
     * open chrome and ff browser.
     * Scenario:
     * -navigate to https://www.google.com/
     * -verify that Login page is loaded
     * -enter search term, enter
     * -verify that first search page is loaded.
     * -found 10 block which have search term
     * -navigate to second page
     * -verify that first search page is loaded.
     * -found 10 block which have search term
     *PostCondition:
     * - Close browser.
     */
    @Test
    public void seleniumSearchTest(){
        String searchTerm = "Selenium";
        Assert.assertTrue(googleHomePage.isPageLoaded(), "Google page is not loaded");

        GoogleSearchResultsFirstPage googleSearchResultsFirstPage = googleHomePage.search(searchTerm);
        Assert.assertTrue(googleSearchResultsFirstPage.isPageLoaded(), "Page with search results is not loaded");

        List<String> searchResultsListFirstPage = googleSearchResultsFirstPage.getSearchResults();
        Assert.assertEquals(searchResultsListFirstPage.size(),9, "Count of search results is wrong");

        for(String searchResult :searchResultsListFirstPage){
            Assert.assertTrue(searchResult.toLowerCase().contains(searchTerm.toLowerCase()),
                    "SearchTerm  " + searchTerm + "was not found in: " + searchResult);


        GoogleSearchResultsSecondPage googleSearchResultsSecondPage = googleSearchResultsFirstPage.goToSecondPage();
        Assert.assertTrue(googleSearchResultsSecondPage.isPageLoaded(), "Second page with search results is not loaded");

        List<String> searchResultsListSecondPage = googleSearchResultsSecondPage.getSearchResults();
        Assert.assertEquals(searchResultsListSecondPage.size(), 9, "Count of search results is wrong");

            for (String searchResult2:searchResultsListSecondPage){
                Assert.assertTrue(searchResult2.toLowerCase().contains(searchTerm.toLowerCase()),
                        "Searchterm "+searchTerm+"was not found in: "+searchResult2);
        }

        }
    }
}
