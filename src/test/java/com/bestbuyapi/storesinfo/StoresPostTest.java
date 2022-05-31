package com.bestbuyapi.storesinfo;

import com.bestbuyapi.model.StoresPojo;
import com.bestbuyapi.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StoresPostTest extends TestBase {

    @Test
    public void createStore() {

        StoresPojo storesPojo = new StoresPojo();

        storesPojo.setName("AlphaBeta");
        storesPojo.setType("SmallBox");
        storesPojo.setAddress("14 Wincester Road");
        storesPojo.setAddress2("Harrow");
        storesPojo.setCity("London");
        storesPojo.setState("UK");
        storesPojo.setZip("HA3 4RE");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(storesPojo)
                .when()
                .post("/stores");
        response.then().statusCode(201);
        response.prettyPrint();

    }
}
