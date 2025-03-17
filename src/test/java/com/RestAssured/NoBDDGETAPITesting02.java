package com.RestAssured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class NoBDDGETAPITesting02 {

    RequestSpecification rs;
    Response response;
    ValidatableResponse vr;


    @Test
    public void positiveTestcase(){
        String pincode = "110094";
        rs = RestAssured.given();
        rs.baseUri("https://api.zippopotam.us");
        rs.basePath("/IN/110094");

        response = rs.when().log().all().get();
        vr = response.then().log().all().statusCode(200);
    }
  @Test
    public void negativeTestcase(){
        rs = RestAssured.given();
        rs.baseUri("https://api.zippopotam.us");
        rs.basePath("/IN/110094");

        response = rs.when().log().all().get();
        vr = response.then().log().all().statusCode(201);
  }
}
