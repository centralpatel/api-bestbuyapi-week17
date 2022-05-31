package com.bestbuyapi.storesinfo;

import com.bestbuyapi.model.StoresPojo;
import com.bestbuyapi.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class StoresPatchTest extends TestBase {

    @Test
    public void updateStudentWithPatch(){

        StoresPojo storesPojo = new StoresPojo();

        storesPojo.setAddress("14 Harrow Road");
        storesPojo.setAddress2("Birmingham");
        storesPojo.setCity("Birminghamshire");
        storesPojo.setState("UK");
        storesPojo.setZip("B4 4RE");

        Response response = given()
                .basePath("/stores")
                .header("Content-Type", "application/json")
                .pathParam("id", 8925)
                .body(storesPojo)
                .when()
                .patch("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
