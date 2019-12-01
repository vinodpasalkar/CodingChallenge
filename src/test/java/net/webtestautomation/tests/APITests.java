package net.webtestautomation.tests;

import net.thucydides.core.annotations.Step;
import net.webtestautomation.dataModel.APIDataModel;
import net.webtestautomation.requests.CityDataResponse;
import net.webtestautomation.requests.CityPostResponse;
import net.webtestautomation.requests.CityResponse;
import net.webtestautomation.requests.ItemsItem;
import org.junit.Assert;

import java.io.IOException;

public class APITests {

    private APIDataModel apiDataModel;
    private CityResponse cityResponse;
    private CityPostResponse cityPostResponse;
    private CityDataResponse cityDataResponse = new CityDataResponse();
    String cityId = "";
    String cityLocation = "";
    String cityCost = "";


    @Step("Step {0}")
    public void generateStep(String s){
    }

    public void getAllItems() {
        try {
            apiDataModel = new APIDataModel();
        } catch (IOException e) {
            e.printStackTrace();
        }
        cityResponse = apiDataModel.getAllItems();
    }

    public void postNewCity(String cityName) {
        try {
            apiDataModel = new APIDataModel();
        } catch (IOException e) {
            e.printStackTrace();
        }
        cityPostResponse = apiDataModel.setNewCity(cityName);
    }

    public void getDataForCity(String cityName) {
        try {
            apiDataModel = new APIDataModel();
        } catch (IOException e) {
            e.printStackTrace();
        }
        cityDataResponse = apiDataModel.getDataForCity(cityName);

        if(cityDataResponse.getItems() != null && cityDataResponse.getItems().size() >0) {
            cityId = cityDataResponse.getItems().get(0).getId();
            cityLocation = cityDataResponse.getItems().get(0).getLocation();
            cityCost = cityDataResponse.getItems().get(0).getCost();
        }
    }

    public void checkCityInResponse(String cityName) {
        boolean flag = false;
        for(ItemsItem singleItem :cityResponse.getItems()){
            if (singleItem.getLocation().contains(cityName)) {
                flag= true;
            } else {
                continue;
            }
        }
        if(flag){
            generateStep(cityName + " is present in the city response");
        }
        else{
            Assert.fail(cityName + " is not present in the city response");
        }
    }

    public void checkCityInvalidResponse() {
        Assert.assertEquals(apiDataModel.getHttpStatusCode(),404);
    }

    public void checkCityDataInResponse(String cityName) {
        if(cityDataResponse.getItems().get(0).getId().equalsIgnoreCase(cityId)){
            generateStep(cityId + " is present in the city Data response");
        }
        else{
            Assert.fail(cityId + " is not present in the city Data response");
        }
        if(cityDataResponse.getItems().get(0).getLocation().equalsIgnoreCase(cityLocation)){
            generateStep(cityLocation + " is present in the city Data response");
        }
        else{
            Assert.fail(cityLocation + " is not present in the city Data response");
        }
        if(cityDataResponse.getItems().get(0).getCost().equalsIgnoreCase(cityCost)){
            generateStep(cityCost + " is present in the city Data response");
        }
        else{
            Assert.fail(cityCost + " is not present in the city Data response");
        }
    }

    public void fetchAllItems() {
        cityResponse = apiDataModel.getAllItems();
    }

}
