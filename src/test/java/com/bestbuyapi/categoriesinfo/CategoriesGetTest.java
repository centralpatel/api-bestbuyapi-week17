package com.bestbuyapi.categoriesinfo;

import com.bestbuyapi.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class CategoriesGetTest extends TestBase {

    @Test
    public void getSingleCategoriesInfo() {
        Response response = given()
                .when()
                .get("/categories");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void getSingleCategoriesInfo1() {
        Response response = given()
                .basePath("/categories")
                .pathParams("id", "abcat0010000")
                .when()
                .get("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void searchCategoriesWithParameter() {
        HashMap<String,Object> qParams = new HashMap<>();
        qParams.put("$limit",1);
        qParams.put("$skip",2);
        Response response = given()
                .queryParams(qParams)
                .when()
                .get("/categories");
        response.prettyPrint();
        response.then().statusCode(200);
    }
}
