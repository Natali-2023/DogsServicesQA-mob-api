package org.ait.dogservices.apitests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.ait.dogservices.api.AuthRequestDto;
import org.ait.dogservices.api.AuthResponseDto;
import org.ait.dogservices.api.ErrorDto;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LoginTestsApi extends TestBaseApi {

    @Test
    public void loginSuccessTest(){

        AuthRequestDto requestDto = AuthRequestDto.builder()
                .username("nat@mail.com")
                .password("Qwerty8888!")
                .build();

        AuthResponseDto dto = given()
                .contentType(ContentType.URLENC)
                .formParams("username",
                        requestDto.getUsername(), "password", requestDto.getPassword())
                .post("login")
                .then()
                .assertThat().statusCode(200)
                .extract().response().as(AuthResponseDto.class);

        System.out.println(dto.getMessage());

}
    @Test
    public void loginWrongEmailNegativeTest() {

        ErrorDto errorDto = given()
                .contentType(ContentType.JSON)
                .body(AuthRequestDto.builder()
                        .username("nbo00@gmail.com")
                        .password("Qwerty8888!")
                        .build())
                .post("login")
                .then()
                .assertThat().statusCode(401)
                .extract().response().as(ErrorDto.class);
        Assert.assertEquals(errorDto.getMessage(), "Incorrect username or password");
        System.out.println(errorDto.getMessage());
    }

}
