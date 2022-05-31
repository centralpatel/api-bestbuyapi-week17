package com.bestbuyapi.servicesinfo;

import com.bestbuyapi.model.ServicesPojo;
import com.bestbuyapi.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class ServicesPatchTest extends TestBase {

    @Test
    public void updateServicesWithPatch() {
        ServicesPojo servicesPojo = new ServicesPojo();
        servicesPojo.setName("Rose");



        Response response = given()
                .basePath("/services")
                .header("Content-Type", "application/json")
                .pathParam("id", 22)
                .body(servicesPojo)
                .when()
                .patch("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();

    }

}
