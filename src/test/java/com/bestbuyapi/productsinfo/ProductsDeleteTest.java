package com.bestbuyapi.productsinfo;

import com.bestbuyapi.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ProductsDeleteTest extends TestBase {

    @Test
    public void deleteSingleProduct() {

        Response response = given()
                .basePath("/products")
                .pathParam("id", 9999686)
                .when()
                .delete("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();

    }
}
