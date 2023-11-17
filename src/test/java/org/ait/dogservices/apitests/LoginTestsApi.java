package org.ait.dogservices.apitests;

import io.restassured.http.ContentType;
import org.ait.dogservices.api.AuthRequestDto;
import org.ait.dogservices.api.AuthResponseDto;
import org.ait.dogservices.api.ErrorDto;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LoginTestsApi extends TestBaseApi {

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
    public void loginWrongEmailTest() {

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
