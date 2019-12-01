package net.webtestautomation.definitions;

import net.thucydides.core.annotations.Steps;
import net.webtestautomation.tests.SearchResultsTests;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;


//This class contains all the steps definitions for the gherkin feature steps
public class SearchResultsStepsDefinitions {

    @Steps
    SearchResultsTests searchResultsTests;

    String searchItemString = "";

    @Given("I am a non-registered customer")
    public void verifyNonExistingUser(){
        searchResultsTests.goAndCheckNonRegisteredUserOnTheWebPage();
    }

    @Given("I navigate to www.ebay.co.uk")
    public void navigateToWebPage(){
        searchResultsTests.verifyWebPage();
    }

    @When("I search for an item $itemName")
    public void searchItem(String itemName){
        searchItemString = itemName;
        searchResultsTests.searchForItem(itemName);
    }

    @Then("I get a list of matching results")
    public void verifyMatchingResults(){
        searchResultsTests.checkMatchingResults(searchItemString);
    }

    @Then("the resulting items cards show: postage price, No of bids, price or show BuyItNow tag")
    public void verifyProductPage(){
        searchResultsTests.checkProductPage();
    }

    @Then("I can sort the results by $LowestPrice")
    public void sortResultsBy(String sortValue) {
        searchResultsTests.sortTheResultsBy(sortValue);
    }

    @Then("the results are listed in the page in the correct order")
    public void verifyItemsOrder(){
        searchResultsTests.checkItemsOrder();
    }

    @Then("all the results shown in the page have the $tagName tag")
    public void verifyTag(String tagName){
        searchResultsTests.checkTag(tagName);
    }

    @When("I enter a $searchTerm and select a $searchCategory")
    public void enterSearchTermAndCategory(String searchTerm,String searchCategory){
        searchItemString = searchTerm;
        searchResultsTests.enterSearchTermAndCategory(searchTerm,searchCategory);
    }

    @Then("I can verify that the results shown as per the the $searchCategory")
    public void verifyResultsForCategory(String searchCategory){
        searchResultsTests.checkResultsForCategory(searchCategory);
    }

    @Then("the results show more than one page")
    public void verifyResultsPageOnMorePages(){
        searchResultsTests.checkResultsOnMultiplePages();
    }

    @Then("I can filter the results by $Buyitnow")
    public void setFilter(String filterOption){
        searchResultsTests.setFilterOnPage(filterOption);
    }

    @Then("the user can navigate through the pages to continue looking at the items")
    public void navigateTroughPages(){
        searchResultsTests.checkPageNavigation();
    }

}
