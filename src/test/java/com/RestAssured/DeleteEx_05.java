package com.RestAssured;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

public class DeleteEx_05 {

    @Test
    public void deleteRequestCheck()
    {
        String token="be02ed2bcf970c4";
        String bookingId="39481";


        RequestSpecification rs;
        Response response;
        ValidatableResponse vr;

        rs= RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com/");
        rs.basePath("/booking/"+bookingId);
        rs.cookie("token",token);
        rs.log().all();

        response =rs.when().delete();
        rs.log().all();

        vr = response.then().log().all();
        vr.statusCode(201);


    }

}
