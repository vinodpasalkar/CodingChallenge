package net.webtestautomation.dataModel;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.google.gson.Gson;
import net.webtestautomation.requests.CityDataResponse;
import net.webtestautomation.requests.CityPostResponse;
import net.webtestautomation.requests.CityResponse;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class APIDataModel {

    HttpResponse httpResponse;
    private static String responseString;
    private CityResponse cityResponse;
    private CityDataResponse cityDataResponse;
    private CityPostResponse cityPostResponse;
    private CloseableHttpClient httpClient;
    private int httpStatus;
    private Gson gson;
    public APIDataModel() throws IOException {
        WireMockServer wireMockServer = new WireMockServer(); //No-args constructor will start on port 8080, no HTTPS
        wireMockServer.start();
        configureFor("localhost", 8080);
        stubFor(get(urlEqualTo("/get/all")).willReturn(aResponse().withBody("{\"items\":[{\"id\":\"1842347-1560779940\",\"cost\":\"\\u00a3829.99\",\"location\":\"LON\"},{\"id\":\"1936481-1560779940\",\"cost\":\"\\u00a3150.29\",\"location\":\"MAN\"},{\"id\":\"1936504-1560779940\",\"cost\":\"\\u00a31164.74\",\"location\":\"CAM\"},{\"id\":\"1936527-1560779940\",\"cost\":\"\\u00a3279.99\",\"location\":\"LCS\"},{\"id\":\"1842347-1560779940\",\"cost\":\"\\u00a3829.99\",\"location\":\"PAC\"}]}")));
        stubFor(get(urlEqualTo("/get/LON")).willReturn(aResponse().withBody("{\"items\":[{\"id\":\"1842347-1560779940\",\"cost\":\"£829.99\",\"location\":\"LON\"}]}")));
        stubFor(get(urlEqualTo("/get/MAN")).willReturn(aResponse().withBody("{\"items\":[{\"id\":\"1936481-1560779940\",\"cost\":\"£150.29\",\"location\":\"MAN\"}]}")));
        stubFor(get(urlEqualTo("/get/CAM")).willReturn(aResponse().withBody("{\"items\":[{\"id\":\"1936504-1560779940\",\"cost\":\"£1164.74\",\"location\":\"CAM\"}]}")));
        stubFor(get(urlEqualTo("/get/LCS")).willReturn(aResponse().withBody("{\"items\":[{\"id\":\"1936527-1560779940\",\"cost\":\"£279.99\",\"location\":\"LCS\"}]}")));
        stubFor(get(urlEqualTo("/get/NEW")).willReturn(aResponse().withStatus(404).withBody("{\"status\":\"Error\",\"message\":\"City NEW not found\"}")));
        stubFor(post(urlEqualTo("/post")).willReturn(aResponse().withStatus(200).withBody("{\"id\":\"1842347-1560779940\",\"cost\":\"£829.99\",\"location\":\"PAC\"}")));

        httpClient = HttpClients.createDefault();
        gson = new Gson();
    }

    private String convertResponseToString(HttpResponse response) throws IOException {
        InputStream responseStream = response.getEntity().getContent();
        Scanner scanner = new Scanner(responseStream, "UTF-8");
        String responseString = scanner.useDelimiter("\\Z").next();
        scanner.close();
        return responseString;
    }


    public CityResponse getAllItems() {
        responseString = executeRequestAndGetResponse("http://localhost:8080/get/all");
        this.cityResponse = gson.fromJson(this.responseString,CityResponse.class);
        return cityResponse;
    }

    public CityDataResponse getDataForCity(String cityName) {
        String url = "http://localhost:8080/get/cityName";
        url = url.replace("cityName",cityName);
        responseString = executeRequestAndGetResponse(url);
        this.cityDataResponse = gson.fromJson(this.responseString, CityDataResponse.class);
        if(cityDataResponse != null)
            return cityDataResponse;
        else
            return null;
    }

    private String executeRequestAndGetResponse(String url) {
        HttpGet request = new HttpGet(url);
        try {
            httpResponse = httpClient.execute(request);
            this.httpStatus = httpResponse.getStatusLine().getStatusCode();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            responseString = convertResponseToString(httpResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return responseString;

    }


    public CityPostResponse setNewCity(String cityName) {
        String url = "http://localhost:8080/post";
        url = url.replace("cityName",cityName);
        responseString = executeRequestAndPostResponse(url);
        this.cityPostResponse = gson.fromJson(this.responseString, CityPostResponse.class);
        if(cityPostResponse != null)
            return cityPostResponse;
        else
            return null;
    }

    private String executeRequestAndPostResponse(String url) {
        HttpPost request = new HttpPost(url);
        try {
            httpResponse = httpClient.execute(request);
            this.httpStatus = httpResponse.getStatusLine().getStatusCode();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            responseString = convertResponseToString(httpResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseString;
    }

    public int getHttpStatusCode(){
        return httpStatus;
    }
}
