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
    @BeforeMethod
            public void precondition(){
        String username = "nat@mail.com";
        String password = "Qwerty8888!";


        Response authResponse = RestAssured.given()
                .param("username", username)
                .param("password", password)
                .post("login");

    }

      AuthRequestDto requestDto = AuthRequestDto.builder()
              .username("nat@mail.com")
              .password("Qwerty8888!")
              .build();

    @Test
    public void loginSuccessTest(){

        AuthResponseDto dto =  given()
                .contentType("application/json")
                .body(requestDto)
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
