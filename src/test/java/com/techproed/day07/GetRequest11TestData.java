package com.techproed.day07;

import com.techproed.testBase.JsonPlaceHolderTestBase;
import com.techproed.testData.JsonPlaceHolderTestData;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetRequest11TestData extends JsonPlaceHolderTestBase {
    @Test
    public  void  test(){
        spec01.pathParams("parametre1","todos",
                "parametre2",2);

        JsonPlaceHolderTestData expectedObje = new JsonPlaceHolderTestData();
        HashMap<String,Object> expectedData= (HashMap<String, Object>) expectedObje.setUpTestData();





        Response response=given().
                accept("application/json").
                spec(spec01).
                when().
                get("{parametre1}/{parametre2}");

        response.prettyPrint();
        //1.yontem Matcher class ile assertion islemi yaptik

        response.then().assertThat().statusCode((Integer)expectedData.get("statusCode")).
                headers("via", equalTo(expectedData.get("via")),
                        "Server",equalTo(expectedData.get("Server"))).
                body("userId",equalTo(expectedData.get("userId")),
                        "title",equalTo(expectedData.get("title")),
                        "completed",equalTo(expectedData.get("completed")));

        //2.yontem

        JsonPath jsonPath=response.jsonPath();

        Assert.assertEquals(expectedData.get("statusCode"),response.statusCode());
        Assert.assertEquals(expectedData.get("via"),response.getHeader("via"));
        Assert.assertEquals(expectedData.get("Server"),response.getHeader("Server"));
        Assert.assertEquals(expectedData.get("userId"),jsonPath.getInt("userId"));
        Assert.assertEquals(expectedData.get("title"),jsonPath.getString("title"));
        Assert.assertEquals(expectedData.get("completed"),jsonPath.getBoolean("completed"));

        //3.yontem deserialization
        //object mapper
        //pojo class ile birlikte map

    }
