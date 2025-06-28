package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchResultsPage;

public class SmokeTests extends BaseTest {
    
    @Test(groups = {"smoke"}, priority = 1)
    public void testHomePageLoad() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToHomePage();
        
        Assert.assertTrue(homePage.isLogoDisplayed(), "Google logo should be displayed");
        Assert.assertTrue(homePage.isSearchBoxDisplayed(), "Search box should be displayed");
        Assert.assertEquals(homePage.getPageTitle(), "Google", "Page title should be Google");
    }
    
    @Test(groups = {"smoke"}, priority = 2)
    public void testBasicSearch() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToHomePage();
        
        SearchResultsPage searchResultsPage = homePage.performSearch("Selenium WebDriver");
        
        Assert.assertTrue(searchResultsPage.areSearchResultsDisplayed(), "Search results should be displayed");
        Assert.assertTrue(searchResultsPage.getSearchResultCount() > 0, "Should have search results");
        Assert.assertTrue(searchResultsPage.isResultStatsDisplayed(), "Result stats should be displayed");
    }
    
    @Test(groups = {"smoke"}, priority = 3)
    public void testSearchBoxFunctionality() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToHomePage();
        
        homePage.enterSearchTerm("TestNG Framework");
        homePage.clickSearchButton();
        
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        Assert.assertTrue(searchResultsPage.areSearchResultsDisplayed(), "Search results should be displayed");
        
        String firstResultTitle = searchResultsPage.getFirstSearchResultTitle();
        Assert.assertFalse(firstResultTitle.isEmpty(), "First search result should have a title");
    }
    
    @Test(groups = {"smoke"}, priority = 4)
    public void testPageNavigation() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToHomePage();
        
        SearchResultsPage searchResultsPage = homePage.performSearch("Java Programming");
        Assert.assertTrue(searchResultsPage.areSearchResultsDisplayed(), "Search results should be displayed");
        
        // Navigate back to home page
        HomePage homePageAgain = searchResultsPage.clickGoogleLogo();
        Assert.assertTrue(homePageAgain.isLogoDisplayed(), "Should be back on home page");
        Assert.assertEquals(homePageAgain.getPageTitle(), "Google", "Page title should be Google");
    }
}