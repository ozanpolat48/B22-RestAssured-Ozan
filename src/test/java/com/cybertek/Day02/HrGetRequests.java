package com.cybertek.Day02;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HrGetRequests {

    //@BeforeAll is a annotation equals to @BeforeClass in testNg, we use with static method name
    @BeforeAll
    public static void init(){

        //save baseurl inside this variable so that we dont need to type each http method.
        RestAssured.baseURI = "http://3.83.131.158:1000/ords/hr";


    }

    @DisplayName("GET request to/regions")
    @Test
    public void test1(){

        Response response = RestAssured.get("/regions");

        //print the status code
        System.out.println(response.statusCode());


    }

    /*
       Given accept type is application/json
       When user sends get request to /regions/2
       Then response status code must be 200
       And content type equals to application/json
       And response body contains Americas
     */




}
