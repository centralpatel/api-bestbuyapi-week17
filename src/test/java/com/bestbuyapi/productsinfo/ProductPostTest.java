package com.bestbuyapi.productsinfo;

import com.bestbuyapi.model.ProductPojo;
import com.bestbuyapi.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ProductPostTest extends TestBase {

    @Test
    public void createProduct() {

        ProductPojo productPojo = new ProductPojo();
        productPojo.setName("Battery Fast");
        productPojo.setType("Rechargeable1");
        productPojo.setPrice(5);
        productPojo.setShipping(10);
        productPojo.setUpc("pvc");
        productPojo.setDescription("Alkaline Rechargeable Battery");
        productPojo.setManufacturer("Duracell");
        productPojo.setModel("Demo2");
        productPojo.setUrl("http://www.bestbuy.com/site/duracell");
        productPojo.setImage("http://img.bbystatic.com/BestBuy_US/images/products/4853/480001_sa.jpg");


        Response response = given()
                .header("Content-Type", "application/json")
                .body(productPojo)
                .when()
                .post("/products");
        response.then().statusCode(201);
        response.prettyPrint();

    }
}
