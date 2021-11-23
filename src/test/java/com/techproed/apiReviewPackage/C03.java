package com.techproed.apiReviewPackage;

import com.techproed.testBase.HerokuAppTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class C03 extends HerokuAppTestBase {

    /*
       https://restful-booker.herokuapp.com/booking/7 url'ine
   accept type'i "application/json" olan GET request'i yolladigimda
   gelen response'un
   status kodunun 200
   ve content type'inin "application/json"
   ve firstname'in "Mary"
   ve lastname'in "Jones"
   ve checkin date'in 2018-10-07"
   ve checkout date'in 2020-09-30 oldugunu test edin
        */
    public Response response() {
        specReview11.pathParam("bookingid", 7);
        Response response = given().
                spec(specReview11).
                when().
                get("{bookingid}");
        return response;
    }

    public ValidatableResponse assertion(){
       ValidatableResponse isTrue= response().
               then().
               assertThat().
               statusCode(200).
               contentType(ContentType.JSON);
        return isTrue;
    }

    @Test
    public void test() {
        specReview11.pathParam("bookingid", 7);
        Response response = given().
                spec(specReview11).
                when().
                get("{bookingid}");
        response.prettyPrint();

        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).body("firstname", equalTo("Eric"),
                        "lastname", equalTo("Smith"),
                        "totalprice", equalTo(312),
                        "bookingdates.checkin", equalTo("2016-11-10"),
                        "bookingdates.checkout", equalTo("2017-02-05"));
    }

    @Test
    public void testJson() {
        response();
        // response().prettyPrint();
        response().
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON);

        JsonPath jsonPath = response().jsonPath();

        Assert.assertEquals("Susan", jsonPath.getString("firstname"));
        Assert.assertEquals("2021-10-30", jsonPath.getString("bookingdates.checkin"));

        //2/yol
        Map<String,String> bookingdatesMap = jsonPath.getMap("bookingdates");

    }

    @Test
    public void tesGson() {
        response();
        response().prettyPrint();
        assertion();

        Map<String,Object> responseBodyMap = response().as(HashMap.class);
        System.out.println(responseBodyMap);
        Assert.assertEquals("Mary",responseBodyMap.get("firstname"));
        Assert.assertTrue(responseBodyMap.get("lastname").equals("Wilson"));
       // Assert.assertEquals("2018-10-02",responseBodyMap.get("checkin"));
        Map<String,String> bookingdatesMap = (Map<String, String>) responseBodyMap.get("bookingdates");

        Assert.assertEquals("2021-03-27",bookingdatesMap.get("checkin"));




    }
}