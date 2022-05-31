package com.bestbuyapi.storesinfo;

import com.bestbuyapi.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StoresGetTest extends TestBase {
    @Test
    public void getAllStoresInfo() {
        Response response = given()
                .when()
                .get("/stores");
        response.then().statusCode(200);
        response.prettyPrint();

    }

    @Test
    public void getSingleStoresInfo() {
        Response response = given()
                .basePath("/stores")
                .pathParam("id", 6)
                .when()
                .get("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
