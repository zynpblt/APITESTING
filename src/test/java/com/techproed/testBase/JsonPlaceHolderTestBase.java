package com.techproed.testBase;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class JsonPlaceHolderTestBase {
   protected RequestSpecification spec01,spec02;

   @Before
    public void setUo(){
       spec01=new RequestSpecBuilder().
               setBaseUri("https://jsonplaceholder.typicode.com").
               build();
   }

   @Before
    public void setUp02() {
       spec02 = new RequestSpecBuilder().
               setBaseUri("https://jsonplaceholder.typicode.com").
               build();
   }
}
