package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.GoogleSearchResultsFirstPage;
import page.GoogleSearchResultsSecondPage;

import java.util.List;

public class GoogleSearchTest extends GoogleBaseTest {
    @Test
    public void seleniumSearchTest(){
        String searchTerm = "Selenium";
        Assert.assertTrue(googleHomePage.isPageLoaded(), "Google page is not loaded");

        GoogleSearchResultsFirstPage googleSearchResultsFirstPage = googleHomePage.search(searchTerm);
        Assert.assertTrue(googleSearchResultsFirstPage.isPageLoaded(), "Page with search results is not loaded");

        List<String> searchResultsListFirstPage = googleSearchResultsFirstPage.getSearchResults();
        Assert.assertEquals(searchResultsListFirstPage.size(),10, "Count of search results is wrong");

        for(String searchResult :searchResultsListFirstPage){
            Assert.assertTrue(searchResult.toLowerCase().contains(searchTerm.toLowerCase()),
                    "SearchTerm  " + searchTerm + "was not found in: \n" + searchResult);



        GoogleSearchResultsSecondPage googleSearchResultsSecondPage = googleSearchResultsFirstPage.goToSecondPage();
        Assert.assertTrue(googleSearchResultsSecondPage.isPageLoaded(), "Second page with search results is not loaded");

        List<String> searchResultsListSecondPage = googleSearchResultsSecondPage.getSearchResults();
        Assert.assertEquals(searchResultsListSecondPage.size(), 10, "Count of search results is wrong");

            for (String searchResult2:searchResultsListSecondPage){
                Assert.assertTrue(searchResult2.toLowerCase().contains(searchTerm.toLowerCase()),
                        "Searchterm "+searchTerm+"was not found in: "+searchResult2);
        }

        }
    }
}
