package com.RestAssured;


import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class APITesting01 {

    @Test
    @Description("Verify the positive valid pincode gives 200ok")
    public void test_Get_PositiveTC1(){

       RestAssured
               .given()
               .baseUri("https://api.zippopotam.us")
               .basePath("/IN/110048")
               .when()
               .get()
               .then()
               .log().all().statusCode(200);


    }
    @Test
    public void test_Get_PositiveTC2(){

        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/"+"-1")
                .when()
                .get()
                .then()
                .log().all().statusCode(200);


    } @Test
    public void test_Get_PositiveTC3(){

        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/"+"pincode")
                .when()
                .get()
                .then()
                .log().all().statusCode(200);


    }
}
