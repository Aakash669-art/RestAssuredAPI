package com.RestAssured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

public class POSTEX_03 {

    @Test
    public  void postRequest(){

        RequestSpecification rs;
        Response response
                ;
        ValidatableResponse vr;
        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        rs = RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com/");
        rs.basePath("/auth");
        rs.contentType("application/json");
        rs.body(payload).log().all();

        response = rs.when().log().all().post();
        vr = response.then().log().all().statusCode(200);




    }
}
