package com.bestbuyapi.productsinfo;

import com.bestbuyapi.model.ProductPojo;
import com.bestbuyapi.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ProductPutTest extends TestBase {

    @Test
    public void updateProductWithPut(){
        ProductPojo productPojo=new ProductPojo();
        productPojo.setName("Zinc Battery");
        productPojo.setType("Battery2");
        productPojo.setPrice(50);
        productPojo.setShipping(11);
        productPojo.setManufacturer("Duracell");
        productPojo.setUpc("0004446");
        productPojo.setDescription("Long-lasting energy Battery powerful");
        productPojo.setModel("UC-4444");
        productPojo.setUrl("http://www.bestbuy.com/site/Zinc1");
        productPojo.setImage("http://img.bystatic.com/BestBuy_US/images/products/4853/4800_sa.jpg");

        Response response = given()
                .basePath("/products")
                .header("Content-Type", "application/json")
                .pathParam("id", 9999684)
                .body(productPojo)
                .when()
                .put("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();

    }
}
