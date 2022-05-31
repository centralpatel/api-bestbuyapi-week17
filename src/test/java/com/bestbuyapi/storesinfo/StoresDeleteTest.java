package com.bestbuyapi.storesinfo;

import com.bestbuyapi.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StoresDeleteTest extends TestBase {
    @Test
    public void deleteSingleStore() {

        Response response = given()
                .basePath("/stores")
                .pathParam("id", 8925)
                .when()
                .delete("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();

    }}
