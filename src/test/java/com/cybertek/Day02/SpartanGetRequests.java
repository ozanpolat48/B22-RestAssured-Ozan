package com.cybertek.Day02;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SpartanGetRequests {

    String baseUrl = "http://3.83.131.158:8000";

    //Given Accept type application/json
    //When user send GET request to api/spartans end point
    //Then status code 200
    //And response Content Type must be application/json
    //And response body should include spartan result

    @Test
    public void test1(){

       Response response = RestAssured.given().accept(ContentType.JSON)
                .when()
                      .get(baseUrl+"/api/spartans");

       //printing status code from response object
        System.out.println("response.statusCode() = " + response.statusCode());

        //printing reponse content type from reponse object
        System.out.println("response.contentType() = " + response.contentType());

        //print whole result body
        response.prettyPrint();

        //how to do API testing then?
        Assertions.assertEquals(response.statusCode(),200);

        //verify content type iş application /json
        Assertions.assertEquals(response.contentType(),"application/json");

    }

    /*
    Given accept is application/json
    When users sends a get request to /api/spartans/3
    Then status code should be 200
    And content type should be application/json
    And json body should contain Fidole

     */

    @DisplayName("Get one spartan /api/spartans/3 and verify")
    @Test
    public void test2(){
        Response response = RestAssured.given().accept(ContentType.JSON).
                when().get(baseUrl + "/api/spartans/3");

        //verify status code 200
        Assertions.assertEquals(response.statusCode(),200);

        //verify content type
        Assertions.assertEquals(response.contentType(),"application/json");

        Assertions.assertTrue(response.body().asString().contains("Fidole"));


    }

    /*
    Given no headers provided
    When Users sends GET request to /api/hello
    Then response status code should be 200
    And Content type header should be "text/plain;charset=UFT-8"
    And header should contain date
    And Content-Length should be 17
    And body should be "Hello from Sparta"
     */


    @DisplayName("GET request to /api/hello")
    @Test
    public void test3(){

        // send request and save response inside the response object
        Response response = RestAssured.when().get(baseUrl + "/api/hello");

        //verify status code 200
        Assertions.assertEquals(200, response.statusCode());

        //verify content type
        Assertions.assertEquals("text/plain;charset=UTF-8", response.contentType());

        // verify we have headers named date
        //we use hasHeaderWithname method to verify header exist or not
        Assertions.assertTrue(response.headers().hasHeaderWithName("Date"));

        //how to get header from response using header key?
        //we use response.header(String headerName) method to get any header value
        System.out.println("response.header(\"Content-Length\") = " + response.header("Content-Length"));
        System.out.println(response.header("Date"));

        //verify content length is 17
        Assertions.assertEquals("17",response.header("Content-Length"));

        //verify body is "Hello from Sparta"
        Assertions.assertEquals("Hello from Sparta",response.body().asString());

    }




}
