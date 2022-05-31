package com.bestbuyapi.categoriesinfo;

import com.bestbuyapi.model.CategoriesPojo;
import com.bestbuyapi.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CategoriesPostTest extends TestBase {

    @Test
    public void createCategories() {

        CategoriesPojo categoriesPojo = new CategoriesPojo();
        categoriesPojo.setName("DVD Games");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(categoriesPojo)
                .when()
                .post("/categories");
        response.then().statusCode(201);
        response.prettyPrint();
    }
}
