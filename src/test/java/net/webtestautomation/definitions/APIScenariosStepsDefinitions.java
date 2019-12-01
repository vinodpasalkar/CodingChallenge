package net.webtestautomation.definitions;

import net.thucydides.core.annotations.Steps;
import net.webtestautomation.tests.APITests;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class APIScenariosStepsDefinitions {

    @Steps
    APITests apiTests;

    @Given("I get all the items")
    public void fetchAllItems(){
        apiTests.getAllItems();
    }

    @When("I get all the items")
    public void getAllItems(){
        apiTests.fetchAllItems();
    }

    @Given("I add a new city $cityName")
    public void addNewCity(String cityName ){
        apiTests.postNewCity(cityName);
    }

    @Given("I get the data for city $cityName")
    @When("I get the data for city $cityName")
    public void fetchDataForCity(String cityName){
        apiTests.getDataForCity(cityName);
    }

    @Then("It contains valid data for $cityName")
    public void verifyCityDataInResponse(String cityName){
        apiTests.checkCityDataInResponse(cityName);
    }

    @Then("It returns invalid response")
    public void verifyCityInvalidResponse(){
        apiTests.checkCityInvalidResponse();
    }

    @Then("City $cityName should be present in it")
    public void verifyCityInResponse(String cityName){
        apiTests.checkCityInResponse(cityName);



    }
}
