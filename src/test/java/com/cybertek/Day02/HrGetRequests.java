package com.cybertek.Day02;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class HrGetRequests {

    //@BeforeAll is a annotation equals to @BeforeClass in testNg, we use with static method name
    @BeforeAll
    public static void init(){
        RestAssured.baseURI = "http://3.83.131.158:1000/ords/hr";


    }

}
