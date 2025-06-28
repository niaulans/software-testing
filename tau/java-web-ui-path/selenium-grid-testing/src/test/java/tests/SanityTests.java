package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchResultsPage;

public class SanityTests extends BaseTest {
    
    @Test(groups = {"sanity"}, priority = 1)
    public void testHomePageElements() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToHomePage();
        
        Assert.assertTrue(homePage.isLogoDisplayed(), "Google logo should be displayed");
        Assert.assertTrue(homePage.isSearchBoxDisplayed(), "Search box should be displayed");
        Assert.assertTrue(homePage.isSearchButtonDisplayed(), "Search button should be displayed");
        Assert.assertTrue(homePage.isFeelingLuckyButtonDisplayed(), "I'm Feeling Lucky button should be displayed");
        Assert.assertTrue(homePage.areLanguageLinksDisplayed(), "Language links should be displayed");
    }
    
    @Test(groups = {"sanity"}, priority = 2)
    public void testSearchFunctionality() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToHomePage();
        
        SearchResultsPage searchResultsPage = homePage.performSearch("Maven TestNG Integration");
        
        Assert.assertTrue(searchResultsPage.areSearchResultsDisplayed(), "Search results should be displayed");
        Assert.assertTrue(searchResultsPage.getSearchResultCount() >= 5, "Should have at least 5 search results");
        Assert.assertTrue(searchResultsPage.isResultStatsDisplayed(), "Result stats should be displayed");
        
        String resultStats = searchResultsPage.getResultStats();
        Assert.assertTrue(resultStats.contains("results"), "Result stats should contain 'results' text");
    }
    
    @Test(groups = {"sanity"}, priority = 3)
    public void testSearchResultsNavigation() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToHomePage();
        
        SearchResultsPage searchResultsPage = homePage.performSearch("Selenium Grid Tutorial");
        
        Assert.assertTrue(searchResultsPage.areSearchResultsDisplayed(), "Search results should be displayed");
        Assert.assertTrue(searchResultsPage.isNextButtonDisplayed(), "Next button should be displayed");
        
        // Test pagination
        searchResultsPage.clickNextButton();
        Assert.assertTrue(searchResultsPage.isPreviousButtonDisplayed(), "Previous button should be displayed on page 2");
    }
    
    @Test(groups = {"sanity"}, priority = 4)
    public void testMultipleSearches() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToHomePage();
        
        // First search
        SearchResultsPage searchResultsPage = homePage.performSearch("Java");
        Assert.assertTrue(searchResultsPage.areSearchResultsDisplayed(), "First search results should be displayed");
        
        // Second search from results page
        SearchResultsPage newSearchResults = searchResultsPage.performNewSearch("Python");
        Assert.assertTrue(newSearchResults.areSearchResultsDisplayed(), "Second search results should be displayed");
        
        String firstResultTitle = newSearchResults.getFirstSearchResultTitle();
        Assert.assertFalse(firstResultTitle.isEmpty(), "Should have results for Python search");
    }
    
    @Test(groups = {"sanity"}, priority = 5)
    public void testPageTitleAndUrl() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToHomePage();
        
        Assert.assertEquals(homePage.getPageTitle(), "Google", "Home page title should be 'Google'");
        Assert.assertTrue(homePage.getCurrentUrl().contains("google.com"), "URL should contain google.com");
        
        SearchResultsPage searchResultsPage = homePage.performSearch("Page Object Model");
        Assert.assertTrue(searchResultsPage.getPageTitle().contains("Page Object Model"), 
            "Search results page title should contain search term");
        Assert.assertTrue(searchResultsPage.getCurrentUrl().contains("search"), 
            "Search results URL should contain 'search'");
    }
}