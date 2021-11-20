package com.techproed.apiReviewPackage;

import com.techproed.testBase.HerokuAppTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C01 extends HerokuAppTestBase {
          /*
    https://restful-booker.herokuapp.com/booking/3 adresine bir request gonderildiginde donecek cevap(response) icin
HTTP status kodunun 200
Content Type'in Json
Ve Status Line'in HTTP/1.1 200 OK
Oldugunu test edin
     */
    @Test
    public void firstVersion(){
       String url=" https://restful-booker.herokuapp.com/booking/3";

        Response response=given().
                accept("application/json").
                when().
                get(url);
        response.prettyPrint();
        response.then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                statusLine("HTTP/1.1 200 OK");

    }

    @Test
    public void secondVersion(){
    specReview11.pathParam("bookingid",3);
    Response response=given().
            spec(specReview11).
            accept("application/json").
            when().
            get("/{bookingid}");
    response.prettyPrint();

    response.
            then().
            assertThat().
            statusCode(200).
            contentType(ContentType.JSON).
            statusLine("HTTP/1.1 200 OK");

    }
    @Test
    public void multipleDataTesting(){
        for (int i=1;i<11;i++){
            specReview11.pathParam("bookingid",i);
            Response response=given().
                    spec(specReview11).
                    accept("application/json").
                    when().
                    get("/{bookingid}");
            response.prettyPrint();

            response.
                    then().
                    assertThat().
                    statusCode(200).
                    contentType(ContentType.JSON).
                    statusLine("HTTP/1.1 200 OK");

        }
    }


}
