package com.techproed.day05;

import com.techproed.testBase.JsonPlaceHolderTestBase;
import org.junit.Test;

public class postRequest01 extends JsonPlaceHolderTestBase {

    /* POST Scenario:
            * Accept type Json olsun When POST request yolladigimda
         * 1) https://restful-booker.herokuapp.com/booking
            *  2) Request Body
         *  { "firstname":"Suleyman",
         *  "lastname": "Alptekin",
         *  "totalprice": 123,
         *  "depositpaid": true,
         * "bookingdates": {
         *  "checkin": "2020-05-02",
         *  "checkout": "2020-05-05" },
         * "additionalneeds": "Wifi" }
         * Then
         * Status Code 200 olmali
         * Response Bodynin , Request Body ile ayni oldugunu verify ediniz.
     */

    @Test
    public void post01(){

    }
}
