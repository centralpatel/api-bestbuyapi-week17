package com.bestbuyapi.categoriesinfo;

import com.bestbuyapi.model.CategoriesPojo;
import com.bestbuyapi.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class CategoriesPatchTest extends TestBase {

    @Test
    public void updateCategoriesWithPatch(){
        CategoriesPojo categoriesPojo = new CategoriesPojo();
        categoriesPojo.setName("DVD Games");

        Response response = given()
                .basePath("/categories")
                .header("Content-Type", "application/json")
                .pathParams("id","abcat0010000")
                .body(categoriesPojo)
                .when()
                .patch("/{id}");
        response.prettyPrint();
        response.then().statusCode(200);
    }


}
