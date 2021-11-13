package com.techproed.day06;

import com.techproed.testBase.DummyTestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest08 extends DummyTestBase {
    //http://dummy.restapiexample.com/api/v1/employees url’inde bulunan
    //   1) Butun calisanlarin isimlerini consola yazdıralim
    //   2) 3. calisan kisinin ismini konsola yazdıralim
    //   3) Ilk 5 calisanin adini konsola yazdiralim
    //   4) En son calisanin adini konsola yazdiralim

    @Test
    public void test(){
        spec03.pathParam("parametre1","employees");

        Response response=given().
                accept("application/json").
                spec(spec03).when().
                get("/{parametre1}");

        response.prettyPrint();
    }
}
