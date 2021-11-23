package com.techproed.apiReviewPackage;

import com.techproed.testBase.HerokuAppTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class C02 extends HerokuAppTestBase {
      /*
   https://restful-booker.herokuapp.com/booking url'ine
   accept type'i "application/json" olan GET request'i yolladigimda
   gelen response'un
   status kodunun 200
   content type'inin "application/json" oldugunu test edin

    */
    @Test
    public void test01(){
        Response response=given().
                spec(specReview11).
                accept("application/json").
                when().
                get();
        //response.prettyPrint();
        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON);
        //1.id nin 8 oldugumu test ettik
        List<Map<String,Integer>> responseBody=response.as(List.class);
        System.out.println(responseBody.get(0).values());

        //Assert.assertEquals(8,responseBody.get(0).values());
        Assert.assertTrue(responseBody.get(0).containsValue(8));
    }
}
