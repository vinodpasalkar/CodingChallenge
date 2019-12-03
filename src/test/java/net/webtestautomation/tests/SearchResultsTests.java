package net.webtestautomation.tests;

import net.thucydides.core.annotations.Step;
import net.webtestautomation.pages.SearchResultsPage;

//This class is used for test assertions
public class SearchResultsTests {

    @Step("Step {0}")
    public void generateStep(String s){
    }

    private SearchResultsPage searchResultsPage;

    public void goAndCheckNonRegisteredUserOnTheWebPage() {
        searchResultsPage = new SearchResultsPage();
        searchResultsPage.gotoSiteOnBrowser();
        generateStep("Opened ebay website");
    }

    public void checkNonExistingUser() {
        searchResultsPage.verifyNonExistingUser();
    }

    public void searchForItem(String itemName) {
        searchResultsPage.searchForItemOnUI(itemName);
    }

    public void checkMatchingResults(String searchItemString) {
        searchResultsPage.verifyResultOnUI(searchItemString);
    }

    public void checkProductPage() {
        searchResultsPage.verifyProductPageUI();
    }

    public void checkItemsOrder() {
        generateStep("Verifying the sort order");
        searchResultsPage.verifyItemsOrder();
        generateStep("Verified the sort order and its correct");
    }

    public void sortTheResultsBy(String sortValue){
        generateStep("Selected sort value " +sortValue);
        searchResultsPage.sortResultsOnUI(sortValue);
    }

    public void checkTag(String tagName) {
        searchResultsPage.checkTagOnUI(tagName);
        generateStep("Verified "+tagName+" on UI");
    }

    public void enterSearchTermAndCategory(String searchTerm,String searchCategory) {
        searchResultsPage.enterSearchTermAndCategoryOnUI(searchTerm,searchCategory);
    }

    public void checkResultsForCategory(String searchCategory) {
        searchResultsPage.checkResultsForCategoryOnUI(searchCategory);
    }

    public void checkResultsOnMultiplePages() {
        searchResultsPage.VerifyResultsOnMultiplePages();
    }

    public void checkPageNavigation() {
        searchResultsPage.verifyPageNavigationOnUI();
    }

    public void setFilterOnPage(String filterOption) {
        searchResultsPage.setFilterOnUI(filterOption);
    }

    public void verifyWebPage() {
        searchResultsPage.verifyWebPageLogoOnUI();
    }
}
