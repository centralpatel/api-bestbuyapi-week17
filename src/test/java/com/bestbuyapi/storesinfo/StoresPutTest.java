package com.bestbuyapi.storesinfo;

import com.bestbuyapi.model.StoresPojo;
import com.bestbuyapi.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StoresPutTest extends TestBase {
    @Test
    public void updateProductWithPut(){
        StoresPojo storesPojo = new StoresPojo();

        storesPojo.setName("Alpha");
        storesPojo.setType("BlackBox");
        storesPojo.setAddress("50 Wincester Road");
        storesPojo.setAddress2("Wembley");
        storesPojo.setCity("London");
        storesPojo.setState("UK");
        storesPojo.setZip("HA3 5RE");

        Response response = given()
                .basePath("/stores")
                .header("Content-Type", "application/json")
                .pathParam("id", 8929)
                .body(storesPojo)
                .when()
                .put("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
