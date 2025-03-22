package APITestNG;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Assertion03 {
    RequestSpecification requestSpecification;
    ValidatableResponse  validatableResponse;
    Response response;
   String  Token;
   Integer bookingid;

   @Test
    public  void Test_Post(){

       String payload_POST = "{\n" +
               "    \"firstname\" : \"Pramod\",\n" +
               "    \"lastname\" : \"Dutta\",\n" +
               "    \"totalprice\" : 123,\n" +
               "    \"depositpaid\" : false,\n" +
               "    \"bookingdates\" : {\n" +
               "        \"checkin\" : \"2024-01-01\",\n" +
               "        \"checkout\" : \"2024-01-01\"\n" +
               "    },\n" +
               "    \"additionalneeds\" : \"Lunch\"\n" +
               "}";

       requestSpecification = RestAssured.given();
       requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
       requestSpecification.basePath("/booking");
       requestSpecification.contentType(ContentType.JSON);
       requestSpecification.body(payload_POST).log().all();

       Response response = requestSpecification.when().post();

       validatableResponse =response.then().log().all();
       validatableResponse.statusCode(200);


       validatableResponse.body("booking.firstname", Matchers.equalTo("Pramod"));
       validatableResponse.body("booking.lastname",Matchers.equalTo("Dutta"));
       validatableResponse.body("booking.depositpaid",Matchers.equalTo(false));
       validatableResponse.body("bookingid",Matchers.notNullValue());

       String firstname = response.then().extract().path("booking.firstname");
       String lastname = response.then().extract().path("booking.lastname");

       Assert.assertNotNull(bookingid);
       Assert.assertEquals(firstname,"Pramod");
       Assert.assertEquals(lastname,"Dutta");

       SoftAssert softAssert = new SoftAssert();
       softAssert.assertEquals(firstname,"Jim");
       softAssert.assertAll();

       assertThat(bookingid).isNotNull().isNotZero().isPositive();
       assertThat(firstname).isEqualTo("Pramod").isNotEmpty().isNotBlank().isNotNull();
   }

}
