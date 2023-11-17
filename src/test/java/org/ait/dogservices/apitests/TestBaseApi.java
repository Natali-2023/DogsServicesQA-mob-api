package org.ait.dogservices.apitests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;

public class TestBaseApi {


    @BeforeMethod
    public  void init(){   // precondition
        System.err.close();

        RestAssured.baseURI = "https://hunde24.online/";
        RestAssured.basePath = "api";

    }
    public static Response login() {
        String username = "nat@mail.com";
        String password = "Qwerty8888!";


        Response authResponse = RestAssured.given()
                .param("username", username)
                .param("password", password)
                .post("login");
        return authResponse;
    }

}
