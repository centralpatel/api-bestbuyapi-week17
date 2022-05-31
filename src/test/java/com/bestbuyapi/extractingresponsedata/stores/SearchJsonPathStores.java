package com.bestbuyapi.extractingresponsedata.stores;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class SearchJsonPathStores {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;

        response = given()
                .when()
                .get("/stores")
                .then().statusCode(200);
    }
    //1. Extract the value of limit
    @Test
    public void test001() {
        int limit = response.extract().path("limit");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + limit);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test002() {
        int total = response.extract().path("total");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + total);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test003() {
        String fifthStore = response.extract().path("data[4].name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + fifthStore);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test004() {
        List <String> allStoreNames = response.extract().path("data.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + allStoreNames);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test005() {
        List<Integer> allStoreId = response.extract().path("data.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + allStoreId);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test006() {
        int sizeofData = response.extract().path("data.size");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of total is : " + sizeofData);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test007() {
        List <HashMap<String, ?>> valueOfStoreStCloud = response.extract().path("data.findAll{it.name == 'St Cloud'}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + valueOfStoreStCloud);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test008() {
        List <String> addressOfRochester = response.extract().path("data.findAll{it.name == 'Rochester'}.address");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + addressOfRochester);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test009() {
        List <String> servicesOf7ThStore = response.extract().path("data[7].services");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + servicesOf7ThStore);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test010() {
        List <List<String>> servicesNameWindowsStore = response.extract().path("data.find{it.services}.services.findAll{it.name=='Windows Store'}.storeservices");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + servicesNameWindowsStore);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test011() {
        List <Integer> storeIdOfAllStores = response.extract().path("data.services.storeservices.storeId");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + storeIdOfAllStores);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test012() {
        List <Integer> idOfAllStore = response.extract().path("data.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + idOfAllStore);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test013() {
        List <Integer> storeNameStateND = response.extract().path("data.findAll{it.state == 'ND'}.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + storeNameStateND);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test014() {
        List <List<Integer>> totalServicesOfStoreRochester = response.extract().path("data.findAll{it.name =='Rochester'}.services.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + totalServicesOfStoreRochester.get(0).size());
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test015() {
        List <?> createdAtServiceNameWindowsStore = response.extract().path("data.find{it.services}.services.findAll{it.name='Windows Store'}.storeservices.createdAt");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + createdAtServiceNameWindowsStore);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test016() {
        List <String> nameOfAllServicesOfFargo = response.extract().path("data.findAll{it.name =='Fargo'}.services.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + nameOfAllServicesOfFargo);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test017() {
        List <String> zipOfAllStore = response.extract().path("data.zip");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + zipOfAllStore);
        System.out.println("------------------End of Test---------------------------");
    }
//18. Find the zip of store name = Roseville
@Test
public void test018() {
    String zip = response.extract().path("data[2].zip");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("Total services Where store name = “Fargo” : "+zip);
    System.out.println("------------------End of Test---------------------------");

}
//19. Find the storeservices details of the service name = Magnolia Home Theater
    @Test
    public void test019() {
        List <?> storeServicesOfStoreMagnoliaHomeTheater = response.extract().path("data.find{it.services}.services.findAll{it.name='Magnolia Home Theater'}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + storeServicesOfStoreMagnoliaHomeTheater);
        System.out.println("------------------End of Test---------------------------");
    }
//20. Find the lat of all the stores
@Test
    public void test020() {
        List <?> latOfAllStores = response.extract().path("data.lat");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + latOfAllStores);
        System.out.println("------------------End of Test---------------------------");
    }
}
