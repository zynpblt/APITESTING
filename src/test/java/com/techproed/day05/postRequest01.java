package com.techproed.day05;

import com.techproed.testBase.HerokuAppTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class postRequest01 extends HerokuAppTestBase {


    @Test
    public void post01(){
        /* POST Scenario:
         * Accept type Json olsun When POST request yolladigimda
         * 1) https://restful-booker.herokuapp.com/booking
         *  2) Request Body
         *  { "firstname":"Ahmet",
         *  "lastname": "Mehmet",
         *  "totalprice": 123,
         *  "depositpaid": true,
         * "bookingdates": {
         *  "checkin": "2021-11-11",
         *  "checkout": "2021-11-15" },
         * "additionalneeds": "breakfast" }
         * Then
         * Status Code 200 olmali
         * Response Bodynin , Request Body ile ayni oldugunu verify ediniz.
         */

        Map<String,String> bookingDatesMap = new HashMap<>();
        bookingDatesMap.put("checkin", "2021-11-11");
        bookingDatesMap.put("checkout", "2021-11-15");

        Map<String,Object> requestBodyMap =  new HashMap<>();
        requestBodyMap.put("firstname","Ahmet");
        requestBodyMap.put("lastname", "Mehmet");
        requestBodyMap.put("totalprice", 123);
        requestBodyMap.put("depositpaid", true);
        requestBodyMap.put("bookingdates",bookingDatesMap);
        requestBodyMap.put("additionalneeds", "breakfast");

        Response response = given().
                                spec(spec04).
                                accept(ContentType.ANY).
                                auth().
                                basic("admin","password123").
                                body(requestBodyMap).
                            when().
                                post();
        response.prettyPrint();


    }
}
